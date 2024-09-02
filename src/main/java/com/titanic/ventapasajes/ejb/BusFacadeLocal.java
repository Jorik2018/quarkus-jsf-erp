package com.titanic.ventapasajes.ejb;

import com.titanic.ventapasajes.modelo.Bus;
import java.util.List;
import java.util.Map;

public interface BusFacadeLocal {

    void create(Bus bus);

    void edit(Bus bus);

    void remove(Bus bus);

    Bus find(Object id);

    List<Bus> findAll();

    List<Bus> findRange(int[] range);

    long count();

    public Bus buscarUsuarioporPlaca(String placa);

    public List<Bus> listarBusesFiltrados(Map filtros);

    public void removerBus(Bus busSeleccionado);

    public Bus getFilasWithBusById(Long ideBus);
    
}
