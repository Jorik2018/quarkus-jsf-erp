package com.titanic.ventapasajes.ejb;

import com.titanic.ventapasajes.modelo.Asiento;
import jakarta.ejb.Stateless;
import org.isobit.util.AbstractFacade;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AsientoFacade extends AbstractFacade<Asiento> implements AsientoFacadeLocal {

}
