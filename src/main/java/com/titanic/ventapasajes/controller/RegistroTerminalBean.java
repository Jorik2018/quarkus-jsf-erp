package com.titanic.ventapasajes.controller;

import com.titanic.ventapasajes.ejb.TerminalFacadeLocal;
import java.io.Serializable;

import java.util.List;
import java.util.StringTokenizer;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import com.titanic.ventapasajes.modelo.Terminal;
import com.titanic.ventapasajes.jsf.FacesUtil;
import com.titanic.ventapasajes.util.NegocioExcepciones;
import com.titanic.ventapasajes.util.cdi.InjectedConfiguration;
import com.titanic.ventapasajes.util.jpa.Transaccion;
import com.titanic.ventapasajes.ws.*;
import java.util.ArrayList;
import jakarta.inject.Inject;

@Named
@ViewScoped
public class RegistroTerminalBean implements Serializable {

    private static final long serialVersionUID = 1L;

//    @Inject
//    @InjectedConfiguration(key="ruc")
//    String ruc;
//
//    @Inject
//    @InjectedConfiguration(key="usuario")
//    String usuario;
//
//    @Inject
//    @InjectedConfiguration(key="clave")
//    String clave;
//
//    @Inject
//    @InjectedConfiguration(key="partida")
//    String partida;
    @Inject
    private TerminalFacadeLocal terminalRepositorio;

    private Terminal terminal;

    public RegistroTerminalBean() {
        terminal = new Terminal();
    }

    public void inicializar() {

        if (this.terminal == null) {
            this.terminal = new Terminal();
        }
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void registrarTerminal() {

        StringTokenizer tokens = new StringTokenizer(terminal.getNombreTerminal(), "|");

        this.terminal.setCodeTerminal(tokens.nextToken());
        this.terminal.setNombreTerminal(tokens.nextToken());

        this.terminal = registrarTerminal(this.terminal);
        limpiarFormulario();
        FacesUtil.adicionarMensajeInfo("El terminal se registro correctamente");
    }

    @Transaccion
    public Terminal registrarTerminal(Terminal terminal) {

        Terminal terminalExistente = terminalRepositorio.buscarTerminalPorNombre(terminal.getNombreTerminal());

        if (terminalExistente != null && !terminalExistente.equals(terminal)) {
            throw new NegocioExcepciones("Ya existe una terminal con ese nombre, verificar");
        }
        terminalRepositorio.create(terminal);
        return terminal;
    }

    private void limpiarFormulario() {
        terminal = new Terminal();

    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    public boolean isEditando() {
        return this.terminal.getIdeTerminal() != null;
    }

    public List<com.titanic.ventapasajes.ws.Terminal> getTerminales() {
//        WSServiciosHR mtc = new WSServiciosHR();
//        WSServiciosHRSoap mtcClient = mtc.getWSServiciosHRSoap();
//        Seguridad seguridad = new Seguridad();
////        seguridad.setRuc(ruc);
////        seguridad.setUsuario(usuario);
////        seguridad.setClave(clave);
////        seguridad.setPartida(partida);
//
//        Parametro oParametro = new Parametro();
//        oParametro.setSeguridad(seguridad);
//        ResultParametro resultado = mtcClient.getParametro(oParametro);
//        ArrayOfTerminal arrayOfTerminal = resultado.getTerminales();
//        List<com.titanic.ventapasajes.ws.Terminal> terminales = arrayOfTerminal.getTerminal();
        List<com.titanic.ventapasajes.ws.Terminal> terminales = new ArrayList<com.titanic.ventapasajes.ws.Terminal>();
        com.titanic.ventapasajes.ws.Terminal t = new com.titanic.ventapasajes.ws.Terminal();
        t.setCode("01");
        t.setInfo("LIMA");
        terminales.add(t);
        t = new com.titanic.ventapasajes.ws.Terminal();
        t.setCode("02");
        t.setInfo("TRUJILLO");
        terminales.add(t);
        t = new com.titanic.ventapasajes.ws.Terminal();
        t.setCode("03");
        t.setInfo("CHIMBOTE");
        terminales.add(t);
        return terminales;
    }

}
