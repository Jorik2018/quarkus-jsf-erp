
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
 *         &lt;element name="oAnular" type="{http://wshr.mtc.gob.pe/}Anular" minOccurs="0"/>
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
public class SetAnular {

    protected Anular oAnular;

    /**
     * Gets the value of the oAnular property.
     * 
     * @return
     *     possible object is
     *     {@link Anular }
     *     
     */

}
