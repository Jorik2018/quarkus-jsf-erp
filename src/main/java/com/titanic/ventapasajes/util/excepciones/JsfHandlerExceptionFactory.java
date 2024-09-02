package com.titanic.ventapasajes.util.excepciones;

import jakarta.faces.context.ExceptionHandler;
import jakarta.faces.context.ExceptionHandlerFactory;

public class JsfHandlerExceptionFactory extends ExceptionHandlerFactory {

	private ExceptionHandlerFactory factory;
	
	public JsfHandlerExceptionFactory(ExceptionHandlerFactory factory){
		this.factory = factory;
	}
	
	@Override
	public ExceptionHandler getExceptionHandler() {
		return new JsfHandlerException(factory.getExceptionHandler());
	}

}
