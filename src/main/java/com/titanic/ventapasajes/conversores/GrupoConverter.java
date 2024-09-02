package com.titanic.ventapasajes.conversores;

import com.titanic.ventapasajes.ejb.GrupoFacadeLocal;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import com.titanic.ventapasajes.modelo.Grupo;
import jakarta.inject.Inject;


@FacesConverter(forClass=Grupo.class)
public class GrupoConverter implements Converter{

	@Inject
	private GrupoFacadeLocal grupoRepositorio;
	
	public GrupoConverter(){
//		grupoRepositorio = CDIServiceLocator.getBean(GrupoRepositorio.class);
	}
	
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		Grupo retorno = null;
		
		if(value!=null){
			Long id = Long.parseLong(value);
			retorno = grupoRepositorio.find(id); 
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if(value!=null){
			Grupo grupo = (Grupo) value;
			return grupo.getIdeGrupo() == null ? null :  grupo.getIdeGrupo().toString();
		}
		
		return "";
	}

}
