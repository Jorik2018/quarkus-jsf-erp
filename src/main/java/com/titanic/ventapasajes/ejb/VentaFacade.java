package com.titanic.ventapasajes.ejb;

import com.titanic.ventapasajes.modelo.Programacion;
import com.titanic.ventapasajes.modelo.Venta;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.NoResultException;
import org.isobit.util.AbstractFacade;

@ApplicationScoped
public class VentaFacade extends AbstractFacade<Venta> implements VentaFacadeLocal {

    public Venta obtenerVenta(Programacion programacion) {

        try {

            Venta venta = getEntityManager().createQuery("from Venta where "
                    + "programacion.ideProgramacion = :ideProgramacion ", Venta.class)
                    .setParameter("ideProgramacion", programacion.getIdeProgramacion())
                    .getSingleResult();

            return venta;
        } catch (NoResultException e) {
            return null;
        }

    }
}
