package com.titanic.ventapasajes.ejb;

import com.titanic.ventapasajes.modelo.Programacion;
import com.titanic.ventapasajes.util.NegocioExcepciones;
import com.titanic.ventapasajes.util.jpa.Transaccion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.PersistenceException;
import org.isobit.util.AbstractFacade;

@ApplicationScoped
public class ProgramacionFacade extends AbstractFacade<Programacion> implements ProgramacionFacadeLocal {

    @Override
    public List<Programacion> listarProgramacionesFiltradas(Map programacionFiltros) {
        if (programacionFiltros.get("fechaProgramacion") != null) {

            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String startDateStr = formatter.format(programacionFiltros.get("fechaProgramacion"));

            Date startDate = null;

            try {
                startDate = formatter.parse(startDateStr);
            } catch (ParseException ex) {
                Logger.getLogger(ProgramacionFacade.class.getName()).log(Level.SEVERE, null, ex);
            }
            Date endDate = new Date(startDate.getTime() + TimeUnit.DAYS.toMillis(1));
            return getEntityManager().createQuery("SELECT p FROM Programacion p WHERE p.fechaSalida>=:desde AND p.fechaSalida<=:hasta ORDER BY p.fechaSalida")
                    .setParameter("desde", startDate)
                    .setParameter("hasta", endDate)
                    .getResultList();
        } else {
            return getEntityManager().createQuery("SELECT p FROM Programacion p Order by p.fechaSalida").getResultList();
        }
    }

    @Override
    @Transaccion
    public void removerProgramacion(Programacion programacion) {

        try {
            programacion = find(programacion.getIdeProgramacion());
            getEntityManager().remove(programacion);
            getEntityManager().flush();
        } catch (PersistenceException e) {
            throw new NegocioExcepciones("La programación no puede ser eliminada.");
        }

    }

}
