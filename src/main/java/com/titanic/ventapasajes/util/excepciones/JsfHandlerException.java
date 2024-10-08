package com.titanic.ventapasajes.util.excepciones;

import java.io.IOException;
import java.util.Iterator;

import jakarta.faces.FacesException;
import jakarta.faces.application.ViewExpiredException;
import jakarta.faces.context.ExceptionHandler;
import jakarta.faces.context.ExceptionHandlerWrapper;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ExceptionQueuedEvent;
import jakarta.faces.event.ExceptionQueuedEventContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.titanic.ventapasajes.util.NegocioExcepciones;
import com.titanic.ventapasajes.jsf.FacesUtil;

public class JsfHandlerException extends ExceptionHandlerWrapper{

	private ExceptionHandler wrapped;
	
	private static Log log = LogFactory.getLog(JsfHandlerException.class);
	
	public JsfHandlerException(ExceptionHandler wrapped){
		this.wrapped = wrapped;
	}
	
	@Override
	public ExceptionHandler getWrapped() {
		return this.wrapped;
	}

	@SuppressWarnings("null")
	@Override
	public void handle() throws FacesException {
		
		Iterator<ExceptionQueuedEvent> eventos = getUnhandledExceptionQueuedEvents().iterator();
		while(eventos.hasNext()){
			ExceptionQueuedEvent evento = eventos.next();
			ExceptionQueuedEventContext contexto = (ExceptionQueuedEventContext)evento.getSource();
			
			Throwable excepcion = contexto.getException();
			
			NegocioExcepciones negocioExcepciones = getNegocioExcepciones(excepcion);
			
			boolean handled = false;
			
			try {
				if(excepcion instanceof ViewExpiredException){
					handled = true;
					redireccionar("/");
				}else if(negocioExcepciones!=null){
					handled = true;
					log.error("Error del sistema: " + excepcion.getMessage(), excepcion);
					FacesUtil.adicionarMensajeError(negocioExcepciones.getMessage());
				}else{
					handled = true;
					log.error("Error del sistema: " + excepcion.getMessage(), excepcion);
					redireccionar("/excepciones/error.xhtml");

				}
			} finally {
				if(handled){
					eventos.remove();
				}
				
			}
		}
		getWrapped().handle();
	}
	
	private NegocioExcepciones getNegocioExcepciones(Throwable excepcion){
		if(excepcion instanceof NegocioExcepciones){
			return (NegocioExcepciones)excepcion;
		}else if(excepcion.getCause()!=null){
			return getNegocioExcepciones(excepcion.getCause());
		}
		return null;
	}
	
	private void redireccionar(String pagina){
		try{
			FacesContext facesContexto = FacesContext.getCurrentInstance();
			ExternalContext externalContext = facesContexto.getExternalContext();
			String contextoPath = externalContext.getRequestContextPath();
			
			externalContext.redirect(contextoPath + pagina);
			facesContexto.responseComplete();
		}catch(IOException e){
			throw new FacesException(e);
		}
	}
	
}
