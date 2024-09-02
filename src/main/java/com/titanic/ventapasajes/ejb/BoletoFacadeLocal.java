package com.titanic.ventapasajes.ejb;

import com.titanic.ventapasajes.modelo.Boleto;
import java.util.List;
import jakarta.ejb.Local;

public interface BoletoFacadeLocal {

    void create(Boleto boleto);

    void edit(Boleto boleto);

    void remove(Boleto boleto);

    Boleto find(Object id);

    List<Boleto> findAll();

    List<Boleto> findRange(int[] range);

    long count();
    
}
