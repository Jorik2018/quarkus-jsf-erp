package com.titanic.ventapasajes.ejb;

import com.titanic.ventapasajes.modelo.Tripulante;
import java.util.List;

public interface TripulanteFacadeLocal {

    void create(Tripulante tripulante);

    void edit(Tripulante tripulante);

    void remove(Tripulante tripulante);

    Tripulante find(Object id);

    List<Tripulante> findAll();

    List<Tripulante> findRange(int[] range);

    long count();
    
}
