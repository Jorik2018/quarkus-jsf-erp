package com.titanic.ventapasajes.ejb;

import com.titanic.ventapasajes.modelo.Grupo;
import org.isobit.util.AbstractFacade;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GrupoFacade extends AbstractFacade<Grupo> implements GrupoFacadeLocal {

}
