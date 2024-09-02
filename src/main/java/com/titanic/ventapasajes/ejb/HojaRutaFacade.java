package com.titanic.ventapasajes.ejb;

import com.titanic.ventapasajes.modelo.HojaRuta;
import com.titanic.ventapasajes.util.NegocioExcepciones;
import com.titanic.ventapasajes.util.jpa.Transaccion;
import java.util.List;
import java.util.Map;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.PersistenceException;
import org.isobit.util.AbstractFacade;

@ApplicationScoped
public class HojaRutaFacade extends AbstractFacade<HojaRuta> implements HojaRutaFacadeLocal {

    public List<HojaRuta> listarHojaRutaFiltrados(Map hojaRutaFiltros) {
        return getEntityManager().createQuery("SELECT h FROM HojaRuta h WHERE h.fechaRegistro>=:desde AND h.fechaRegistro<=:hasta ORDER BY h.fechaRegistro")
                .setParameter("desde", hojaRutaFiltros.get("fechaDesde"))
                .setParameter("hasta", hojaRutaFiltros.get("fechaHasta"))
                .getResultList();
    }

    @Transaccion
    @Override
    public void removerHojaRuta(HojaRuta hojaRuta) {

        try {
            hojaRuta = find(hojaRuta.getIdeHojaRuta());
            getEntityManager().remove(hojaRuta);
            getEntityManager().flush();
        } catch (PersistenceException e) {
            throw new NegocioExcepciones("La Hoja Ruta no puede ser eliminada.");
        }

    }
}
