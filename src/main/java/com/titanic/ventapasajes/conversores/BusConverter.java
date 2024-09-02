package com.titanic.ventapasajes.conversores;

import com.titanic.ventapasajes.ejb.BusFacadeLocal;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

import com.titanic.ventapasajes.modelo.Bus;
import jakarta.inject.Inject;

@FacesConverter(forClass = Bus.class)
public class BusConverter implements Converter {
    @Inject
    private BusFacadeLocal busRepositorio;

    public BusConverter() {
//        this.busRepositorio = CDIServiceLocator.getBean(BusRepositorio.class);
    }

    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Bus retorno = null;

        if (value != null && !"".equals(value)) {
            retorno = this.busRepositorio.find(Long.parseLong(value));
        }

        return retorno;
    }

    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Bus bus = (Bus) value;
            return bus.getIdeBus() == null ? null : bus.getIdeBus().toString();
        }
        return "";
    }

}
