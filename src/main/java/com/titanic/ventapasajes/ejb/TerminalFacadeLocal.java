package com.titanic.ventapasajes.ejb;

import com.titanic.ventapasajes.modelo.Terminal;
import java.util.List;
import java.util.Map;

public interface TerminalFacadeLocal {

    void create(Terminal terminal);

    void edit(Terminal terminal);

    void remove(Terminal terminal);

    Terminal find(Object id);

    List<Terminal> findAll();

    List<Terminal> findRange(int[] range);

    long count();

    public void removerTerminal(Terminal terminalSeleccionado);

    public List<Terminal> listarTerminalesFiltrados(Map filtros);

    public Terminal buscarTerminalPorNombre(String nombreTerminal);
    
}
