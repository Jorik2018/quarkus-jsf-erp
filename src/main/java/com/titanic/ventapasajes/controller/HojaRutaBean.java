package com.titanic.ventapasajes.controller;

import com.titanic.ventapasajes.ejb.HojaRutaFacadeLocal;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import com.titanic.ventapasajes.jsf.FacesUtil;
import com.titanic.ventapasajes.modelo.HojaRuta;
import java.util.HashMap;
import java.util.Map;
import jakarta.inject.Inject;

@Named
@ViewScoped
public class HojaRutaBean implements Serializable {

    private static final long serialVersionUID = 1592771145764176840L;

    @Inject
    private HojaRutaFacadeLocal hojaRutaRepositorio;
    private Map filtros;
    private List<HojaRuta> hojaRutasFiltrados;
    private HojaRuta hojaRutaSeleccionada;

    @PostConstruct
    public void init(){
        filtros = new HashMap();

        Calendar calendar = Calendar.getInstance();
        filtros.put("fechaHasta",calendar.getTime());
        calendar.add(Calendar.DAY_OF_YEAR, -30);
        filtros.put("fechaDesde",calendar.getTime());


        buscarHojaRutaFiltros();
    }

    public void buscarHojaRutaFiltros() {
        hojaRutasFiltrados = hojaRutaRepositorio.listarHojaRutaFiltrados(filtros);
    }


    public void eliminarHojaRuta(){
        hojaRutaRepositorio.removerHojaRuta(hojaRutaSeleccionada);
        hojaRutasFiltrados.remove(hojaRutaSeleccionada);
        FacesUtil.adicionarMensajeInfo("Hoja Ruta "+hojaRutaSeleccionada.getCodigoHojaRuta() +" eliminada.");
    }

    public List<HojaRuta> getHojaRutasFiltrados() {
        return hojaRutasFiltrados;
    }

    public Map getFiltros() {
        return filtros;
    }

    public HojaRuta getHojaRutaSeleccionada() {
        return hojaRutaSeleccionada;
    }

    public void setHojaRutaSeleccionada(HojaRuta hojaRutaSeleccionada) {
        this.hojaRutaSeleccionada = hojaRutaSeleccionada;
    }
}
