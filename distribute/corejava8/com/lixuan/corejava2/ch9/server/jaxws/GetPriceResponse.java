
package com.lixuan.corejava2.ch9.server.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getPriceResponse", namespace = "http://server.ch9.corejava2.lixuan.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPriceResponse", namespace = "http://server.ch9.corejava2.lixuan.com/")
public class GetPriceResponse {

    @XmlElement(name = "return", namespace = "")
    private double _return;

    /**
     * 
     * @return
     *     returns double
     */
    public double getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(double _return) {
        this._return = _return;
    }

}
