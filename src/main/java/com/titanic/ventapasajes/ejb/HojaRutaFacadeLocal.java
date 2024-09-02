package com.titanic.ventapasajes.ejb;

import com.titanic.ventapasajes.modelo.HojaRuta;
import java.util.List;
import java.util.Map;

public interface HojaRutaFacadeLocal {

    void create(HojaRuta hojaRuta);

    void edit(HojaRuta hojaRuta);

    void remove(HojaRuta hojaRuta);

    HojaRuta find(Object id);

    List<HojaRuta> findAll();

    List<HojaRuta> findRange(int[] range);

    long count();

    public void removerHojaRuta(HojaRuta hojaRutaSeleccionada);

    public List<HojaRuta> listarHojaRutaFiltrados(Map filtros);

    
}
