package com.titanic.ventapasajes.controller;

import com.titanic.ventapasajes.ejb.RecorridoFacadeLocal;
import com.titanic.ventapasajes.ejb.TerminalFacadeLocal;
import com.titanic.ventapasajes.modelo.Recorrido;
import com.titanic.ventapasajes.modelo.TarifaGeneral;
import com.titanic.ventapasajes.modelo.Terminal;
import com.titanic.ventapasajes.modelo.Ruta;
import com.titanic.ventapasajes.modelo.TipoAsiento;
import com.titanic.ventapasajes.jsf.FacesUtil;
import com.titanic.ventapasajes.util.NegocioExcepciones;
import com.titanic.ventapasajes.ws.*;
import org.primefaces.event.CellEditEvent;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.view.ViewScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import jakarta.inject.Inject;

@Named
@ViewScoped
public class RegistroRecorridoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private RecorridoFacadeLocal recorridoRepositorio;

    @Inject
    private TerminalFacadeLocal terminalRepositorio;

//    @Inject
//    @InjectedConfiguration(key = "ruc")
//    String ruc;
//
//    @Inject
//    @InjectedConfiguration(key = "usuario")
//    String usuario;
//
//    @Inject
//    @InjectedConfiguration(key = "clave")
//    String clave;
//
//    @Inject
//    @InjectedConfiguration(key = "partida")
//    String partida;
    private List<Terminal> terminales;

    private Recorrido recorrido;

    public Recorrido registrarRecorrido(Recorrido recorrido) {

        Recorrido recorridoExistente = recorridoRepositorio.obtenerRecorridoPorRuta(recorrido.getRuta());

        if (recorridoExistente != null && !recorridoExistente.equals(recorrido)) {
            throw new NegocioExcepciones("Ya existe un recorrido con esa Ruta, verificar");
        }

        return recorridoRepositorio.adicionarRecorrido(recorrido);
    }

    public void inicializar() {
        if (!FacesUtil.isPostback()) {
            terminales = terminalRepositorio.findAll();
            if (this.recorrido == null) {
                this.recorrido = new Recorrido();
                recorrido.setRuta("ORIGEN-DESTINO");
            }
            if (recorrido.getPrecios() == null || recorrido.getPrecios().isEmpty()) {
                List<TarifaGeneral> precios = new ArrayList<>();
                for (TipoAsiento tipoAsiento : TipoAsiento.values()) {
                    TarifaGeneral precio = new TarifaGeneral();
                    precio.setPrecio(new BigDecimal("0.00"));
                    precio.setTipoAsiento(tipoAsiento);
                    precio.setTipoPasaje("INGRESE CONCEPTO");
                    precio.setRecorrido(this.recorrido);
                    precios.add(precio);
                }
                recorrido.setPrecios(precios);
            }
        }
    }

    public List<Terminal> getTerminales() {
        return terminales;
    }

    public void setTerminales(List<Terminal> terminales) {
        this.terminales = terminales;
    }

    public void registrarRecorrido() {

        StringTokenizer tokens = new StringTokenizer(recorrido.getRuta(), "|");

        this.recorrido.setCodeRuta(tokens.nextToken());
        this.recorrido.setRuta(tokens.nextToken());

        this.recorrido = registrarRecorrido(this.recorrido);
        limpiarFormulario();
        FacesUtil.adicionarMensajeInfo("El Recorrido se registro correctamente");
    }

    private void limpiarFormulario() {
        recorrido = new Recorrido();
    }

    public Recorrido getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(Recorrido recorrido) {
        this.recorrido = recorrido;
    }

    public TipoAsiento[] getTiposAsientos() {
        return TipoAsiento.values();
    }

    public boolean isEditando() {
        return this.recorrido.getIdeRecorrido() != null;
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Destino modificado", "Anterior: " + oldValue + ", Nuevo:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public List<Ruta> getRutas() {

//        WSServiciosHR mtc = new WSServiciosHR();
//        WSServiciosHRSoap mtcClient = mtc.getWSServiciosHRSoap();
//
////        Seguridad seguridad = new Seguridad();
////        seguridad.setRuc(ruc);
////        seguridad.setUsuario(usuario);
////        seguridad.setClave(clave);
////        seguridad.setPartida(partida);
//
//        Parametro oParametro = new Parametro();
////        oParametro.setSeguridad(seguridad);
//
//        ResultParametro resultado = mtcClient.getParametro(oParametro);
//
//        ArrayOfRuta rutasArray = resultado.getRutas();
//        List<Ruta> rutas = rutasArray.getRuta();
        List<Ruta> terminales = new ArrayList<Ruta>();
        Ruta t = new Ruta();
        t.setCode("01");
        t.setInfo("LIMA");
        terminales.add(t);
        t = new Ruta();
        t.setCode("02");
        t.setInfo("TRUJILLO");
        terminales.add(t);
        t = new Ruta();
        t.setCode("03");
        t.setInfo("CHIMBOTE");
        terminales.add(t);
        return terminales;
    }

}
