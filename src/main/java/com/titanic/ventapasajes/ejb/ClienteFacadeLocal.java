package com.titanic.ventapasajes.ejb;

import com.titanic.ventapasajes.modelo.Cliente;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ClienteFacadeLocal {

    void create(Cliente cliente);

    void edit(Cliente cliente);

    void remove(Cliente cliente);

    Cliente find(Object id);

    List<Cliente> findAll();

    List<Cliente> findRange(int[] range);

    long count();

    public List<Cliente> listarClientesFiltrados(Map filtros);

    public void removerCliente(Cliente clienteSeleccionado);

    public Cliente obtenerClientePorNumeroDocumento(String numeroDocumento);
    
}
