package com.titanic.ventapasajes.util.cdi;
import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import jakarta.enterprise.context.ContextNotActiveException;
import jakarta.enterprise.context.spi.Context;
import jakarta.enterprise.context.spi.Contextual;
import jakarta.enterprise.context.spi.CreationalContext;
import jakarta.faces.view.ViewScoped;
import jakarta.faces.component.UIViewRoot;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.PreDestroyViewMapEvent;
import jakarta.faces.event.SystemEvent;
import jakarta.faces.event.SystemEventListener;

/**
 * Copied from Seam Faces 3.1.0.
 * 
 * @author Steve Taylor
 */
public class ViewScopedContext implements Context, SystemEventListener {

	@SuppressWarnings("unchecked")
	public <T> T get(final Contextual<T> component) {
		assertActive();

		if (!isJsfSubscribed) {
			FacesContext.getCurrentInstance().getApplication().subscribeToEvent(PreDestroyViewMapEvent.class, this);
			isJsfSubscribed = true;
		}

		T instance = (T) getComponentInstanceMap().get(component);

		return instance;
	}

	@SuppressWarnings("unchecked")
	public <T> T get(final Contextual<T> component, final CreationalContext<T> creationalContext) {
		assertActive();

		T instance = get(component);
		if (instance == null) {
			if (creationalContext != null) {
				Map<Contextual<?>, Object> componentInstanceMap = getComponentInstanceMap();
				Map<Contextual<?>, CreationalContext<?>> creationalContextMap = getCreationalInstanceMap();

				synchronized (componentInstanceMap) {
					instance = (T) componentInstanceMap.get(component);
					if (instance == null) {
						instance = component.create(creationalContext);
						if (instance != null) {
							componentInstanceMap.put(component, instance);
							creationalContextMap.put(component, creationalContext);
						}
					}
				}
			}
		}

		return instance;
	}

	public Class<? extends Annotation> getScope() {
		return ViewScoped.class;
	}

	public boolean isActive() {
		return getViewRoot() != null;
	}

	private void assertActive() {
		if (!isActive()) {
			throw new ContextNotActiveException(
					"Seam context with scope annotation @ViewScoped is not active with respect to the current thread");
		}
	}

	public boolean isListenerForSource(final Object source) {
		if (source instanceof UIViewRoot) {
			return true;
		}

		return false;
	}

	/**
	 * We get PreDestroyViewMapEvent events from the JSF servlet and destroy our
	 * contextual instances. This should (theoretically!) also get fired if the
	 * webapp closes, so there should be no need to manually track all view
	 * scopes and destroy them at a shutdown.
	 * 
	 * @see jakarta.faces.event.SystemEventListener#processEvent(jakarta.faces.event.SystemEvent)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void processEvent(final SystemEvent event) {
		if (event instanceof PreDestroyViewMapEvent) {
			Map<Contextual<?>, Object> componentInstanceMap = getComponentInstanceMap();
			Map<Contextual<?>, CreationalContext<?>> creationalContextMap = getCreationalInstanceMap();

			if (componentInstanceMap != null) {
				for (Map.Entry<Contextual<?>, Object> componentEntry : componentInstanceMap.entrySet()) {
					/*
					 * No way to inform the compiler of type <T> information, so
					 * it has to be abandoned here :(
					 */
					Contextual contextual = componentEntry.getKey();
					Object instance = componentEntry.getValue();
					CreationalContext creational = creationalContextMap.get(contextual);

					contextual.destroy(instance, creational);
				}
			}
		}
	}

	protected UIViewRoot getViewRoot() {
		FacesContext context = FacesContext.getCurrentInstance();

		if (context != null) {
			return context.getViewRoot();
		}

		return null;
	}

	protected Map<String, Object> getViewMap() {
		UIViewRoot viewRoot = getViewRoot();

		if (viewRoot != null) {
			return viewRoot.getViewMap(true);
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	private Map<Contextual<?>, Object> getComponentInstanceMap() {
		Map<String, Object> viewMap = getViewMap();
		Map<Contextual<?>, Object> map = (ConcurrentHashMap<Contextual<?>, Object>) viewMap.get(COMPONENT_MAP_NAME);

		if (map == null) {
			map = new ConcurrentHashMap<Contextual<?>, Object>();
			viewMap.put(COMPONENT_MAP_NAME, map);
		}

		return map;
	}

	@SuppressWarnings("unchecked")
	private Map<Contextual<?>, CreationalContext<?>> getCreationalInstanceMap() {
		Map<String, Object> viewMap = getViewMap();
		Map<Contextual<?>, CreationalContext<?>> map = (Map<Contextual<?>, CreationalContext<?>>) viewMap
				.get(CREATIONAL_MAP_NAME);

		if (map == null) {
			map = new ConcurrentHashMap<Contextual<?>, CreationalContext<?>>();
			viewMap.put(CREATIONAL_MAP_NAME, map);
		}

		return map;
	}

	private final static String COMPONENT_MAP_NAME = "org.jboss.seam.faces.viewscope.componentInstanceMap";

	private final static String CREATIONAL_MAP_NAME = "org.jboss.seam.faces.viewscope.creationalInstanceMap";

	private boolean isJsfSubscribed = false;
}