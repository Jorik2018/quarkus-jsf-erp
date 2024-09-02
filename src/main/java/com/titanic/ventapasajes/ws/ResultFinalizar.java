
package com.titanic.ventapasajes.ws;

/**
 * <p>Java class for ResultFinalizar complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResultFinalizar">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Return" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Errores" type="{http://wshr.mtc.gob.pe/}ArrayOfErrores" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class ResultFinalizar {

    protected boolean _return;

    protected ArrayOfErrores errores;

}
