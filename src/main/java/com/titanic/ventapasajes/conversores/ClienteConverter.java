package com.titanic.ventapasajes.conversores;

import com.titanic.ventapasajes.ejb.ClienteFacadeLocal;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

import com.titanic.ventapasajes.modelo.Cliente;
import com.titanic.ventapasajes.util.cdi.CDIServiceLocator;
import jakarta.inject.Inject;

@FacesConverter(forClass=Cliente.class)
public class ClienteConverter implements Converter{

    @Inject
	private ClienteFacadeLocal clienteRepositorio;

	public ClienteConverter() {
//		this.clienteRepositorio = (ClienteRepositorio) CDIServiceLocator.getBean(ClienteRepositorio.class);
	}

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Cliente retorno = null;

		if (value != null && !"".equals(value)) {
			retorno = this.clienteRepositorio.find(Long.parseLong(value));
		}

		return retorno;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value!=null){
			Cliente cliente = (Cliente) value;
			return cliente.getIdeCliente() == null ? null :  cliente.getIdeCliente().toString();
		}
		
		return "";
	}
	
}
