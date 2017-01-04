
package com.cgwx.webhdfs.WebServiceClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>hdfsFileByteArray complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡfileLength���Ե�ֵ��
     * 
     */
    public long getFileLength() {
        return fileLength;
    }

    /**
     * ����fileLength���Ե�ֵ��
     * 
     */
    public void setFileLength(long value) {
        this.fileLength = value;
    }

    /**
     * ��ȡfileBuffer���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getFileBuffer() {
        return fileBuffer;
    }

    /**
     * ����fileBuffer���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setFileBuffer(byte[] value) {
        this.fileBuffer = value;
    }

}
