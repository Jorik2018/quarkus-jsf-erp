package com.titanic.ventapasajes.controller;

import com.titanic.ventapasajes.ejb.ConductorFacadeLocal;
import com.titanic.ventapasajes.jsf.FacesUtil;
import com.titanic.ventapasajes.modelo.Conductor;
import com.titanic.ventapasajes.modelo.Sexo;
import com.titanic.ventapasajes.util.NegocioExcepciones;
import com.titanic.ventapasajes.util.jpa.Transaccion;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import jakarta.inject.Inject;

@Named
@ViewScoped
public class RegistroConductorBean implements Serializable{
@Transaccion
    public Conductor registrarConductor(Conductor conductor) {

        Conductor conductorExistente = conductorRepositorio.obtenerConductorPorNumeroDocumento(conductor.getNumeroDocumento());

        if (conductorExistente != null && !conductorExistente.equals(conductor)) {
            throw new NegocioExcepciones("Ya existe un conductor con ese Numero de Documento, verificar");
        }
        conductorRepositorio.create(conductor);
        return conductor;
    }

    @Transaccion
    public Conductor adicionarConductor(Conductor conductor) {
        Conductor conductorExistente = conductorRepositorio.obtenerConductorPorNumeroDocumento(conductor.getNumeroDocumento());
        if (conductorExistente != null) {
            conductorExistente.setNombreConductor(conductor.getNombreConductor());
            conductorExistente.setFechaNacimiento(conductor.getFechaNacimiento());
            conductorExistente.setNumeroLicencia(conductor.getNumeroLicencia());
            conductorExistente.setFechaExpedicion(conductor.getFechaExpedicion());
            conductorExistente.setFechaRevalidacion(conductor.getFechaRevalidacion());
            conductorExistente.setEstado(conductor.isEstado());
            conductorExistente.setEntidad(conductor.getEntidad());
            conductorExistente.setLocalidad(conductor.getLocalidad());
            conductorExistente.setNumeroCertificado(conductor.getNumeroCertificado());
            conductorExistente.setFechaCaducidad(conductor.getFechaCaducidad());
            conductorExistente.setEstadoCapacitacion(conductor.isEstadoCapacitacion());
        } else {
            conductorExistente = conductor;
        }
        conductorRepositorio.create(conductorExistente);
        return conductorExistente;
    }
    private static final long serialVersionUID = 1L;

    @Inject
    private ConductorFacadeLocal conductorRepositorio;

    private Conductor conductor;


    public void inicializar(){


        if (this.conductor == null) {
            this.conductor = new Conductor();
        }
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public void registrarConductor(){
        this.conductor = registrarConductor(this.conductor);
        FacesUtil.adicionarMensajeInfo("El conductor se registro correctamente");
    }

    public boolean isEditando(){
        return this.conductor.getIdeConductor() !=null;
    }

    public Sexo[] getSexo() {
        return Sexo.values();
    }
}
