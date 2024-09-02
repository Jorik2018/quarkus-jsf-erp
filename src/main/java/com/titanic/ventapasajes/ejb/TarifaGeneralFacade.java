package com.titanic.ventapasajes.ejb;

import com.titanic.ventapasajes.modelo.TarifaGeneral;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.NoResultException;
import org.isobit.util.AbstractFacade;

@ApplicationScoped
public class TarifaGeneralFacade extends AbstractFacade<TarifaGeneral> implements TarifaGeneralFacadeLocal {
       public TarifaGeneral buscarTarifaGeneral(String tipoBus, Long ideRecorrido){

        try {
            TarifaGeneral tarifaGeneral = getEntityManager().createQuery("from TarifaGeneral where " +
                    "tipoAsiento = :tipoBus and " +
                    "recorrido.ideRecorrido = :ideRecorrido", TarifaGeneral.class)
                    .setParameter("tipoBus", tipoBus)
                    .setParameter("ideRecorrido", ideRecorrido)
                    .getSingleResult();
            return tarifaGeneral;
        }catch(NoResultException e){
            return null;
        }
    } 
}
