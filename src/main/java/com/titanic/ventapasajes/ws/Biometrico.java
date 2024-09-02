
package com.titanic.ventapasajes.ws;

/**
 * <p>Java class for Biometrico complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Biometrico">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Seguridad" type="{http://wshr.mtc.gob.pe/}Seguridad" minOccurs="0"/>
 *         &lt;element name="NroEmp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NroDoc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HueDer" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
import lombok.Data;

@Data
public class Biometrico {
    
    protected Seguridad seguridad;
    
    protected String nroEmp;
    
    protected String nroDoc;
    
    protected byte[] hueDer;

}
