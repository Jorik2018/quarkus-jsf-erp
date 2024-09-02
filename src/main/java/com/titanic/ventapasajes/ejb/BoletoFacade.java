package com.titanic.ventapasajes.ejb;

import com.titanic.ventapasajes.modelo.Boleto;
import jakarta.ejb.Stateless;
import org.isobit.util.AbstractFacade;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BoletoFacade extends AbstractFacade<Boleto> implements BoletoFacadeLocal {

}
