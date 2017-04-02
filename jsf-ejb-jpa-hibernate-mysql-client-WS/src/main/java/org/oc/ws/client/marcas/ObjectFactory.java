
package org.oc.ws.client.marcas;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.oc.ws.client.marcas package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Teste_QNAME = new QName("http://marca.ws.oc.org/", "teste");
    private final static QName _TesteResponse_QNAME = new QName("http://marca.ws.oc.org/", "testeResponse");
    private final static QName _GetAllMarcasResponse_QNAME = new QName("http://marca.ws.oc.org/", "getAllMarcasResponse");
    private final static QName _MarcaEntity_QNAME = new QName("http://marca.ws.oc.org/", "marcaEntity");
    private final static QName _GetAllMarcas_QNAME = new QName("http://marca.ws.oc.org/", "getAllMarcas");
    private final static QName _MarcaType_QNAME = new QName("http://marca.ws.oc.org/", "marcaType");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.oc.ws.client.marcas
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TesteResponse }
     * 
     */
    public TesteResponse createTesteResponse() {
        return new TesteResponse();
    }

    /**
     * Create an instance of {@link Teste }
     * 
     */
    public Teste createTeste() {
        return new Teste();
    }

    /**
     * Create an instance of {@link MarcaType }
     * 
     */
    public MarcaType createMarcaType() {
        return new MarcaType();
    }

    /**
     * Create an instance of {@link GetAllMarcas }
     * 
     */
    public GetAllMarcas createGetAllMarcas() {
        return new GetAllMarcas();
    }

    /**
     * Create an instance of {@link MarcaEntity }
     * 
     */
    public MarcaEntity createMarcaEntity() {
        return new MarcaEntity();
    }

    /**
     * Create an instance of {@link GetAllMarcasResponse }
     * 
     */
    public GetAllMarcasResponse createGetAllMarcasResponse() {
        return new GetAllMarcasResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Teste }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://marca.ws.oc.org/", name = "teste")
    public JAXBElement<Teste> createTeste(Teste value) {
        return new JAXBElement<Teste>(_Teste_QNAME, Teste.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TesteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://marca.ws.oc.org/", name = "testeResponse")
    public JAXBElement<TesteResponse> createTesteResponse(TesteResponse value) {
        return new JAXBElement<TesteResponse>(_TesteResponse_QNAME, TesteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllMarcasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://marca.ws.oc.org/", name = "getAllMarcasResponse")
    public JAXBElement<GetAllMarcasResponse> createGetAllMarcasResponse(GetAllMarcasResponse value) {
        return new JAXBElement<GetAllMarcasResponse>(_GetAllMarcasResponse_QNAME, GetAllMarcasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MarcaEntity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://marca.ws.oc.org/", name = "marcaEntity")
    public JAXBElement<MarcaEntity> createMarcaEntity(MarcaEntity value) {
        return new JAXBElement<MarcaEntity>(_MarcaEntity_QNAME, MarcaEntity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllMarcas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://marca.ws.oc.org/", name = "getAllMarcas")
    public JAXBElement<GetAllMarcas> createGetAllMarcas(GetAllMarcas value) {
        return new JAXBElement<GetAllMarcas>(_GetAllMarcas_QNAME, GetAllMarcas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MarcaType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://marca.ws.oc.org/", name = "marcaType")
    public JAXBElement<MarcaType> createMarcaType(MarcaType value) {
        return new JAXBElement<MarcaType>(_MarcaType_QNAME, MarcaType.class, null, value);
    }

}
