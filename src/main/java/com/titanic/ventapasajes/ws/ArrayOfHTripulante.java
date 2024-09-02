
package com.titanic.ventapasajes.ws;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfHTripulante complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHTripulante">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HTripulante" type="{http://wshr.mtc.gob.pe/}HTripulante" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class ArrayOfHTripulante {

    //@XmlElement(name = "HTripulante", nillable = true)
    protected List<HTripulante> hTripulante;

    /**
     * Gets the value of the hTripulante property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hTripulante property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHTripulante().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HTripulante }
     * 
     * 
     */
    public List<HTripulante> getHTripulante() {
        if (hTripulante == null) {
            hTripulante = new ArrayList<HTripulante>();
        }
        return this.hTripulante;
    }

}
