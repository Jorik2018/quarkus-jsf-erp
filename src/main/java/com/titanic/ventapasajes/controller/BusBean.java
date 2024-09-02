package com.titanic.ventapasajes.controller;

import com.titanic.ventapasajes.ejb.BusFacadeLocal;
import com.titanic.ventapasajes.modelo.Bus;
import com.titanic.ventapasajes.jsf.FacesUtil;
//import org.primefaces.context.RequestContext;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jakarta.inject.Inject;

@Named
@ViewScoped
public class BusBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private BusFacadeLocal busRepositorio;

    private List<Bus> busesFiltrados;
    private Map filtros;

    private Bus busSeleccionado;


    @PostConstruct
    public void init(){
        filtros = new HashMap();
        buscarBusFiltros();
    }


    public void buscarBusFiltros(){
        busesFiltrados = busRepositorio.listarBusesFiltrados(filtros);

    }

    public void eliminarBus(){
        busRepositorio.removerBus(busSeleccionado);
        busesFiltrados.remove(busSeleccionado);
        FacesUtil.adicionarMensajeInfo("Bus " + busSeleccionado.getDescripcionBus() + " eliminado.");
    }


    public void selectBusFromDialog(Bus bus) {
        //RequestContext.getCurrentInstance().closeDialog(bus);
    }

    public Bus getBusSeleccionado() {
        return busSeleccionado;
    }

    public void setBusSeleccionado(Bus busSeleccionado) {
        this.busSeleccionado = busSeleccionado;
    }

    public Map getFiltros() {
        return filtros;
    }

    public List<Bus> getBusesFiltrados() {
        return busesFiltrados;
    }
}
