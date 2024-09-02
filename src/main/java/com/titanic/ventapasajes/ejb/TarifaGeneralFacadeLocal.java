package com.titanic.ventapasajes.ejb;

import com.titanic.ventapasajes.modelo.TarifaGeneral;
import java.util.List;

public interface TarifaGeneralFacadeLocal {

    void create(TarifaGeneral tarifaGeneral);

    void edit(TarifaGeneral tarifaGeneral);

    void remove(TarifaGeneral tarifaGeneral);

    TarifaGeneral find(Object id);

    List<TarifaGeneral> findAll();

    List<TarifaGeneral> findRange(int[] range);

    long count();

    public TarifaGeneral buscarTarifaGeneral(String tipoBus, Long ideRecorrido);
    
}
