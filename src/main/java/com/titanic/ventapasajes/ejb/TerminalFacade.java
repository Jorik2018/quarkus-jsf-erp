package com.titanic.ventapasajes.ejb;

import com.titanic.ventapasajes.modelo.Terminal;
import com.titanic.ventapasajes.util.NegocioExcepciones;
import com.titanic.ventapasajes.util.jpa.Transaccion;
import java.util.List;
import java.util.Map;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;
import org.isobit.util.AbstractFacade;

@ApplicationScoped
public class TerminalFacade extends AbstractFacade<Terminal> implements TerminalFacadeLocal {

    @Transaccion
    public void removerTerminal(Terminal terminal) {

        try {
            terminal = find(terminal.getIdeTerminal());
            getEntityManager().remove(terminal);
            getEntityManager().flush();
        } catch (PersistenceException e) {
            throw new NegocioExcepciones("El terminal no puede ser eliminado.");
        }

    }

    public Terminal buscarTerminalPorNombre(String nombreTerminal) {

        Terminal terminal = null;
        try {
            terminal = this.getEntityManager().createQuery("from Terminal where lower(nombreTerminal) = :terminal", Terminal.class)
                    .setParameter("terminal", nombreTerminal.toLowerCase()).getSingleResult();
        } catch (NoResultException e) {

        }
        return terminal;
    }

    @SuppressWarnings("unchecked")
    public List<Terminal> listarTerminalesFiltrados(Map terminalFiltros) {

        String nombreTerminal = (String) terminalFiltros.get("nombre");
        return getEntityManager().createQuery("SELECT t FROM Terminal t WHERE t.nombreTerminal LIKE :nombreTerminal ORDER BY t.nombreTerminal")
                .setParameter("nombreTerminal", "%" + (nombreTerminal != null ? nombreTerminal : "") + "%")
                .getResultList();

    }
}
