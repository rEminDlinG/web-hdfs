package com.cgwx.webhdfs.WebServiceServer;;
import java.io.BufferedOutputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.jws.WebService;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.hadoop.fs.FSDataInputStream;


import org.apache.hadoop.fs.FSDataOutputStream;
import java.io.FileOutputStream;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.hdfs.protocol.DatanodeInfo;
import org.apache.hadoop.io.IOUtils;
//import org.junit.Before;
//import org.junit.Test;
import javax.xml.ws.Endpoint;
@WebService(endpointInterface="com.cgwx.webhdfs.WebServiceServer.FileOp",serviceName="FileOp")

public class FileOpImpl implements FileOp {

    Configuration conf = null;
    String rootPath = null;
    FileSystem coreSys = null;

    int connectNum;
    public FileOpImpl() {

        connectNum = 0;
        conf = new Configuration();//这里创建conf对象有一个默认参数，boolean loadDefaults，默认为true
        rootPath = new String("hdfs://10.10.90.111:9000/");
        try {
            coreSys=FileSystem.get(URI.create(rootPath), conf);
        } catch (IOException e) {
            System.out.println("初始化HDFS核心文件对象失败："+e.getLocalizedMessage());
        }
    }
    public boolean createDirOnHDFS(String addDir)throws IOException{

        Path demoDir=new Path(rootPath+addDir);
        System.out.println(demoDir);
        boolean isSuccess=coreSys.mkdirs(demoDir);
        System.out.println(isSuccess?"目录创建成功！":"目录创建失败!");
        return isSuccess;
    }
    public boolean createFile(String fileName,String dirName,String fileContent) throws IOException{

        Path filePath = new Path(rootPath + dirName + fileName);
        FSDataOutputStream fileOutput = coreSys.create(filePath);
        BufferedOutputStream bout = new BufferedOutputStream(fileOutput);
        bout.write(fileContent.getBytes(), 0, fileContent.getBytes().length);
        bout.close();
        fileOutput.close();
        System.out.println("文件创建完毕！");
        return true;
    }
    public boolean uploadFile(String localFileName,String remoteFilePath)throws IOException{
        System.out.println("收到webservive请求:uploadFile");
        System.out.println(localFileName + "::" + remoteFilePath);
        Configuration conf = new Configuration();
        Path remotePath = new Path(rootPath + remoteFilePath);
        System.out.println(remotePath);
        coreSys.copyFromLocalFile(new Path(localFileName), remotePath);

        FileStatus [] files=coreSys.listStatus(remotePath);
        for(FileStatus file:files){
            System.out.println(file.getPath().toString());
        }
        return true;
    }
    public boolean downloadFile(String localFileName,String remoteFilePath)throws IOException {
        System.out.println("收到webservive请求:downloadFile");
        Path remotePath = new Path(rootPath + remoteFilePath);
        Path localPath = new Path(localFileName);
        InputStream in = coreSys.open(remotePath);
        OutputStream out = new FileOutputStream(localFileName);
        IOUtils.copyBytes(in, out, 4096, true);
        coreSys.copyToLocalFile(remotePath,localPath);
        return true;
    }
    public boolean renameFile(String oriFileName,String newFileName)throws IOException{
        Path oldFileName=new Path(rootPath+oriFileName);
        Path newfileName=new Path(rootPath+newFileName);
        boolean isSuccess=coreSys.rename(oldFileName, newfileName);
        System.out.println(isSuccess?"重命名成功！":"重命名失败！");
        return true;
    }
    public boolean deleteFile(String fileName)throws IOException{
        Path deleteFile=new Path(rootPath+fileName);
        boolean isSuccess=coreSys.delete(deleteFile, false);
        System.out.println(isSuccess?"删除成功!":"删除失败！");
        return true;
    }
    public boolean findFileIsExit(String fileName)throws IOException{
        System.out.println("收到webservive请求！");
        Path checkFile=new Path(rootPath+fileName);
        boolean isExit=coreSys.exists(checkFile);
        System.out.println(isExit?"文件存在!":"文件不存在！");
        return isExit;
    }
    public boolean watchFileLastModifyTime(String fileName)throws IOException{
        Path targetFile=new Path(rootPath+fileName);
        FileStatus fileStatus=coreSys.getFileStatus(targetFile);
        Long lastTime=fileStatus.getModificationTime();
        Date date=new Date(lastTime);
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.err.println("文件的最后修改时间为:"+format.format(date));
        return true;
    }
    public boolean getUnderDirAllFile(String dirName)throws IOException{
        Path targetDir=new Path(rootPath+dirName);
        FileStatus []fileStatus=coreSys.listStatus(targetDir);
        for(FileStatus file:fileStatus){
            System.out.println(file.getPath()+"--"+file.getGroup()+"--"+file.getBlockSize()+"--"+file.getLen()+"--"+file.getModificationTime()+"--"+file.getOwner());
        }
        return true;
    }
    public boolean findLocationOnHadoop(String fileName)throws IOException{
        Path targetFile=new Path(rootPath+fileName);
        FileStatus fileStaus  = coreSys.getFileStatus(targetFile);
        BlockLocation []bloLocations = coreSys.getFileBlockLocations(fileStaus, 0, fileStaus.getLen());
        for(int i=0;i<bloLocations.length;i++){
            System.out.println("block_"+i+"_location:"+bloLocations[i].getHosts()[0]);
        }
        return true;
    }
    public boolean getNodeMsgHdfs()throws IOException{
        connectNum++;
        SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(time.format(new java.util.Date())+"  getNodeMsgHdfs请求"+ "       次数："+ connectNum);
        DistributedFileSystem distributedFileSystem=(DistributedFileSystem) coreSys;
        DatanodeInfo []dataInfos = distributedFileSystem.getDataNodeStats();
        for(int j=0;j<dataInfos.length;j++){
            System.out.println("DataNode_"+j+"_Name:"+dataInfos[j].getHostName()+"--->"+dataInfos[j].getDatanodeReport()+"-->"+
                    dataInfos[j].getDfsUsedPercent()+"-->"+dataInfos[j].getLevel());
        }
        return true;
    }
    public HDFSFileByteArray loadFile(String fileName)throws IOException{
        connectNum++;

        SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(time.format(new java.util.Date())+"  loadFile请求:"+fileName + "       次数："+ connectNum);
        HDFSFileByteArray fba = new HDFSFileByteArray();
        //InputStream in = coreSys.open(new Path(rootPath + fileName));
        FSDataInputStream in = coreSys.open(new Path(rootPath + fileName));
        FileStatus fileStatus = coreSys.getFileStatus(new Path(rootPath + fileName));
        fba.fileLength = fileStatus.getLen();
        fba.fileBuffer = new byte[(int)fba.fileLength];
        int readCount = 0; // 已经成功读取的字节的个数
        while (readCount < fba.fileLength) {
            readCount += in.read(fba.fileBuffer, readCount, (int)(fba.fileLength - readCount));
        }
        in.close();
        return fba;
    }
    public boolean getFileMetaData(String fileName)throws IOException{

        return true;}

    public static void main(String[] args) throws Exception {
        System.out.println("web service starting......");
        FileOpImpl implementor= new FileOpImpl();
        String address="http://10.10.90.15:8080/FileOp";
        Endpoint.publish(address, implementor);
        System.out.println("web service started......");
    }

}