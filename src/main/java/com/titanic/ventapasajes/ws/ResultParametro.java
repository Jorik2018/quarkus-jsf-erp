
package com.titanic.ventapasajes.ws;

/**
 * <p>Java class for ResultParametro complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResultParametro">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Return" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Errores" type="{http://wshr.mtc.gob.pe/}ArrayOfErrores" minOccurs="0"/>
 *         &lt;element name="Rutas" type="{http://wshr.mtc.gob.pe/}ArrayOfRuta" minOccurs="0"/>
 *         &lt;element name="Terminales" type="{http://wshr.mtc.gob.pe/}ArrayOfTerminal" minOccurs="0"/>
 *         &lt;element name="Documentos" type="{http://wshr.mtc.gob.pe/}ArrayOfDocumento" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class ResultParametro {

    protected boolean _return;
    
    protected ArrayOfErrores errores;
    
    protected ArrayOfRuta rutas;
    
    protected ArrayOfTerminal terminales;
    
    protected ArrayOfDocumento documentos;

}
