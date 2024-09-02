package com.titanic.ventapasajes.conversores;

import com.titanic.ventapasajes.ejb.RecorridoFacadeLocal;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

import com.titanic.ventapasajes.modelo.Recorrido;
import jakarta.inject.Inject;

@FacesConverter(forClass=Recorrido.class)
public class RecorridoConverter implements Converter {

    @Inject
    private RecorridoFacadeLocal recorridoRepositorio;

    public RecorridoConverter() {
//        this.recorridoRepositorio = (RecorridoRepositorio) CDIServiceLocator.getBean(RecorridoRepositorio.class);
    }

    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Recorrido retorno = null;

        if (value != null && !"".equals(value)) {
            retorno = this.recorridoRepositorio.find(Long.parseLong(value));
        }

        return retorno;
    }

    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value!=null){
            Recorrido recorrido = (Recorrido) value;
            return recorrido.getIdeRecorrido() == null ? null :  recorrido.getIdeRecorrido().toString();
        }
        return "";
    }

}
