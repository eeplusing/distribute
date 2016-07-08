
package com.lixuan.corejava2.ch9.server.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getPrice", namespace = "http://server.ch9.corejava2.lixuan.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPrice", namespace = "http://server.ch9.corejava2.lixuan.com/")
public class GetPrice {

    @XmlElement(name = "description", namespace = "")
    private String description;

    /**
     * 
     * @return
     *     returns String
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * 
     * @param description
     *     the value for the description property
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
