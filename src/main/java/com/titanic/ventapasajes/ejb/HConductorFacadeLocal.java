package com.titanic.ventapasajes.ejb;

import com.titanic.ventapasajes.modelo.HConductor;
import java.util.List;

public interface HConductorFacadeLocal {

    void create(HConductor hConductor);

    void edit(HConductor hConductor);

    void remove(HConductor hConductor);

    HConductor find(Object id);

    List<HConductor> findAll();

    List<HConductor> findRange(int[] range);

    long count();
    
}
