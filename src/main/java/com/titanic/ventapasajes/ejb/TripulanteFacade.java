package com.titanic.ventapasajes.ejb;

import com.titanic.ventapasajes.modelo.Tripulante;
import jakarta.enterprise.context.ApplicationScoped;
import org.isobit.util.AbstractFacade;

@ApplicationScoped
public class TripulanteFacade extends AbstractFacade<Tripulante> implements TripulanteFacadeLocal {

}
