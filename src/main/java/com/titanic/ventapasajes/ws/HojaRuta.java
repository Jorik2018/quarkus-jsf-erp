
package com.titanic.ventapasajes.ws;

/**
 * <p>Java class for HojaRuta complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HojaRuta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Seguridad" type="{http://wshr.mtc.gob.pe/}Seguridad" minOccurs="0"/>
 *         &lt;element name="NroRuta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NroPlaca" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TerSalida" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TerLlegada" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="FecSalida" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HorSalida" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FecEstLlegada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HorEstLlegada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Conductores" type="{http://wshr.mtc.gob.pe/}ArrayOfHConductor" minOccurs="0"/>
 *         &lt;element name="Tripulantes" type="{http://wshr.mtc.gob.pe/}ArrayOfHTripulante" minOccurs="0"/>
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
public class HojaRuta {

    protected Seguridad seguridad;
    
    protected String nroRuta;
    
    protected String nroPlaca;
    
    protected int terSalida;
    
    protected int terLlegada;
    
    protected String fecSalida;
    
    protected String horSalida;
    
    protected String fecEstLlegada;
    
    protected String horEstLlegada;

    protected ArrayOfHConductor conductores;

    protected ArrayOfHTripulante tripulantes;

}
