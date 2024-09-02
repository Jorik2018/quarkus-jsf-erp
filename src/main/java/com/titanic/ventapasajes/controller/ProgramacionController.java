package com.titanic.ventapasajes.controller;

import com.titanic.ventapasajes.ejb.ProgramacionFacadeLocal;
import com.titanic.ventapasajes.modelo.Programacion;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import jakarta.inject.Inject;

@ViewScoped
public class ProgramacionController  implements Serializable {

    private static final long serialVersionUID = 1592771145764176840L;

    private List<Programacion> programacionesFiltradas;
    private HashMap filtros;

    private Programacion programacionSeleccionada;

    @Inject
    private ProgramacionFacadeLocal programacionRepositorio;

    @PostConstruct
    public void init(){
        filtros = new HashMap();
        buscarProgramacionesFiltradas();
    }



    public void buscarProgramacionesFiltradas(){
        programacionesFiltradas = programacionRepositorio.listarProgramacionesFiltradas(filtros);
    }

    public void eliminarProgramacion(){
        programacionRepositorio.removerProgramacion(programacionSeleccionada);
        programacionesFiltradas.remove(programacionSeleccionada);
        //FacesUtil.adicionarMensajeInfo("Programacion " + programacionSeleccionada.getHoraSalida()
        //        + " " + programacionSeleccionada.getHoraLlegada()+ " eliminada.");
    }


    public List<Programacion> getProgramacionesFiltradas() {
        return programacionesFiltradas;
    }

    public void setProgramacionesFiltradas(List<Programacion> programacionesFiltradas) {
        this.programacionesFiltradas = programacionesFiltradas;
    }


    public HashMap getFiltros() {
        return filtros;
    }

    public void setFiltros(HashMap filtros) {
        this.filtros = filtros;
    }

    public Programacion getProgramacionSeleccionada() {
        return programacionSeleccionada;
    }

    public void setProgramacionSeleccionada(Programacion programacionSeleccionada) {
        this.programacionSeleccionada = programacionSeleccionada;
    }
}