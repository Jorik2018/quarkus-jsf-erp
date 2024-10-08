
package com.titanic.ventapasajes.ws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WSServiciosHRSoap", targetNamespace = "http://wshr.mtc.gob.pe/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WSServiciosHRSoap {


    /**
     * Informacion de Pasajero por Embarque Biometrico.
     * 
     * @param oBiometrico
     * @return
     *     returns com.titanic.ventapasajes.ws.ResultBiometrico
     */
    @WebMethod(action = "http://wshr.mtc.gob.pe/getBiometrico")
    @WebResult(name = "getBiometricoResult", targetNamespace = "http://wshr.mtc.gob.pe/")
    @RequestWrapper(localName = "getBiometrico", targetNamespace = "http://wshr.mtc.gob.pe/", className = "com.titanic.ventapasajes.ws.GetBiometrico")
    @ResponseWrapper(localName = "getBiometricoResponse", targetNamespace = "http://wshr.mtc.gob.pe/", className = "com.titanic.ventapasajes.ws.GetBiometricoResponse")
    public ResultBiometrico getBiometrico(
        @WebParam(name = "oBiometrico", targetNamespace = "http://wshr.mtc.gob.pe/")
        Biometrico oBiometrico);

    /**
     * Informacion de Conductor por Empresa de Transporte.
     * 
     * @param oConductor
     * @return
     *     returns com.titanic.ventapasajes.ws.ResultConductor
     */
    @WebMethod(action = "http://wshr.mtc.gob.pe/getConductor")
    @WebResult(name = "getConductorResult", targetNamespace = "http://wshr.mtc.gob.pe/")
    @RequestWrapper(localName = "getConductor", targetNamespace = "http://wshr.mtc.gob.pe/", className = "com.titanic.ventapasajes.ws.GetConductor")
    @ResponseWrapper(localName = "getConductorResponse", targetNamespace = "http://wshr.mtc.gob.pe/", className = "com.titanic.ventapasajes.ws.GetConductorResponse")
    public ResultConductor getConductor(
        @WebParam(name = "oConductor", targetNamespace = "http://wshr.mtc.gob.pe/")
        Conductor oConductor);

    /**
     * Informacion de Pasajero por Empresa de Transporte.
     * 
     * @param oIdentidad
     * @return
     *     returns com.titanic.ventapasajes.ws.ResultIdentidad
     */
    @WebMethod(action = "http://wshr.mtc.gob.pe/getIdentidad")
    @WebResult(name = "getIdentidadResult", targetNamespace = "http://wshr.mtc.gob.pe/")
    @RequestWrapper(localName = "getIdentidad", targetNamespace = "http://wshr.mtc.gob.pe/", className = "com.titanic.ventapasajes.ws.GetIdentidad")
    @ResponseWrapper(localName = "getIdentidadResponse", targetNamespace = "http://wshr.mtc.gob.pe/", className = "com.titanic.ventapasajes.ws.GetIdentidadResponse")
    public ResultIdentidad getIdentidad(
        @WebParam(name = "oIdentidad", targetNamespace = "http://wshr.mtc.gob.pe/")
        Identidad oIdentidad);

    /**
     * Informacion de Parametro por Empresa de Transporte.
     * 
     * @param oParametro
     * @return
     *     returns com.titanic.ventapasajes.ws.ResultParametro
     */
    @WebMethod(action = "http://wshr.mtc.gob.pe/getParametro")
    @WebResult(name = "getParametroResult", targetNamespace = "http://wshr.mtc.gob.pe/")
    @RequestWrapper(localName = "getParametro", targetNamespace = "http://wshr.mtc.gob.pe/", className = "com.titanic.ventapasajes.ws.GetParametro")
    @ResponseWrapper(localName = "getParametroResponse", targetNamespace = "http://wshr.mtc.gob.pe/", className = "com.titanic.ventapasajes.ws.GetParametroResponse")
    public ResultParametro getParametro(
        @WebParam(name = "oParametro", targetNamespace = "http://wshr.mtc.gob.pe/")
        Parametro oParametro);

    /**
     * Informacion de Vehiculo por Empresa de Transporte.
     * 
     * @param oVehiculo
     * @return
     *     returns com.titanic.ventapasajes.ws.ResultVehiculo
     */
    @WebMethod(action = "http://wshr.mtc.gob.pe/getVehiculo")
    @WebResult(name = "getVehiculoResult", targetNamespace = "http://wshr.mtc.gob.pe/")
    @RequestWrapper(localName = "getVehiculo", targetNamespace = "http://wshr.mtc.gob.pe/", className = "com.titanic.ventapasajes.ws.GetVehiculo")
    @ResponseWrapper(localName = "getVehiculoResponse", targetNamespace = "http://wshr.mtc.gob.pe/", className = "com.titanic.ventapasajes.ws.GetVehiculoResponse")
    public ResultVehiculo getVehiculo(
        @WebParam(name = "oVehiculo", targetNamespace = "http://wshr.mtc.gob.pe/")
        Vehiculo oVehiculo);

    /**
     * Anulacion de Hoja Ruta por Empresa de Transporte.
     * 
     * @param oAnular
     * @return
     *     returns com.titanic.ventapasajes.ws.ResultAnular
     */
    @WebMethod(action = "http://wshr.mtc.gob.pe/setAnular")
    @WebResult(name = "setAnularResult", targetNamespace = "http://wshr.mtc.gob.pe/")
    @RequestWrapper(localName = "setAnular", targetNamespace = "http://wshr.mtc.gob.pe/", className = "com.titanic.ventapasajes.ws.SetAnular")
    @ResponseWrapper(localName = "setAnularResponse", targetNamespace = "http://wshr.mtc.gob.pe/", className = "com.titanic.ventapasajes.ws.SetAnularResponse")
    public ResultAnular setAnular(
        @WebParam(name = "oAnular", targetNamespace = "http://wshr.mtc.gob.pe/")
        Anular oAnular);

    /**
     * Finalizacion de Hoja Ruta por Empresa de Transporte.
     * 
     * @param oFinalizar
     * @return
     *     returns com.titanic.ventapasajes.ws.ResultFinalizar
     */
    @WebMethod(action = "http://wshr.mtc.gob.pe/setFinalizar")
    @WebResult(name = "setFinalizarResult", targetNamespace = "http://wshr.mtc.gob.pe/")
    @RequestWrapper(localName = "setFinalizar", targetNamespace = "http://wshr.mtc.gob.pe/", className = "com.titanic.ventapasajes.ws.SetFinalizar")
    @ResponseWrapper(localName = "setFinalizarResponse", targetNamespace = "http://wshr.mtc.gob.pe/", className = "com.titanic.ventapasajes.ws.SetFinalizarResponse")
    public ResultFinalizar setFinalizar(
        @WebParam(name = "oFinalizar", targetNamespace = "http://wshr.mtc.gob.pe/")
        Finalizar oFinalizar);

    /**
     * Registro de Hoja Ruta por Empresa de Transporte.
     * 
     * @param oHojaRuta
     * @return
     *     returns com.titanic.ventapasajes.ws.ResultHojaRuta
     */
    @WebMethod(action = "http://wshr.mtc.gob.pe/setHojaRuta")
    @WebResult(name = "setHojaRutaResult", targetNamespace = "http://wshr.mtc.gob.pe/")
    @RequestWrapper(localName = "setHojaRuta", targetNamespace = "http://wshr.mtc.gob.pe/", className = "com.titanic.ventapasajes.ws.SetHojaRuta")
    @ResponseWrapper(localName = "setHojaRutaResponse", targetNamespace = "http://wshr.mtc.gob.pe/", className = "com.titanic.ventapasajes.ws.SetHojaRutaResponse")
    public ResultHojaRuta setHojaRuta(
        @WebParam(name = "oHojaRuta", targetNamespace = "http://wshr.mtc.gob.pe/")
        HojaRuta oHojaRuta);

    /**
     * Registro de Manifiesto por Empresa de Transporte.
     * 
     * @param oManifiesto
     * @return
     *     returns com.titanic.ventapasajes.ws.ResultManifiesto
     */
    @WebMethod(action = "http://wshr.mtc.gob.pe/setManifiesto")
    @WebResult(name = "setManifiestoResult", targetNamespace = "http://wshr.mtc.gob.pe/")
    @RequestWrapper(localName = "setManifiesto", targetNamespace = "http://wshr.mtc.gob.pe/", className = "com.titanic.ventapasajes.ws.SetManifiesto")
    @ResponseWrapper(localName = "setManifiestoResponse", targetNamespace = "http://wshr.mtc.gob.pe/", className = "com.titanic.ventapasajes.ws.SetManifiestoResponse")
    public ResultManifiesto setManifiesto(
        @WebParam(name = "oManifiesto", targetNamespace = "http://wshr.mtc.gob.pe/")
        Manifiesto oManifiesto);

    /**
     * Registro de Tripulante por Empresa de Transporte.
     * 
     * @param oTripulante
     * @return
     *     returns com.titanic.ventapasajes.ws.ResultTripulante
     */
    @WebMethod(action = "http://wshr.mtc.gob.pe/setTripulante")
    @WebResult(name = "setTripulanteResult", targetNamespace = "http://wshr.mtc.gob.pe/")
    @RequestWrapper(localName = "setTripulante", targetNamespace = "http://wshr.mtc.gob.pe/", className = "com.titanic.ventapasajes.ws.SetTripulante")
    @ResponseWrapper(localName = "setTripulanteResponse", targetNamespace = "http://wshr.mtc.gob.pe/", className = "com.titanic.ventapasajes.ws.SetTripulanteResponse")
    public ResultTripulante setTripulante(
        @WebParam(name = "oTripulante", targetNamespace = "http://wshr.mtc.gob.pe/")
        Tripulante oTripulante);

}
