package com.titanic.ventapasajes.controller;

import com.titanic.ventapasajes.ejb.ClienteFacadeLocal;
import com.titanic.ventapasajes.ejb.ProgramacionFacadeLocal;
import com.titanic.ventapasajes.ejb.VentaFacadeLocal;
import com.titanic.ventapasajes.modelo.*;
//import com.titanic.ventapasajes.security.Seguridad;
import com.titanic.ventapasajes.util.jpa.Transaccion;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.view.ViewScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import jakarta.inject.Inject;
//import org.jsuns.util.Pegasus;

@ViewScoped
public class InformacionClientesBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private VentaFacadeLocal ventaService;

    @Inject
    private ProgramacionFacadeLocal programacionService;

    @Inject
    private ClienteFacadeLocal clienteRepositorio;

//    @Inject
//    private HttpServletRequest request;
//    @Inject
//    private Seguridad seguridad;
    private Programacion programacion;
    private Venta venta;
    private List<Boleto> boletosReservados = new ArrayList<>();
    private List<Boleto> boletosPagados = new ArrayList<>();

    @PostConstruct
    public void init() {
        /*String programacionId = (String) Pegasus.getSession().getAttribute("programacionId");
        programacion = programacionService.find(Long.valueOf(programacionId));
        venta = ventaService.obtenerVenta(programacion);
        obtenerBoletosReservadosYPagados();*/
    }

    private void obtenerBoletosReservadosYPagados() {

        for (FilaBoleto filaBoleto : venta.getFilasBoletos()) {

            for (Boleto boleto : filaBoleto.getBoletos()) {

                if (boleto.getEstadoBoleto() == EstadoAsiento.RESERVADO) {

//                    if (boleto.getUsuario().getIdeUsuario() == seguridad.getUsuarioLogeado().getUsuario().getIdeUsuario()) {
//                        Cliente cliente = new Cliente();
//                        cliente.setEdad(0);
//                        cliente.setSexo(Sexo.FEMENINO);
//                        cliente.setTipoDocumento(TipoDocumento.DNI);
//                        cliente.setTipoPersona(TipoPersona.NATURAL);
//                        cliente.setDebePresentarCartaNotarial(false);
//                        boleto.setCliente(cliente);
//                        boletosReservados.add(boleto);
//                    }
                }

                if (boleto.getEstadoBoleto() == EstadoAsiento.PAGADO) {
                    boletosPagados.add(boleto);
                }
            }
        }

    }

    public List<String> completeClientes(String query) {
        List<Cliente> todosLosClientes = clienteRepositorio.findAll();
        List<String> dnisFiltrados = new ArrayList<>();

        for (Cliente cliente : todosLosClientes) {
            if (cliente.getNumeroDocumento().toLowerCase().startsWith(query)) {
                dnisFiltrados.add(cliente.getNumeroDocumento());
            }
        }
        return dnisFiltrados;
    }

    public void setearCliente(Boleto boleto) {

        Cliente cliente = boleto.getCliente();

        if (cliente != null) {
            Cliente clienteBD = clienteRepositorio.obtenerClientePorNumeroDocumento(cliente.getNumeroDocumento());
            cliente.setNumeroDocumento(clienteBD.getNumeroDocumento());
            cliente.setEdad(clienteBD.getEdad());
            cliente.setSexo(clienteBD.getSexo());
            cliente.setNombreCliente(clienteBD.getNombreCliente());
            cliente.setIdeCliente(clienteBD.getIdeCliente());
            cliente.setNumeroTelefono(clienteBD.getNumeroTelefono());
        }

    }

    public Cliente adicionarCliente(Cliente cliente) {

        Cliente clienteExistente = clienteRepositorio.obtenerClientePorNumeroDocumento(cliente.getNumeroDocumento());
        if (clienteExistente != null) {
            clienteExistente.setNombreCliente(cliente.getNombreCliente());
            clienteExistente.setEdad(cliente.getEdad());
            clienteExistente.setSexo(cliente.getSexo());
        } else {
            clienteExistente = cliente;
        }

        clienteRepositorio.create(clienteExistente);
        return clienteExistente;
    }

    @Transaccion
    public void registrarVentaConCliente() {

        try {
            if (boletosReservados.size() > 0) {

                for (int i = 0; i < boletosReservados.size(); i++) {

                    Cliente cliente = boletosReservados.get(i).getCliente();
                    adicionarCliente(cliente);
                    boletosReservados.get(i).setCliente(cliente);
                    boletosReservados.get(i).setEstadoBoleto(EstadoAsiento.PAGADO);
                    Calendar fechaVenta = Calendar.getInstance();
                    boletosReservados.get(i).setFechaVenta(fechaVenta.getTime());
                    //boletosReservados.get(i).setHoraSalida(programacion.getHoraSalida());
                }

                ventaService.create(venta);

                this.boletosReservados = new ArrayList<>();

                this.boletosPagados = new ArrayList<>();

                obtenerBoletosReservadosYPagados();

                //printSilentPDF();
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Venta Satisfactoria", "Venta Satisfactoria");

                FacesContext.getCurrentInstance().addMessage(null, message);

            }

        } catch (Exception ex) {
            ex.printStackTrace();

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Venta de Boletos", "No se pudo vender los Boletos. Contactar a Sistemas.");

            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

    public Sexo[] getSexo() {
        return Sexo.values();
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Programacion getProgramacion() {
        return programacion;
    }

    public void setProgramacion(Programacion programacion) {
        this.programacion = programacion;
    }

    public List<Boleto> getBoletosReservados() {
        return boletosReservados;
    }

    public void setBoletosReservados(List<Boleto> boletosReservados) {
        this.boletosReservados = boletosReservados;
    }

    public List<Boleto> getBoletosPagados() {
        return boletosPagados;
    }

    public void setBoletosPagados(List<Boleto> boletosPagados) {
        this.boletosPagados = boletosPagados;
    }
}
