
package com.titanic.ventapasajes.ws;

/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="oConductor" type="{http://wshr.mtc.gob.pe/}Conductor" minOccurs="0"/>
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
public class GetConductor {

    protected Conductor oConductor;

    /**
     * Gets the value of the oConductor property.
     * 
     * @return
     *     possible object is
     *     {@link Conductor }
     *     
     */

}
