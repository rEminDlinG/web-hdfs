
package com.cgwx.webhdfs.WebServiceClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>hdfsFileByteArray complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="hdfsFileByteArray">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fileLength" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="fileBuffer" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "hdfsFileByteArray", propOrder = {
    "fileLength",
    "fileBuffer"
})
public class HdfsFileByteArray {

    protected long fileLength;
    protected byte[] fileBuffer;

    /**
     * 获取fileLength属性的值。
     * 
     */
    public long getFileLength() {
        return fileLength;
    }

    /**
     * 设置fileLength属性的值。
     * 
     */
    public void setFileLength(long value) {
        this.fileLength = value;
    }

    /**
     * 获取fileBuffer属性的值。
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getFileBuffer() {
        return fileBuffer;
    }

    /**
     * 设置fileBuffer属性的值。
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setFileBuffer(byte[] value) {
        this.fileBuffer = value;
    }

}
