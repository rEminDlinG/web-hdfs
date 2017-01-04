
package com.cgwx.webhdfs.WebServiceClient;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "FileOp", targetNamespace = "http://WebServiceServer.webhdfs.cgwx.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface FileOp {


    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     * @throws IOException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createFile", targetNamespace = "http://WebServiceServer.webhdfs.cgwx.com/", className = "com.cgwx.webhdfs.WebServiceClient.CreateFile")
    @ResponseWrapper(localName = "createFileResponse", targetNamespace = "http://WebServiceServer.webhdfs.cgwx.com/", className = "com.cgwx.webhdfs.WebServiceClient.CreateFileResponse")
    @Action(input = "http://WebServiceServer.webhdfs.cgwx.com/FileOp/createFileRequest", output = "http://WebServiceServer.webhdfs.cgwx.com/FileOp/createFileResponse", fault = {
        @FaultAction(className = IOException_Exception.class, value = "http://WebServiceServer.webhdfs.cgwx.com/FileOp/createFile/Fault/IOException")
    })
    public boolean createFile(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2)
        throws IOException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     * @throws IOException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getUnderDirAllFile", targetNamespace = "http://WebServiceServer.webhdfs.cgwx.com/", className = "com.cgwx.webhdfs.WebServiceClient.GetUnderDirAllFile")
    @ResponseWrapper(localName = "getUnderDirAllFileResponse", targetNamespace = "http://WebServiceServer.webhdfs.cgwx.com/", className = "com.cgwx.webhdfs.WebServiceClient.GetUnderDirAllFileResponse")
    @Action(input = "http://WebServiceServer.webhdfs.cgwx.com/FileOp/getUnderDirAllFileRequest", output = "http://WebServiceServer.webhdfs.cgwx.com/FileOp/getUnderDirAllFileResponse", fault = {
        @FaultAction(className = IOException_Exception.class, value = "http://WebServiceServer.webhdfs.cgwx.com/FileOp/getUnderDirAllFile/Fault/IOException")
    })
    public boolean getUnderDirAllFile(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0)
        throws IOException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     * @throws IOException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findLocationOnHadoop", targetNamespace = "http://WebServiceServer.webhdfs.cgwx.com/", className = "com.cgwx.webhdfs.WebServiceClient.FindLocationOnHadoop")
    @ResponseWrapper(localName = "findLocationOnHadoopResponse", targetNamespace = "http://WebServiceServer.webhdfs.cgwx.com/", className = "com.cgwx.webhdfs.WebServiceClient.FindLocationOnHadoopResponse")
    @Action(input = "http://WebServiceServer.webhdfs.cgwx.com/FileOp/findLocationOnHadoopRequest", output = "http://WebServiceServer.webhdfs.cgwx.com/FileOp/findLocationOnHadoopResponse", fault = {
        @FaultAction(className = IOException_Exception.class, value = "http://WebServiceServer.webhdfs.cgwx.com/FileOp/findLocationOnHadoop/Fault/IOException")
    })
    public boolean findLocationOnHadoop(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0)
        throws IOException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     * @throws IOException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "watchFileLastModifyTime", targetNamespace = "http://WebServiceServer.webhdfs.cgwx.com/", className = "com.cgwx.webhdfs.WebServiceClient.WatchFileLastModifyTime")
    @ResponseWrapper(localName = "watchFileLastModifyTimeResponse", targetNamespace = "http://WebServiceServer.webhdfs.cgwx.com/", className = "com.cgwx.webhdfs.WebServiceClient.WatchFileLastModifyTimeResponse")
    @Action(input = "http://WebServiceServer.webhdfs.cgwx.com/FileOp/watchFileLastModifyTimeRequest", output = "http://WebServiceServer.webhdfs.cgwx.com/FileOp/watchFileLastModifyTimeResponse", fault = {
        @FaultAction(className = IOException_Exception.class, value = "http://WebServiceServer.webhdfs.cgwx.com/FileOp/watchFileLastModifyTime/Fault/IOException")
    })
    public boolean watchFileLastModifyTime(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0)
        throws IOException_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     * @throws IOException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "uploadFile", targetNamespace = "http://WebServiceServer.webhdfs.cgwx.com/", className = "com.cgwx.webhdfs.WebServiceClient.UploadFile")
    @ResponseWrapper(localName = "uploadFileResponse", targetNamespace = "http://WebServiceServer.webhdfs.cgwx.com/", className = "com.cgwx.webhdfs.WebServiceClient.UploadFileResponse")
    @Action(input = "http://WebServiceServer.webhdfs.cgwx.com/FileOp/uploadFileRequest", output = "http://WebServiceServer.webhdfs.cgwx.com/FileOp/uploadFileResponse", fault = {
        @FaultAction(className = IOException_Exception.class, value = "http://WebServiceServer.webhdfs.cgwx.com/FileOp/uploadFile/Fault/IOException")
    })
    public boolean uploadFile(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1)
        throws IOException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     * @throws IOException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteFile", targetNamespace = "http://WebServiceServer.webhdfs.cgwx.com/", className = "com.cgwx.webhdfs.WebServiceClient.DeleteFile")
    @ResponseWrapper(localName = "deleteFileResponse", targetNamespace = "http://WebServiceServer.webhdfs.cgwx.com/", className = "com.cgwx.webhdfs.WebServiceClient.DeleteFileResponse")
    @Action(input = "http://WebServiceServer.webhdfs.cgwx.com/FileOp/deleteFileRequest", output = "http://WebServiceServer.webhdfs.cgwx.com/FileOp/deleteFileResponse", fault = {
        @FaultAction(className = IOException_Exception.class, value = "http://WebServiceServer.webhdfs.cgwx.com/FileOp/deleteFile/Fault/IOException")
    })
    public boolean deleteFile(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0)
        throws IOException_Exception
    ;

    /**
     * 
     * @return
     *     returns boolean
     * @throws IOException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getNodeMsgHdfs", targetNamespace = "http://WebServiceServer.webhdfs.cgwx.com/", className = "com.cgwx.webhdfs.WebServiceClient.GetNodeMsgHdfs")
    @ResponseWrapper(localName = "getNodeMsgHdfsResponse", targetNamespace = "http://WebServiceServer.webhdfs.cgwx.com/", className = "com.cgwx.webhdfs.WebServiceClient.GetNodeMsgHdfsResponse")
    @Action(input = "http://WebServiceServer.webhdfs.cgwx.com/FileOp/getNodeMsgHdfsRequest", output = "http://WebServiceServer.webhdfs.cgwx.com/FileOp/getNodeMsgHdfsResponse", fault = {
        @FaultAction(className = IOException_Exception.class, value = "http://WebServiceServer.webhdfs.cgwx.com/FileOp/getNodeMsgHdfs/Fault/IOException")
    })
    public boolean getNodeMsgHdfs()
        throws IOException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     * @throws IOException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findFileIsExit", targetNamespace = "http://WebServiceServer.webhdfs.cgwx.com/", className = "com.cgwx.webhdfs.WebServiceClient.FindFileIsExit")
    @ResponseWrapper(localName = "findFileIsExitResponse", targetNamespace = "http://WebServiceServer.webhdfs.cgwx.com/", className = "com.cgwx.webhdfs.WebServiceClient.FindFileIsExitResponse")
    @Action(input = "http://WebServiceServer.webhdfs.cgwx.com/FileOp/findFileIsExitRequest", output = "http://WebServiceServer.webhdfs.cgwx.com/FileOp/findFileIsExitResponse", fault = {
        @FaultAction(className = IOException_Exception.class, value = "http://WebServiceServer.webhdfs.cgwx.com/FileOp/findFileIsExit/Fault/IOException")
    })
    public boolean findFileIsExit(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0)
        throws IOException_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     * @throws IOException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "downloadFile", targetNamespace = "http://WebServiceServer.webhdfs.cgwx.com/", className = "com.cgwx.webhdfs.WebServiceClient.DownloadFile")
    @ResponseWrapper(localName = "downloadFileResponse", targetNamespace = "http://WebServiceServer.webhdfs.cgwx.com/", className = "com.cgwx.webhdfs.WebServiceClient.DownloadFileResponse")
    @Action(input = "http://WebServiceServer.webhdfs.cgwx.com/FileOp/downloadFileRequest", output = "http://WebServiceServer.webhdfs.cgwx.com/FileOp/downloadFileResponse", fault = {
        @FaultAction(className = IOException_Exception.class, value = "http://WebServiceServer.webhdfs.cgwx.com/FileOp/downloadFile/Fault/IOException")
    })
    public boolean downloadFile(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1)
        throws IOException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     * @throws IOException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getFileMetaData", targetNamespace = "http://WebServiceServer.webhdfs.cgwx.com/", className = "com.cgwx.webhdfs.WebServiceClient.GetFileMetaData")
    @ResponseWrapper(localName = "getFileMetaDataResponse", targetNamespace = "http://WebServiceServer.webhdfs.cgwx.com/", className = "com.cgwx.webhdfs.WebServiceClient.GetFileMetaDataResponse")
    @Action(input = "http://WebServiceServer.webhdfs.cgwx.com/FileOp/getFileMetaDataRequest", output = "http://WebServiceServer.webhdfs.cgwx.com/FileOp/getFileMetaDataResponse", fault = {
        @FaultAction(className = IOException_Exception.class, value = "http://WebServiceServer.webhdfs.cgwx.com/FileOp/getFileMetaData/Fault/IOException")
    })
    public boolean getFileMetaData(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0)
        throws IOException_Exception
    ;

    /**
     * 
     * @param addDir
     * @return
     *     returns boolean
     * @throws IOException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createDirOnHDFS", targetNamespace = "http://WebServiceServer.webhdfs.cgwx.com/", className = "com.cgwx.webhdfs.WebServiceClient.CreateDirOnHDFS")
    @ResponseWrapper(localName = "createDirOnHDFSResponse", targetNamespace = "http://WebServiceServer.webhdfs.cgwx.com/", className = "com.cgwx.webhdfs.WebServiceClient.CreateDirOnHDFSResponse")
    @Action(input = "http://WebServiceServer.webhdfs.cgwx.com/FileOp/createDirOnHDFSRequest", output = "http://WebServiceServer.webhdfs.cgwx.com/FileOp/createDirOnHDFSResponse", fault = {
        @FaultAction(className = IOException_Exception.class, value = "http://WebServiceServer.webhdfs.cgwx.com/FileOp/createDirOnHDFS/Fault/IOException")
    })
    public boolean createDirOnHDFS(
        @WebParam(name = "addDir", targetNamespace = "")
        String addDir)
        throws IOException_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     * @throws IOException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "renameFile", targetNamespace = "http://WebServiceServer.webhdfs.cgwx.com/", className = "com.cgwx.webhdfs.WebServiceClient.RenameFile")
    @ResponseWrapper(localName = "renameFileResponse", targetNamespace = "http://WebServiceServer.webhdfs.cgwx.com/", className = "com.cgwx.webhdfs.WebServiceClient.RenameFileResponse")
    @Action(input = "http://WebServiceServer.webhdfs.cgwx.com/FileOp/renameFileRequest", output = "http://WebServiceServer.webhdfs.cgwx.com/FileOp/renameFileResponse", fault = {
        @FaultAction(className = IOException_Exception.class, value = "http://WebServiceServer.webhdfs.cgwx.com/FileOp/renameFile/Fault/IOException")
    })
    public boolean renameFile(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1)
        throws IOException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns com.cgwx.webhdfs.WebServiceClient.HdfsFileByteArray
     * @throws IOException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "loadFile", targetNamespace = "http://WebServiceServer.webhdfs.cgwx.com/", className = "com.cgwx.webhdfs.WebServiceClient.LoadFile")
    @ResponseWrapper(localName = "loadFileResponse", targetNamespace = "http://WebServiceServer.webhdfs.cgwx.com/", className = "com.cgwx.webhdfs.WebServiceClient.LoadFileResponse")
    @Action(input = "http://WebServiceServer.webhdfs.cgwx.com/FileOp/loadFileRequest", output = "http://WebServiceServer.webhdfs.cgwx.com/FileOp/loadFileResponse", fault = {
        @FaultAction(className = IOException_Exception.class, value = "http://WebServiceServer.webhdfs.cgwx.com/FileOp/loadFile/Fault/IOException")
    })
    public HdfsFileByteArray loadFile(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0)
        throws IOException_Exception
    ;

}
