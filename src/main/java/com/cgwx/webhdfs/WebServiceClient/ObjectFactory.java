
package com.cgwx.webhdfs.WebServiceClient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.cgwx.webhdfs.WebServiceClient package. 
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

    private final static QName _FindLocationOnHadoopResponse_QNAME = new QName("http://WebServiceServer.webhdfs.cgwx.com/", "findLocationOnHadoopResponse");
    private final static QName _IOException_QNAME = new QName("http://WebServiceServer.webhdfs.cgwx.com/", "IOException");
    private final static QName _GetFileMetaDataResponse_QNAME = new QName("http://WebServiceServer.webhdfs.cgwx.com/", "getFileMetaDataResponse");
    private final static QName _UploadFile_QNAME = new QName("http://WebServiceServer.webhdfs.cgwx.com/", "uploadFile");
    private final static QName _DeleteFile_QNAME = new QName("http://WebServiceServer.webhdfs.cgwx.com/", "deleteFile");
    private final static QName _RenameFileResponse_QNAME = new QName("http://WebServiceServer.webhdfs.cgwx.com/", "renameFileResponse");
    private final static QName _GetUnderDirAllFileResponse_QNAME = new QName("http://WebServiceServer.webhdfs.cgwx.com/", "getUnderDirAllFileResponse");
    private final static QName _CreateFileResponse_QNAME = new QName("http://WebServiceServer.webhdfs.cgwx.com/", "createFileResponse");
    private final static QName _LoadFile_QNAME = new QName("http://WebServiceServer.webhdfs.cgwx.com/", "loadFile");
    private final static QName _RenameFile_QNAME = new QName("http://WebServiceServer.webhdfs.cgwx.com/", "renameFile");
    private final static QName _CreateDirOnHDFS_QNAME = new QName("http://WebServiceServer.webhdfs.cgwx.com/", "createDirOnHDFS");
    private final static QName _LoadFileResponse_QNAME = new QName("http://WebServiceServer.webhdfs.cgwx.com/", "loadFileResponse");
    private final static QName _UploadFileResponse_QNAME = new QName("http://WebServiceServer.webhdfs.cgwx.com/", "uploadFileResponse");
    private final static QName _DownloadFile_QNAME = new QName("http://WebServiceServer.webhdfs.cgwx.com/", "downloadFile");
    private final static QName _DownloadFileResponse_QNAME = new QName("http://WebServiceServer.webhdfs.cgwx.com/", "downloadFileResponse");
    private final static QName _GetNodeMsgHdfsResponse_QNAME = new QName("http://WebServiceServer.webhdfs.cgwx.com/", "getNodeMsgHdfsResponse");
    private final static QName _GetUnderDirAllFile_QNAME = new QName("http://WebServiceServer.webhdfs.cgwx.com/", "getUnderDirAllFile");
    private final static QName _CreateFile_QNAME = new QName("http://WebServiceServer.webhdfs.cgwx.com/", "createFile");
    private final static QName _FindLocationOnHadoop_QNAME = new QName("http://WebServiceServer.webhdfs.cgwx.com/", "findLocationOnHadoop");
    private final static QName _CreateDirOnHDFSResponse_QNAME = new QName("http://WebServiceServer.webhdfs.cgwx.com/", "createDirOnHDFSResponse");
    private final static QName _GetNodeMsgHdfs_QNAME = new QName("http://WebServiceServer.webhdfs.cgwx.com/", "getNodeMsgHdfs");
    private final static QName _WatchFileLastModifyTime_QNAME = new QName("http://WebServiceServer.webhdfs.cgwx.com/", "watchFileLastModifyTime");
    private final static QName _GetFileMetaData_QNAME = new QName("http://WebServiceServer.webhdfs.cgwx.com/", "getFileMetaData");
    private final static QName _DeleteFileResponse_QNAME = new QName("http://WebServiceServer.webhdfs.cgwx.com/", "deleteFileResponse");
    private final static QName _WatchFileLastModifyTimeResponse_QNAME = new QName("http://WebServiceServer.webhdfs.cgwx.com/", "watchFileLastModifyTimeResponse");
    private final static QName _FindFileIsExit_QNAME = new QName("http://WebServiceServer.webhdfs.cgwx.com/", "findFileIsExit");
    private final static QName _FindFileIsExitResponse_QNAME = new QName("http://WebServiceServer.webhdfs.cgwx.com/", "findFileIsExitResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.cgwx.webhdfs.WebServiceClient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateDirOnHDFSResponse }
     * 
     */
    public CreateDirOnHDFSResponse createCreateDirOnHDFSResponse() {
        return new CreateDirOnHDFSResponse();
    }

    /**
     * Create an instance of {@link GetNodeMsgHdfs }
     * 
     */
    public GetNodeMsgHdfs createGetNodeMsgHdfs() {
        return new GetNodeMsgHdfs();
    }

    /**
     * Create an instance of {@link GetUnderDirAllFile }
     * 
     */
    public GetUnderDirAllFile createGetUnderDirAllFile() {
        return new GetUnderDirAllFile();
    }

    /**
     * Create an instance of {@link CreateFile }
     * 
     */
    public CreateFile createCreateFile() {
        return new CreateFile();
    }

    /**
     * Create an instance of {@link FindLocationOnHadoop }
     * 
     */
    public FindLocationOnHadoop createFindLocationOnHadoop() {
        return new FindLocationOnHadoop();
    }

    /**
     * Create an instance of {@link DeleteFileResponse }
     * 
     */
    public DeleteFileResponse createDeleteFileResponse() {
        return new DeleteFileResponse();
    }

    /**
     * Create an instance of {@link FindFileIsExit }
     * 
     */
    public FindFileIsExit createFindFileIsExit() {
        return new FindFileIsExit();
    }

    /**
     * Create an instance of {@link FindFileIsExitResponse }
     * 
     */
    public FindFileIsExitResponse createFindFileIsExitResponse() {
        return new FindFileIsExitResponse();
    }

    /**
     * Create an instance of {@link WatchFileLastModifyTimeResponse }
     * 
     */
    public WatchFileLastModifyTimeResponse createWatchFileLastModifyTimeResponse() {
        return new WatchFileLastModifyTimeResponse();
    }

    /**
     * Create an instance of {@link WatchFileLastModifyTime }
     * 
     */
    public WatchFileLastModifyTime createWatchFileLastModifyTime() {
        return new WatchFileLastModifyTime();
    }

    /**
     * Create an instance of {@link GetFileMetaData }
     * 
     */
    public GetFileMetaData createGetFileMetaData() {
        return new GetFileMetaData();
    }

    /**
     * Create an instance of {@link DeleteFile }
     * 
     */
    public DeleteFile createDeleteFile() {
        return new DeleteFile();
    }

    /**
     * Create an instance of {@link UploadFile }
     * 
     */
    public UploadFile createUploadFile() {
        return new UploadFile();
    }

    /**
     * Create an instance of {@link RenameFileResponse }
     * 
     */
    public RenameFileResponse createRenameFileResponse() {
        return new RenameFileResponse();
    }

    /**
     * Create an instance of {@link CreateFileResponse }
     * 
     */
    public CreateFileResponse createCreateFileResponse() {
        return new CreateFileResponse();
    }

    /**
     * Create an instance of {@link GetUnderDirAllFileResponse }
     * 
     */
    public GetUnderDirAllFileResponse createGetUnderDirAllFileResponse() {
        return new GetUnderDirAllFileResponse();
    }

    /**
     * Create an instance of {@link FindLocationOnHadoopResponse }
     * 
     */
    public FindLocationOnHadoopResponse createFindLocationOnHadoopResponse() {
        return new FindLocationOnHadoopResponse();
    }

    /**
     * Create an instance of {@link IOException }
     * 
     */
    public IOException createIOException() {
        return new IOException();
    }

    /**
     * Create an instance of {@link GetFileMetaDataResponse }
     * 
     */
    public GetFileMetaDataResponse createGetFileMetaDataResponse() {
        return new GetFileMetaDataResponse();
    }

    /**
     * Create an instance of {@link DownloadFile }
     * 
     */
    public DownloadFile createDownloadFile() {
        return new DownloadFile();
    }

    /**
     * Create an instance of {@link LoadFileResponse }
     * 
     */
    public LoadFileResponse createLoadFileResponse() {
        return new LoadFileResponse();
    }

    /**
     * Create an instance of {@link UploadFileResponse }
     * 
     */
    public UploadFileResponse createUploadFileResponse() {
        return new UploadFileResponse();
    }

    /**
     * Create an instance of {@link DownloadFileResponse }
     * 
     */
    public DownloadFileResponse createDownloadFileResponse() {
        return new DownloadFileResponse();
    }

    /**
     * Create an instance of {@link GetNodeMsgHdfsResponse }
     * 
     */
    public GetNodeMsgHdfsResponse createGetNodeMsgHdfsResponse() {
        return new GetNodeMsgHdfsResponse();
    }

    /**
     * Create an instance of {@link RenameFile }
     * 
     */
    public RenameFile createRenameFile() {
        return new RenameFile();
    }

    /**
     * Create an instance of {@link LoadFile }
     * 
     */
    public LoadFile createLoadFile() {
        return new LoadFile();
    }

    /**
     * Create an instance of {@link CreateDirOnHDFS }
     * 
     */
    public CreateDirOnHDFS createCreateDirOnHDFS() {
        return new CreateDirOnHDFS();
    }

    /**
     * Create an instance of {@link HdfsFileByteArray }
     * 
     */
    public HdfsFileByteArray createHdfsFileByteArray() {
        return new HdfsFileByteArray();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindLocationOnHadoopResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServiceServer.webhdfs.cgwx.com/", name = "findLocationOnHadoopResponse")
    public JAXBElement<FindLocationOnHadoopResponse> createFindLocationOnHadoopResponse(FindLocationOnHadoopResponse value) {
        return new JAXBElement<FindLocationOnHadoopResponse>(_FindLocationOnHadoopResponse_QNAME, FindLocationOnHadoopResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IOException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServiceServer.webhdfs.cgwx.com/", name = "IOException")
    public JAXBElement<IOException> createIOException(IOException value) {
        return new JAXBElement<IOException>(_IOException_QNAME, IOException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFileMetaDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServiceServer.webhdfs.cgwx.com/", name = "getFileMetaDataResponse")
    public JAXBElement<GetFileMetaDataResponse> createGetFileMetaDataResponse(GetFileMetaDataResponse value) {
        return new JAXBElement<GetFileMetaDataResponse>(_GetFileMetaDataResponse_QNAME, GetFileMetaDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadFile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServiceServer.webhdfs.cgwx.com/", name = "uploadFile")
    public JAXBElement<UploadFile> createUploadFile(UploadFile value) {
        return new JAXBElement<UploadFile>(_UploadFile_QNAME, UploadFile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteFile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServiceServer.webhdfs.cgwx.com/", name = "deleteFile")
    public JAXBElement<DeleteFile> createDeleteFile(DeleteFile value) {
        return new JAXBElement<DeleteFile>(_DeleteFile_QNAME, DeleteFile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RenameFileResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServiceServer.webhdfs.cgwx.com/", name = "renameFileResponse")
    public JAXBElement<RenameFileResponse> createRenameFileResponse(RenameFileResponse value) {
        return new JAXBElement<RenameFileResponse>(_RenameFileResponse_QNAME, RenameFileResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUnderDirAllFileResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServiceServer.webhdfs.cgwx.com/", name = "getUnderDirAllFileResponse")
    public JAXBElement<GetUnderDirAllFileResponse> createGetUnderDirAllFileResponse(GetUnderDirAllFileResponse value) {
        return new JAXBElement<GetUnderDirAllFileResponse>(_GetUnderDirAllFileResponse_QNAME, GetUnderDirAllFileResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateFileResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServiceServer.webhdfs.cgwx.com/", name = "createFileResponse")
    public JAXBElement<CreateFileResponse> createCreateFileResponse(CreateFileResponse value) {
        return new JAXBElement<CreateFileResponse>(_CreateFileResponse_QNAME, CreateFileResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadFile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServiceServer.webhdfs.cgwx.com/", name = "loadFile")
    public JAXBElement<LoadFile> createLoadFile(LoadFile value) {
        return new JAXBElement<LoadFile>(_LoadFile_QNAME, LoadFile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RenameFile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServiceServer.webhdfs.cgwx.com/", name = "renameFile")
    public JAXBElement<RenameFile> createRenameFile(RenameFile value) {
        return new JAXBElement<RenameFile>(_RenameFile_QNAME, RenameFile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateDirOnHDFS }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServiceServer.webhdfs.cgwx.com/", name = "createDirOnHDFS")
    public JAXBElement<CreateDirOnHDFS> createCreateDirOnHDFS(CreateDirOnHDFS value) {
        return new JAXBElement<CreateDirOnHDFS>(_CreateDirOnHDFS_QNAME, CreateDirOnHDFS.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadFileResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServiceServer.webhdfs.cgwx.com/", name = "loadFileResponse")
    public JAXBElement<LoadFileResponse> createLoadFileResponse(LoadFileResponse value) {
        return new JAXBElement<LoadFileResponse>(_LoadFileResponse_QNAME, LoadFileResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadFileResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServiceServer.webhdfs.cgwx.com/", name = "uploadFileResponse")
    public JAXBElement<UploadFileResponse> createUploadFileResponse(UploadFileResponse value) {
        return new JAXBElement<UploadFileResponse>(_UploadFileResponse_QNAME, UploadFileResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadFile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServiceServer.webhdfs.cgwx.com/", name = "downloadFile")
    public JAXBElement<DownloadFile> createDownloadFile(DownloadFile value) {
        return new JAXBElement<DownloadFile>(_DownloadFile_QNAME, DownloadFile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadFileResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServiceServer.webhdfs.cgwx.com/", name = "downloadFileResponse")
    public JAXBElement<DownloadFileResponse> createDownloadFileResponse(DownloadFileResponse value) {
        return new JAXBElement<DownloadFileResponse>(_DownloadFileResponse_QNAME, DownloadFileResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNodeMsgHdfsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServiceServer.webhdfs.cgwx.com/", name = "getNodeMsgHdfsResponse")
    public JAXBElement<GetNodeMsgHdfsResponse> createGetNodeMsgHdfsResponse(GetNodeMsgHdfsResponse value) {
        return new JAXBElement<GetNodeMsgHdfsResponse>(_GetNodeMsgHdfsResponse_QNAME, GetNodeMsgHdfsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUnderDirAllFile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServiceServer.webhdfs.cgwx.com/", name = "getUnderDirAllFile")
    public JAXBElement<GetUnderDirAllFile> createGetUnderDirAllFile(GetUnderDirAllFile value) {
        return new JAXBElement<GetUnderDirAllFile>(_GetUnderDirAllFile_QNAME, GetUnderDirAllFile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateFile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServiceServer.webhdfs.cgwx.com/", name = "createFile")
    public JAXBElement<CreateFile> createCreateFile(CreateFile value) {
        return new JAXBElement<CreateFile>(_CreateFile_QNAME, CreateFile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindLocationOnHadoop }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServiceServer.webhdfs.cgwx.com/", name = "findLocationOnHadoop")
    public JAXBElement<FindLocationOnHadoop> createFindLocationOnHadoop(FindLocationOnHadoop value) {
        return new JAXBElement<FindLocationOnHadoop>(_FindLocationOnHadoop_QNAME, FindLocationOnHadoop.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateDirOnHDFSResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServiceServer.webhdfs.cgwx.com/", name = "createDirOnHDFSResponse")
    public JAXBElement<CreateDirOnHDFSResponse> createCreateDirOnHDFSResponse(CreateDirOnHDFSResponse value) {
        return new JAXBElement<CreateDirOnHDFSResponse>(_CreateDirOnHDFSResponse_QNAME, CreateDirOnHDFSResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNodeMsgHdfs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServiceServer.webhdfs.cgwx.com/", name = "getNodeMsgHdfs")
    public JAXBElement<GetNodeMsgHdfs> createGetNodeMsgHdfs(GetNodeMsgHdfs value) {
        return new JAXBElement<GetNodeMsgHdfs>(_GetNodeMsgHdfs_QNAME, GetNodeMsgHdfs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WatchFileLastModifyTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServiceServer.webhdfs.cgwx.com/", name = "watchFileLastModifyTime")
    public JAXBElement<WatchFileLastModifyTime> createWatchFileLastModifyTime(WatchFileLastModifyTime value) {
        return new JAXBElement<WatchFileLastModifyTime>(_WatchFileLastModifyTime_QNAME, WatchFileLastModifyTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFileMetaData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServiceServer.webhdfs.cgwx.com/", name = "getFileMetaData")
    public JAXBElement<GetFileMetaData> createGetFileMetaData(GetFileMetaData value) {
        return new JAXBElement<GetFileMetaData>(_GetFileMetaData_QNAME, GetFileMetaData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteFileResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServiceServer.webhdfs.cgwx.com/", name = "deleteFileResponse")
    public JAXBElement<DeleteFileResponse> createDeleteFileResponse(DeleteFileResponse value) {
        return new JAXBElement<DeleteFileResponse>(_DeleteFileResponse_QNAME, DeleteFileResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WatchFileLastModifyTimeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServiceServer.webhdfs.cgwx.com/", name = "watchFileLastModifyTimeResponse")
    public JAXBElement<WatchFileLastModifyTimeResponse> createWatchFileLastModifyTimeResponse(WatchFileLastModifyTimeResponse value) {
        return new JAXBElement<WatchFileLastModifyTimeResponse>(_WatchFileLastModifyTimeResponse_QNAME, WatchFileLastModifyTimeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindFileIsExit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServiceServer.webhdfs.cgwx.com/", name = "findFileIsExit")
    public JAXBElement<FindFileIsExit> createFindFileIsExit(FindFileIsExit value) {
        return new JAXBElement<FindFileIsExit>(_FindFileIsExit_QNAME, FindFileIsExit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindFileIsExitResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServiceServer.webhdfs.cgwx.com/", name = "findFileIsExitResponse")
    public JAXBElement<FindFileIsExitResponse> createFindFileIsExitResponse(FindFileIsExitResponse value) {
        return new JAXBElement<FindFileIsExitResponse>(_FindFileIsExitResponse_QNAME, FindFileIsExitResponse.class, null, value);
    }

}
