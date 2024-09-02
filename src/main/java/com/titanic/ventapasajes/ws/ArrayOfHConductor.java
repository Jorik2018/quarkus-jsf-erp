
package com.titanic.ventapasajes.ws;

import java.util.ArrayList;
import java.util.List;
/**
 * <p>Java class for ArrayOfHConductor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHConductor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HConductor" type="{http://wshr.mtc.gob.pe/}HConductor" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class ArrayOfHConductor {

    protected List<HConductor> hConductor;

    /**
     * Gets the value of the hConductor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hConductor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHConductor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HConductor }
     * 
     * 
     */
    public List<HConductor> getHConductor() {
        if (hConductor == null) {
            hConductor = new ArrayList<HConductor>();
        }
        return this.hConductor;
    }

}
