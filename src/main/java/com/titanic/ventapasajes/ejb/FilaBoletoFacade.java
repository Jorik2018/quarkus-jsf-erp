package com.titanic.ventapasajes.ejb;

import com.titanic.ventapasajes.modelo.FilaBoleto;
import jakarta.ejb.Stateless;
import org.isobit.util.AbstractFacade;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FilaBoletoFacade extends AbstractFacade<FilaBoleto> implements FilaBoletoFacadeLocal {

}
