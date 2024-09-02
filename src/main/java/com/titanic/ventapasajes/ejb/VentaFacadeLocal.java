package com.titanic.ventapasajes.ejb;

import com.titanic.ventapasajes.modelo.Programacion;
import com.titanic.ventapasajes.modelo.Venta;
import java.util.List;

public interface VentaFacadeLocal {

    void create(Venta venta);

    void edit(Venta venta);

    void remove(Venta venta);

    Venta find(Object id);

    List<Venta> findAll();

    List<Venta> findRange(int[] range);

    long count();

    public Venta obtenerVenta(Programacion programacion);
    
}
