package com.titanic.ventapasajes.conversores;

import com.titanic.ventapasajes.ejb.HojaRutaFacadeLocal;
import com.titanic.ventapasajes.modelo.HojaRuta;
import jakarta.inject.Inject;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(forClass=HojaRuta.class)
public class HojaRutaConverter implements Converter  {

    @Inject
    private HojaRutaFacadeLocal hojaRutaRepositorio;

    public HojaRutaConverter() {
//        this.hojaRutaRepositorio =  CDIServiceLocator.getBean(HojaRutaRepositorio.class);
    }


    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        HojaRuta retorno = null;

        if (value != null && !"".equals(value)) {
            retorno = this.hojaRutaRepositorio.find(Long.parseLong(value));
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if(value!=null){
            HojaRuta hojaRuta = (HojaRuta) value;
            return hojaRuta.getIdeHojaRuta() == null ? null :  hojaRuta.getIdeHojaRuta().toString();
        }

        return "";
    }
}
