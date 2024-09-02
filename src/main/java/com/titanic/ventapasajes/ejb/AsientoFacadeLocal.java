package com.titanic.ventapasajes.ejb;

import com.titanic.ventapasajes.modelo.Asiento;
import java.util.List;
import jakarta.ejb.Local;

public interface AsientoFacadeLocal {

    void create(Asiento asiento);

    void edit(Asiento asiento);

    void remove(Asiento asiento);

    Asiento find(Object id);

    List<Asiento> findAll();

    List<Asiento> findRange(int[] range);

    long count();
    
}
