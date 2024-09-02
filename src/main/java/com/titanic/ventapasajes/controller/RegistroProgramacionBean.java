package com.titanic.ventapasajes.controller;

import com.titanic.ventapasajes.ejb.BusFacadeLocal;
import com.titanic.ventapasajes.ejb.ProgramacionFacadeLocal;
import com.titanic.ventapasajes.jsf.FacesUtil;
import com.titanic.ventapasajes.modelo.*;
//import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import java.io.Serializable;
import jakarta.inject.Inject;
import jakarta.faces.view.ViewScoped;

@ViewScoped
public class RegistroProgramacionBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private BusFacadeLocal busRepositorio;

    private Programacion programacion;


    public void seleccionarBus() {
        //RequestContext.getCurrentInstance().openDialog("seleccionarBus");
    }


    public void seleccionarRuta() {
        //RequestContext.getCurrentInstance().openDialog("seleccionarRuta");
    }


    public void inicializar(){

        if (this.programacion == null) {
            this.programacion = new Programacion();
            programacion.setTipoProgramacion(TipoProgramacion.ABIERTO);
        }
    }


@Inject
    private ProgramacionFacadeLocal programacionRepositorio;
    
    public void registrarProgramacion(){

        if(programacion.getRuta() ==null || programacion.getBus() == null){

            FacesUtil.adicionarMensajeError("Ud. debe ingresar Ruta y Bus para este viaje");
            return;
        }

        programacionRepositorio.create(this.programacion);
        limpiarFormulario();
        FacesUtil.adicionarMensajeInfo("La programación se registro correctamente");
    }

    public Programacion getProgramacion() {
        return programacion;
    }

    public void setProgramacion(Programacion programacion) {
        this.programacion = programacion;
    }



    private void limpiarFormulario(){
        programacion = new Programacion();

    }

    public boolean isEditando(){
        return this.programacion.getIdeProgramacion() !=null;
    }




    public TipoProgramacion[] getTipoProgramacion() {
        return TipoProgramacion.values();
    }





    public void onRutaSeleccionada(SelectEvent event) {
        Recorrido recorrido = (Recorrido) event.getObject();

        this.programacion.setRuta(recorrido);


        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ruta Seleccionada", "Id:" + recorrido.getRuta());

        FacesContext.getCurrentInstance().addMessage(null, message);
    }


    public void onBusSeleccionado(SelectEvent event) {
        Bus busSeleccionado = (Bus) event.getObject();
        this.programacion.setBus(busRepositorio.getFilasWithBusById(busSeleccionado.getIdeBus()));
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bus Seleccionado", "Id:" + busSeleccionado.getDescripcionBus());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}