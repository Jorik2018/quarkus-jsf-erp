package com.titanic.ventapasajes.controller;

import com.titanic.ventapasajes.ejb.ClienteFacadeLocal;
import java.io.Serializable;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import com.titanic.ventapasajes.modelo.*;
import com.titanic.ventapasajes.jsf.FacesUtil;
import com.titanic.ventapasajes.util.NegocioExcepciones;
import jakarta.inject.Inject;

@Named
@ViewScoped
public class RegistroClienteController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ClienteFacadeLocal clienteRepositorio;
	
	private Cliente cliente;

	public void inicializar(){


		if (this.cliente == null) {
			this.cliente = new Cliente();
		}
	}
	
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public TipoPersona[] getTiposPersona() {
		return TipoPersona.values();
	}

    public TipoDocumento[] getTiposDocumento() {
        return TipoDocumento.values();
    }

    public Sexo[] getSexo() {
        return Sexo.values();
    }
	
	public void registrarCliente(){
		Cliente clienteExistente = clienteRepositorio.obtenerClientePorNumeroDocumento(cliente.getNumeroDocumento());
		
		if(clienteExistente!=null && !clienteExistente.equals(cliente)){
			throw new NegocioExcepciones("Ya existe un cliente con ese Numero de Documento, verificar"); 
		}
		
		clienteRepositorio.create(cliente);
                
		FacesUtil.adicionarMensajeInfo("El cliente se registro correctamente");
	}


	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
		 
		
	}
	
	public boolean isEditando(){
		return this.cliente.getIdeCliente() !=null;
	}
		
	
}
