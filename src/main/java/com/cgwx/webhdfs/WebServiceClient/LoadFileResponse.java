
package com.cgwx.webhdfs.WebServiceClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>loadFileResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="loadFileResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://WebServiceServer.webhdfs.cgwx.com/}hdfsFileByteArray" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "loadFileResponse", propOrder = {
    "_return"
})
public class LoadFileResponse {

    @XmlElement(name = "return")
    protected HdfsFileByteArray _return;

    /**
     * 获取return属性的值。
     * 
     * @return
     *     possible object is
     *     {@link HdfsFileByteArray }
     *     
     */
    public HdfsFileByteArray getReturn() {
        return _return;
    }

    /**
     * 设置return属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link HdfsFileByteArray }
     *     
     */
    public void setReturn(HdfsFileByteArray value) {
        this._return = value;
    }

}
