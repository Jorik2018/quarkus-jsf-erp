package com.titanic.ventapasajes.conversores;

import com.titanic.ventapasajes.ejb.TarifaGeneralFacadeLocal;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

import com.titanic.ventapasajes.modelo.TarifaGeneral;
import com.titanic.ventapasajes.util.cdi.CDIServiceLocator;
import jakarta.inject.Inject;

@FacesConverter(forClass=TarifaGeneral.class)
public class TarifaGeneralConverter implements Converter{

    @Inject
    private TarifaGeneralFacadeLocal repositorio;

    public TarifaGeneralConverter() {
//        this.repositorio = (TarifaGeneralRepositorio) CDIServiceLocator.getBean(TarifaGeneralRepositorio.class);
    }

    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        TarifaGeneral retorno = null;
        if (value != null) {
            retorno = this.repositorio.find(Long.parseLong(value));
        }
        return retorno;
    }

    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value!=null){
            TarifaGeneral tarifaGeneral = (TarifaGeneral) value;
            return tarifaGeneral.getIdeTarifaGeneral() == null ? null :  tarifaGeneral.getIdeTarifaGeneral().toString();
        }
        return "";


    }
}
