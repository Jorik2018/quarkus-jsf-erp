package com.titanic.ventapasajes.controller;

import com.titanic.ventapasajes.ejb.TerminalFacadeLocal;
import com.titanic.ventapasajes.modelo.Terminal;
import com.titanic.ventapasajes.jsf.FacesUtil;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jakarta.inject.Inject;

@ViewScoped
public class TerminalBean implements Serializable{

    private static final long serialVersionUID = 1592771145764176840L;

    @Inject
    private TerminalFacadeLocal terminalRepositorio;

    private List<Terminal> terminalesFiltrados;
    private Map filtros;

    private Terminal terminalSeleccionado;

    @PostConstruct
    public void init(){
        filtros = new HashMap();
        buscarTerminalesFiltros();
    }

    public void buscarTerminalesFiltros(){
        terminalesFiltrados = terminalRepositorio.listarTerminalesFiltrados(filtros);
    }

    public void eliminarTerminal(){

        terminalRepositorio.removerTerminal(terminalSeleccionado);
        terminalesFiltrados.remove(terminalSeleccionado);
        FacesUtil.adicionarMensajeInfo("Terminal " + terminalSeleccionado.getNombreTerminal() + " eliminado.");
    }

    public Terminal getTerminalSeleccionado() {
        return terminalSeleccionado;
    }

    public void setTerminalSeleccionado(Terminal terminalSeleccionado) {
        this.terminalSeleccionado = terminalSeleccionado;
    }

    public Map getFiltros() {
        return filtros;
    }

    public List<Terminal> getTerminalesFiltrados() {
        return terminalesFiltrados;
    }
}
