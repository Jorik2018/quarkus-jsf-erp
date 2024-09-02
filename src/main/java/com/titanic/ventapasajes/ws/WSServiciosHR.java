
package com.titanic.ventapasajes.ws;

import java.net.MalformedURLException;
import java.net.URL;
//import jakarta.xml.namespace.QName;
import jakarta.xml.ws.Service;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceException;
import jakarta.xml.ws.WebServiceFeature;

@WebServiceClient(name = "WSServiciosHR", targetNamespace = "http://wshr.mtc.gob.pe/", wsdlLocation = "http://pruebawshr.mtc.gob.pe/WSServiciosHR.asmx?WSDL")
public class WSServiciosHR extends Service {

    public WSServiciosHR() {
        this(WSSERVICIOSHR_WSDL_LOCATION);
        // super(__getWsdlLocation(), WSSERVICIOSHR_QNAME);
    }

     public WSServiciosHR(URL wsdlLocation) {
        super(wsdlLocation, null);
    }

    private final static URL WSSERVICIOSHR_WSDL_LOCATION;
    private final static WebServiceException WSSERVICIOSHR_EXCEPTION;
    //private final static QName WSSERVICIOSHR_QNAME = new QName("http://wshr.mtc.gob.pe/", "WSServiciosHR");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://pruebawshr.mtc.gob.pe/WSServiciosHR.asmx?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WSSERVICIOSHR_WSDL_LOCATION = url;
        WSSERVICIOSHR_EXCEPTION = e;
    }



    //public WSServiciosHR(WebServiceFeature... features) {
        //super(__getWsdlLocation(), WSSERVICIOSHR_QNAME, features);
    //}

    //public WSServiciosHR(URL wsdlLocation) {
        //super(wsdlLocation, WSSERVICIOSHR_QNAME);
    //}

    //public WSServiciosHR(URL wsdlLocation, WebServiceFeature... features) {
        //super(wsdlLocation, WSSERVICIOSHR_QNAME, features);
    //}

    /*public WSServiciosHR(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WSServiciosHR(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WSServiciosHRSoap
     */
    @WebEndpoint(name = "WSServiciosHRSoap")
    public WSServiciosHRSoap getWSServiciosHRSoap() {
        return null;//super.getPort(new QName("http://wshr.mtc.gob.pe/", "WSServiciosHRSoap"), WSServiciosHRSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WSServiciosHRSoap
     */
    @WebEndpoint(name = "WSServiciosHRSoap")
    public WSServiciosHRSoap getWSServiciosHRSoap(WebServiceFeature... features) {
        return null;//super.getPort(new QName("http://wshr.mtc.gob.pe/", "WSServiciosHRSoap"), WSServiciosHRSoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WSSERVICIOSHR_EXCEPTION!= null) {
            throw WSSERVICIOSHR_EXCEPTION;
        }
        return WSSERVICIOSHR_WSDL_LOCATION;
    }

}
