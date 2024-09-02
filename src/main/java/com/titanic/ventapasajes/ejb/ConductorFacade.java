package com.titanic.ventapasajes.ejb;

import com.titanic.ventapasajes.modelo.Conductor;
import com.titanic.ventapasajes.util.NegocioExcepciones;
import com.titanic.ventapasajes.util.jpa.Transaccion;
import java.util.List;
import java.util.Map;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;
import jakarta.enterprise.context.ApplicationScoped;
import org.isobit.util.AbstractFacade;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ConductorFacade extends AbstractFacade<Conductor> implements ConductorFacadeLocal {

    @SuppressWarnings("unchecked")
    public List<Conductor> listarConductoresFiltrados(Map conductorFiltros) {
        String numeroDocumento = (String) conductorFiltros.get("numeroDocumento");
        String nombreConductor = (String) conductorFiltros.get("nombre");
        return getEntityManager().createQuery("SELECT c FROM Conductor c WHERE c.numeroDocumento LIKE :numeroDocumento AND c.nombreConductor LIKE :nombreConductor ORDER BY c.nombreConductor")
                .setParameter("numeroDocumento", "%" + (numeroDocumento != null ? numeroDocumento : "") + "%")
                .setParameter("nombreConductor", "%" + (nombreConductor != null ? nombreConductor : "") + "%")
                .getResultList();
    }

    @Transaccion
    public void removerConductor(Conductor conductor) {

        try {
            conductor = obtenerConductor(conductor.getIdeConductor());
            getEntityManager().remove(conductor);
            getEntityManager().flush();
        } catch (PersistenceException e) {
            throw new NegocioExcepciones("El conductor no puede ser eliminado.");
        }

    }

    public Conductor obtenerConductor(Long id) {
        return getEntityManager().find(Conductor.class, id);
    }

    public Conductor obtenerConductorPorNumeroDocumento(String numeroDocumento) {
        try {
            return getEntityManager().createQuery("from Conductor where numeroDocumento = :numeroDocumento", Conductor.class)
                    .setParameter("numeroDocumento", numeroDocumento)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
