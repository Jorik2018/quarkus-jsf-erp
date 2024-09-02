package com.titanic.ventapasajes.controller;

import com.titanic.ventapasajes.ejb.ConductorFacadeLocal;
import com.titanic.ventapasajes.jsf.FacesUtil;
import com.titanic.ventapasajes.modelo.Conductor;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jakarta.inject.Inject;

@Named
@ViewScoped
public class ConductorController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ConductorFacadeLocal conductorRepositorio;

    @PostConstruct
    public void init(){
        filtros = new HashMap();
        buscarConductoresFiltrados();
    }

    private List<Conductor> conductoresFiltrados;
    private Map filtros;
    private Conductor conductorSeleccionado;

    public void buscarConductoresFiltrados(){
        conductoresFiltrados = conductorRepositorio.listarConductoresFiltrados(filtros);
    }

    public void eliminarConductor(){
        conductorRepositorio.removerConductor(conductorSeleccionado);
        conductoresFiltrados.remove(conductorSeleccionado);
        FacesUtil.adicionarMensajeInfo("Conductor "+conductorSeleccionado.getNombreConductor() +" eliminado.");
    }



    public List<Conductor> getConductoresFiltrados() {
        return conductoresFiltrados;
    }

    public void setConductoresFiltrados(List<Conductor> conductoresFiltrados) {
        this.conductoresFiltrados = conductoresFiltrados;
    }

    public Map getFiltros() {
        return filtros;
    }

    public void setFiltros(Map filtros) {
        this.filtros = filtros;
    }

    public Conductor getConductorSeleccionado() {
        return conductorSeleccionado;
    }

    public void setConductorSeleccionado(Conductor conductorSeleccionado) {
        this.conductorSeleccionado = conductorSeleccionado;
    }
    
}
