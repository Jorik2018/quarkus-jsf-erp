package com.titanic.ventapasajes.ejb;

import com.titanic.ventapasajes.modelo.FilaBoleto;
import java.util.List;

public interface FilaBoletoFacadeLocal {

    void create(FilaBoleto filaBoleto);

    void edit(FilaBoleto filaBoleto);

    void remove(FilaBoleto filaBoleto);

    FilaBoleto find(Object id);

    List<FilaBoleto> findAll();

    List<FilaBoleto> findRange(int[] range);

    long count();
    
}
