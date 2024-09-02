package com.titanic.ventapasajes.conversores;

import com.titanic.ventapasajes.ejb.ProgramacionFacadeLocal;
import com.titanic.ventapasajes.modelo.Programacion;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(forClass = Programacion.class)
public class ProgramacionConverter implements Converter {

    private ProgramacionFacadeLocal programacionRepositorio;

    public ProgramacionConverter() {
//        this.programacionRepositorio = (ProgramacionRepositorio) CDIServiceLocator.getBean(ProgramacionRepositorio.class);
    }

    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Programacion retorno = null;

        if (value != null && !"".equals(value)) {
            retorno = this.programacionRepositorio.find(Long.parseLong(value));
        }

        return retorno;
    }

    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Programacion programacion = (Programacion) value;
            return programacion.getIdeProgramacion() == null ? null : programacion.getIdeProgramacion().toString();
        }

        return "";
    }
}