
package org.oc.ws.client.marcas;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for marcaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="marcaType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="marca" type="{http://marca.ws.oc.org/}marcaEntity" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "marcaType", propOrder = {
    "marca"
})
public class MarcaType {

    protected List<MarcaEntity> marca;

    /**
     * Gets the value of the marca property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the marca property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMarca().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MarcaEntity }
     * 
     * 
     */
    public List<MarcaEntity> getMarca() {
        if (marca == null) {
            marca = new ArrayList<MarcaEntity>();
        }
        return this.marca;
    }

}
