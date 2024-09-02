package com.titanic.ventapasajes.ejb;

import com.titanic.ventapasajes.modelo.Cliente;
import com.titanic.ventapasajes.util.NegocioExcepciones;
import com.titanic.ventapasajes.util.jpa.Transaccion;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jakarta.ejb.Stateless;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;
import org.isobit.util.AbstractFacade;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClienteFacade extends AbstractFacade<Cliente> implements ClienteFacadeLocal {

    public List<Cliente> buscarClientePorNombre(String nombreCliente) {
        return this.getEntityManager().createQuery("from Cliente "
                + "where upper(nombreCliente) like :nombreCliente", Cliente.class)
                .setParameter("nombreCliente", nombreCliente.toUpperCase() + "%")
                .getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Cliente> listarClientesFiltrados(Map clienteFiltros) {
        String numeroDocumento = (String) clienteFiltros.get("numeroDocumento");
        String email = (String) clienteFiltros.get("email");
        String nombreCliente = (String) clienteFiltros.get("nombre");
        return getEntityManager().createQuery("SELECT c FROM Cliente c WHERE c.numeroDocumento LIKE :numeroDocumento AND c.email LIKE :email AND c.nombreCliente LIKE :nombreCliente ORDER BY c.nombreCliente")
                .setParameter("numeroDocumento", numeroDocumento != null ? "%" + numeroDocumento + "%" : "%")
                .setParameter("email", email != null ? "%" + email + "%" : "%")
                .setParameter("nombreCliente", nombreCliente != null ? "%" + nombreCliente + "%" : "%")
                .getResultList();
    }

    @Transaccion
    public void removerCliente(Cliente cliente) {

        try {
            cliente = obtenerCliente(cliente.getIdeCliente());
            getEntityManager().remove(cliente);
            getEntityManager().flush();
        } catch (PersistenceException e) {
            throw new NegocioExcepciones("El cliente no puede ser eliminado.");
        }

    }

    public Cliente obtenerCliente(Long id) {
        return getEntityManager().find(Cliente.class, id);
    }

    public Cliente obtenerClientePorNumeroDocumento(String numeroDocumento) {
        try {
            return getEntityManager().createQuery("from Cliente where numeroDocumento = :numeroDocumento", Cliente.class)
                    .setParameter("numeroDocumento", numeroDocumento)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
