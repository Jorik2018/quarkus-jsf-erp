package com.titanic.ventapasajes.controller;

import com.titanic.ventapasajes.ejb.RecorridoFacadeLocal;
import com.titanic.ventapasajes.ejb.TerminalFacadeLocal;
import com.titanic.ventapasajes.modelo.*;
import com.titanic.ventapasajes.jsf.FacesUtil;
//import org.primefaces.context.RequestContext;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jakarta.inject.Inject;

@ViewScoped
public class RecorridoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private RecorridoFacadeLocal recorridoRepositorio;

    @Inject
    private TerminalFacadeLocal terminalRepositorio;

    private List<Terminal> terminales = new ArrayList<>();

    private List<Terminal> terminalesDestino = new ArrayList<>();

    public List<Terminal> getTerminalesDestino() {
        return terminalesDestino;
    }

    public void setTerminalesDestino(List<Terminal> terminalesDestino) {
        this.terminalesDestino = terminalesDestino;
    }

    public List<Terminal> getTerminales() {
        return terminales;
    }

    public void setTerminales(List<Terminal> terminales) {
        this.terminales = terminales;
    }

    private List<Recorrido> recorridosFiltrados;
    private HashMap filtros;

    private Recorrido recorridoSeleccionado;


    @PostConstruct
    public void init() {

        terminales = terminalRepositorio.findAll();
        terminalesDestino = terminalRepositorio.findAll();

        filtros = new HashMap();
        buscarRecorridosFiltros();


    }


    public void buscarRecorridosFiltros() {
        recorridosFiltrados = recorridoRepositorio.listarRecorridosFiltrados(filtros);
    }

    public void selectRecorridoFromDialog(Recorrido recorrido) {
        //RequestContext.getCurrentInstance().closeDialog(recorrido);
    }

    public void eliminarRecorrido() {
        recorridoRepositorio.removerRecorrido(recorridoSeleccionado);
        recorridosFiltrados.remove(recorridoSeleccionado);
        FacesUtil.adicionarMensajeInfo("Recorrido " + recorridoSeleccionado.getRuta() + " eliminado.");
    }

    public Recorrido getRecorridoSeleccionado() {
        return recorridoSeleccionado;
    }

    public void setRecorridoSeleccionado(Recorrido recorridoSeleccionado) {
        this.recorridoSeleccionado = recorridoSeleccionado;
    }

    public Map getFiltros() {
        return filtros;
    }

    public List<Recorrido> getRecorridosFiltrados() {
        return recorridosFiltrados;
    }
}
