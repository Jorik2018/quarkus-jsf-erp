package com.titanic.ventapasajes.ejb;

import com.titanic.ventapasajes.modelo.HConductor;
import jakarta.enterprise.context.ApplicationScoped;
import org.isobit.util.AbstractFacade;

@ApplicationScoped
public class HConductorFacade extends AbstractFacade<HConductor> implements HConductorFacadeLocal {

}
