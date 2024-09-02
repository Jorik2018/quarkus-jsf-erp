package com.titanic.ventapasajes.ejb;

import com.titanic.ventapasajes.modelo.Conductor;
import java.util.List;
import java.util.Map;

public interface ConductorFacadeLocal {

    void create(Conductor conductor);

    void edit(Conductor conductor);

    void remove(Conductor conductor);

    Conductor find(Object id);

    List<Conductor> findAll();

    List<Conductor> findRange(int[] range);

    long count();

    public List<Conductor> listarConductoresFiltrados(Map filtros);

    public void removerConductor(Conductor conductorSeleccionado);

    public Conductor obtenerConductorPorNumeroDocumento(String nroDocumento);
    
}
