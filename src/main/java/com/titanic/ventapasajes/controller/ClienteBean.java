package com.titanic.ventapasajes.controller;

import com.titanic.ventapasajes.ejb.ClienteFacadeLocal;
import java.io.Serializable;
import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import com.titanic.ventapasajes.modelo.Cliente;
import com.titanic.ventapasajes.jsf.FacesUtil;
import java.util.HashMap;
import jakarta.inject.Inject;

@Named
@ViewScoped
public class ClienteBean implements Serializable{

	private static final long serialVersionUID = 1592771145764176840L;

	@Inject
	private ClienteFacadeLocal clienteRepositorio;

	@PostConstruct
	public void init(){
		filtros = new HashMap();
		buscarClientesFiltros();
	}

	private List<Cliente> clientesFiltrados;
	private HashMap filtros;
	
	private Cliente clienteSeleccionado;
	


	
	public void buscarClientesFiltros(){
		clientesFiltrados = clienteRepositorio.listarClientesFiltrados(filtros);
	}

	public void eliminarCliente(){
		clienteRepositorio.removerCliente(clienteSeleccionado);
		clientesFiltrados.remove(clienteSeleccionado);
		FacesUtil.adicionarMensajeInfo("Cliente "+clienteSeleccionado.getNombreCliente() +" eliminado.");
	}	
	
	public Cliente getClienteSeleccionado() {
		return clienteSeleccionado;
	}

	public void setClienteSeleccionado(Cliente clienteSeleccionado) {
		this.clienteSeleccionado = clienteSeleccionado;
	}
	
	public HashMap getFiltros() {
		return filtros;
	}
	
	public List<Cliente> getClientesFiltrados() {
		return clientesFiltrados;
	}
}
