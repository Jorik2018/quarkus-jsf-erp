package com.titanic.ventapasajes.controller;

import com.titanic.ventapasajes.ejb.ProgramacionFacadeLocal;
import com.titanic.ventapasajes.modelo.Programacion;
import org.primefaces.event.SelectEvent;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.view.ViewScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jakarta.inject.Inject;


@Named
@ViewScoped
public class SeleccionarBusBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private Date fechaVenta = new Date();

    @Inject
    private ProgramacionFacadeLocal programacionRepositorio;

    private List<Programacion> programaciones;

    public void inicializar() {
        Map filtros = new HashMap();
        filtros.put("fechaProgramacion",fechaVenta);
        this.programaciones = programacionRepositorio.listarProgramacionesFiltradas(filtros);
    }
    
    public void onFechaSeleccionada(SelectEvent event) {
        Date nuevaFecha = (Date) event.getObject();

        this.setFechaVenta(nuevaFecha);


        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fecha Modificada", "Fecha Venta:" + fechaVenta);

        FacesContext.getCurrentInstance().addMessage(null, message);
    }



    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }


    public List<Programacion> getProgramaciones() {
        return programaciones;
    }

    public void setProgramaciones(List<Programacion> programaciones) {
        this.programaciones = programaciones;
    }
}