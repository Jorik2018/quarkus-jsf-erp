package com.titanic.ventapasajes.conversores;

import com.titanic.ventapasajes.ejb.ConductorFacadeLocal;
import com.titanic.ventapasajes.modelo.Conductor;
import jakarta.inject.Inject;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(forClass=Conductor.class)
public class ConductorConverter implements Converter {

    @Inject
    private ConductorFacadeLocal conductorRepositorio;

    public ConductorConverter() {
//        this.conductorRepositorio = (ConductorRepositorio) CDIServiceLocator.getBean(ConductorRepositorio.class);
    }


    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        Conductor retorno = null;
        if (value != null && !"".equals(value)) {
            retorno = this.conductorRepositorio.find(Long.parseLong(value));
        }
        return retorno;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {

        if(value!=null){
            Conductor conductor = (Conductor) value;
            return conductor.getIdeConductor() == null ? null :  conductor.getIdeConductor().toString();
        }

        return "";
    }
    
}
