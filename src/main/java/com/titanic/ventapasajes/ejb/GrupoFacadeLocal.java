package com.titanic.ventapasajes.ejb;

import com.titanic.ventapasajes.modelo.Grupo;
import java.util.List;

public interface GrupoFacadeLocal {

    void create(Grupo grupo);

    void edit(Grupo grupo);

    void remove(Grupo grupo);

    Grupo find(Object id);

    List<Grupo> findAll();

    List<Grupo> findRange(int[] range);

    long count();
    
}
