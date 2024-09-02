package com.titanic.ventapasajes.ws;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfMConductor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfMConductor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MConductor" type="{http://wshr.mtc.gob.pe/}MConductor" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class ArrayOfMConductor {

    protected List<MConductor> mConductor;

    /**
     * Gets the value of the mConductor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mConductor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMConductor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MConductor }
     * 
     * 
     */
    public List<MConductor> getMConductor() {
        if (mConductor == null) {
            mConductor = new ArrayList<MConductor>();
        }
        return this.mConductor;
    }

}
