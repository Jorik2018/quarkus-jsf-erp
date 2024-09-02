package com.titanic.ventapasajes.ejb;

import com.titanic.ventapasajes.modelo.Fila;
import jakarta.ejb.Stateless;
import org.isobit.util.AbstractFacade;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FilaFacade extends AbstractFacade<Fila> implements FilaFacadeLocal {

}
