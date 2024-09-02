package com.titanic.ventapasajes.ejb;

import com.titanic.ventapasajes.modelo.Programacion;
import java.util.Map;
import java.util.List;

public interface ProgramacionFacadeLocal {

    void create(Programacion programacion);

    void edit(Programacion programacion);

    void remove(Programacion programacion);

    Programacion find(Object id);

    List<Programacion> findAll();

    List<Programacion> findRange(int[] range);

    long count();

    public List<Programacion> listarProgramacionesFiltradas(Map filtros);

    public void removerProgramacion(Programacion programacionSeleccionada);
    
}
