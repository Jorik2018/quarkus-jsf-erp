package com.titanic.ventapasajes.conversores;

import com.titanic.ventapasajes.ejb.TerminalFacade;
import com.titanic.ventapasajes.ejb.TerminalFacadeLocal;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

import com.titanic.ventapasajes.modelo.Terminal;
import com.titanic.ventapasajes.util.cdi.CDIServiceLocator;
import jakarta.inject.Inject;

@FacesConverter(forClass=Terminal.class)
public class TerminalConverter  implements Converter {

    @Inject
    private TerminalFacadeLocal terminalRepositorio;

    public TerminalConverter() {
        this.terminalRepositorio = (TerminalFacade) CDIServiceLocator.getBean(TerminalFacade.class);
    }

    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Terminal retorno = null;

        if (value != null && !"".equals(value)) {
            retorno = this.terminalRepositorio.find(Long.parseLong(value));
        }

        return retorno;
    }

    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value!=null){
            Terminal terminal = (Terminal) value;
            return terminal.getIdeTerminal() == null ? null :  terminal.getIdeTerminal().toString();
        }
        return "";


    }

}
