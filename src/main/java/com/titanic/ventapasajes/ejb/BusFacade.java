package com.titanic.ventapasajes.ejb;

import com.titanic.ventapasajes.modelo.Bus;
import com.titanic.ventapasajes.util.NegocioExcepciones;
import com.titanic.ventapasajes.util.jpa.Transaccion;
import java.util.List;
import java.util.Map;
import jakarta.ejb.Stateless;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;
import org.isobit.util.AbstractFacade;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BusFacade extends AbstractFacade<Bus> implements BusFacadeLocal {
    
    public Bus buscarUsuarioporPlaca(String placa) {

        Bus bus = null;
        try {
            bus = this.getEntityManager().createQuery("from Bus where lower(placa) = :placa", Bus.class)
                    .setParameter("placa", placa).getSingleResult();
        } catch (NoResultException e) {

        }
        return bus;
    }

    @SuppressWarnings("unchecked")
    public List<Bus> listarBusesFiltrados(Map busFiltros) {
        String p = (String) busFiltros.get("placa");
        return getEntityManager().createQuery("SELECT b FROM Bus b WHERE b.placa LIKE :placa ORDER BY b.descripcionBus")
                .setParameter("placa", "%" + (p != null ? p : "") + "%")
                .getResultList();
    }

    public Bus getFilasWithBusById(Long busId) {
        Bus bus = getEntityManager().find(Bus.class,busId);
        bus.getFilas().size();
        
// this will force SQL to execute the query that will join with the user's profile and populate
        //  the appropriate information into the user object.
        //Hibernate.initialize(bus.getFilasSuperiores());
        //Hibernate.initialize(bus.getFilasInferiores());

        return bus;
    }

    @Transaccion
    public void removerBus(Bus bus) {

        try {
            bus = find(bus.getIdeBus());
            getEntityManager().remove(bus);
            getEntityManager().flush();
        } catch (PersistenceException e) {
            throw new NegocioExcepciones("El bus no puede ser eliminado.");
        }

    }
}
