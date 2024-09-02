package com.titanic.ventapasajes.ejb;

import com.titanic.ventapasajes.modelo.Recorrido;
import com.titanic.ventapasajes.util.NegocioExcepciones;
import com.titanic.ventapasajes.util.jpa.Transaccion;
import java.util.HashMap;
import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;
import org.isobit.util.AbstractFacade;

@ApplicationScoped
public class RecorridoFacade extends AbstractFacade<Recorrido> implements RecorridoFacadeLocal {

    public List<Recorrido> buscarRecorridoPorRuta(String ruta) {
        return this.getEntityManager().createQuery("from Recorrido "
                + "where upper(ruta) like :ruta", Recorrido.class)
                .setParameter("ruta", ruta.toUpperCase() + "%")
                .getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Recorrido> listarRecorridosFiltrados(HashMap filtros) {

        return getEntityManager().createQuery("SELECT r FROM Recorrido r WHERE (r.origen.ideTerminal=:origen OR r.destino.ideTerminal=:destino) AND r.ruta LIKE :ruta ORDER BY r.ruta")
                .setParameter("origen", Long.valueOf("" + filtros.get("origen")))
                .setParameter("destino", Long.valueOf("" + filtros.get("destino")))
                .setParameter("ruta", filtros.get("ruta"))
                .getResultList();
    }

    @Transaccion
    public void removerRecorrido(Recorrido recorrido) {

        try {
            recorrido = obtenerRecorrido(recorrido.getIdeRecorrido());
            getEntityManager().remove(recorrido);
            getEntityManager().flush();
        } catch (PersistenceException e) {
            throw new NegocioExcepciones("El recorrido no puede ser eliminado.");
        }
    }

    public Recorrido obtenerRecorrido(Long id) {
        return getEntityManager().find(Recorrido.class, id);
    }

    public Recorrido obtenerRecorridoPorOrigen(String origen) {
        try {
            return getEntityManager().createQuery("from Recorrido where origen.ideTerminal = :origen", Recorrido.class)
                    .setParameter("origen", origen)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Recorrido adicionarRecorrido(Recorrido recorrido) {
        return getEntityManager().merge(recorrido);
    }

    public Recorrido obtenerRecorridoPorRuta(String ruta) {

        try {
            return getEntityManager().createQuery("from Recorrido where ruta = :ruta", Recorrido.class)
                    .setParameter("ruta", ruta)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
