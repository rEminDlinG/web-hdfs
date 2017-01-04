
package com.cgwx.webhdfs.WebServiceClient;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "FileOp", targetNamespace = "http://WebServiceServer.webhdfs.cgwx.com/", wsdlLocation = "http://localhost:8080/services/FileOp?wsdl")
public class FileOp_Service
    extends Service
{

    private final static URL FILEOP_WSDL_LOCATION;
    private final static WebServiceException FILEOP_EXCEPTION;
    private final static QName FILEOP_QNAME = new QName("http://WebServiceServer.webhdfs.cgwx.com/", "FileOp");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/services/FileOp?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        FILEOP_WSDL_LOCATION = url;
        FILEOP_EXCEPTION = e;
    }

    public FileOp_Service() {
        super(__getWsdlLocation(), FILEOP_QNAME);
    }

    public FileOp_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), FILEOP_QNAME, features);
    }

    public FileOp_Service(URL wsdlLocation) {
        super(wsdlLocation, FILEOP_QNAME);
    }

    public FileOp_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, FILEOP_QNAME, features);
    }

    public FileOp_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public FileOp_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns FileOp
     */
    @WebEndpoint(name = "FileOpImplPort")
    public FileOp getFileOpImplPort() {
        return super.getPort(new QName("http://WebServiceServer.webhdfs.cgwx.com/", "FileOpImplPort"), FileOp.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns FileOp
     */
    @WebEndpoint(name = "FileOpImplPort")
    public FileOp getFileOpImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://WebServiceServer.webhdfs.cgwx.com/", "FileOpImplPort"), FileOp.class, features);
    }

    private static URL __getWsdlLocation() {
        if (FILEOP_EXCEPTION!= null) {
            throw FILEOP_EXCEPTION;
        }
        return FILEOP_WSDL_LOCATION;
    }

}
