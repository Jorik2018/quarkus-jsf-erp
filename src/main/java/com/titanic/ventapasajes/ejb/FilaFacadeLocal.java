package com.titanic.ventapasajes.ejb;

import com.titanic.ventapasajes.modelo.Fila;
import java.util.List;

public interface FilaFacadeLocal {

    void create(Fila fila);

    void edit(Fila fila);

    void remove(Fila fila);

    Fila find(Object id);

    List<Fila> findAll();

    List<Fila> findRange(int[] range);

    long count();
    
}
