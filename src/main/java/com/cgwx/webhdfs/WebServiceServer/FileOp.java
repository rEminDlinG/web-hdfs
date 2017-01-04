package com.cgwx.webhdfs.WebServiceServer;

/**
 * Created by hadoop on 2016/11/2.
 */
import java.util.List;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.io.IOException;

@WebService
public interface FileOp {
    boolean createDirOnHDFS(@WebParam(name="addDir")String addDir)throws IOException;           //创建目录
    boolean createFile(String fileName,String dirName,String fileContent)throws IOException;    //创建文件
    boolean uploadFile(String localFileName,String remoteFilePath)throws IOException;           //上传文件
    boolean downloadFile(String localFileName,String remoteFilePath)throws IOException;         //下载文件到本地
    boolean renameFile(String oriFileName,String newFileName)throws IOException;                //重命名文件
    boolean deleteFile(String fileName)throws IOException;                                      //删除文件
    boolean findFileIsExit(String fileName)throws IOException;                                  //查找文件是否存在
    boolean watchFileLastModifyTime(String fileName)throws IOException;                         //查看文件最后修改时间
    boolean getUnderDirAllFile(String dirName)throws IOException;                               //获得指定目录下所有文件
    boolean findLocationOnHadoop(String fileName)throws IOException;                            //获得指定文件在集群的那个节点
    boolean getNodeMsgHdfs()throws IOException;                                                 //获取集群节点信息
    HDFSFileByteArray loadFile(String fileName)throws IOException;                                        //从HDFS中读取数据
    boolean getFileMetaData(String fileName)throws IOException;                                 //从HDFS中读取数据

}