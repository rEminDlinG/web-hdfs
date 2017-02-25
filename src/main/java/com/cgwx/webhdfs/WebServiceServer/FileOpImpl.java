package com.cgwx.webhdfs.WebServiceServer;;
import java.io.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.io.BufferedOutputStream;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.hadoop.fs.FSDataInputStream;


import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.hdfs.protocol.DatanodeInfo;
import org.apache.hadoop.io.IOUtils;
import org.springframework.stereotype.Component;
//import org.junit.Before;
//import org.junit.Test;
import javax.xml.ws.Endpoint;
@Component
@WebService(serviceName="FileOpService",endpointInterface="com.cgwx.webhdfs.WebServiceServer.FileOp")
public class FileOpImpl implements FileOp {

    Configuration conf = null;
    String rootPath = null;
    FileSystem coreSys = null;

    int connectNum;
    public FileOpImpl() {

        connectNum = 0;
        conf = new Configuration();//这里创建conf对象有一个默认参数，boolean loadDefaults，默认为true
        String path = this.getClass().getResource("/").getPath().substring(1, this.getClass().getResource("/").getPath().indexOf("classes"));
        String coreconf = path + "classes/config/core-site.xml";
        String hdfsconf = path + "classes/config/hdfs-site.xml";
        String yarnconf = path + "classes/config/yarn-site.xml";
        String mapredconf = path + "classes/config/mapred-site.xml";
        conf.addResource(coreconf);
        rootPath = new String("hdfs://10.10.90.111:9000/");
        try {
            coreSys=FileSystem.get(URI.create(rootPath), conf);

            System.out.println(conf.get("fs.defaultFS"));
            System.out.println(conf.get("hadoop.tmp.dir"));
            System.out.println(conf.get("mapreduce.task.io.sort.mb"));
            System.out.println(conf.get("mapreduce.jobhistory.webapp.address"));
        } catch (IOException e) {
            System.out.println("初始化HDFS核心文件对象失败："+e.getLocalizedMessage());
        }
    }
    @WebMethod
    public boolean createDirOnHDFS(String addDir)throws IOException{

        Path demoDir=new Path(rootPath+addDir);
        System.out.println(demoDir);
        boolean isSuccess=coreSys.mkdirs(demoDir);
        System.out.println(isSuccess?"目录创建成功！":"目录创建失败!");
        return isSuccess;
    }
    @WebMethod
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
    /*public boolean createFile(File localPath, String hdfsPath) throws IOException{
        InputStream in = null;
        try {
            FSDataOutputStream out = coreSys.create(new Path(hdfsPath));
            in = new BufferedInputStream(new FileInputStream(localPath));
            IOUtils.copyBytes(in, out, 4096, false);
            out.hsync();
            out.close();
            System.out.println("create file in hdfs:" + hdfsPath);
        } finally {
            IOUtils.closeStream(in);
        }
        return true;
    }*/
    @WebMethod
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
    @WebMethod
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
    @WebMethod
    public boolean renameFile(String oriFileName,String newFileName)throws IOException{
        Path oldFileName=new Path(rootPath+oriFileName);
        Path newfileName=new Path(rootPath+newFileName);
        boolean isSuccess=coreSys.rename(oldFileName, newfileName);
        System.out.println(isSuccess?"重命名成功！":"重命名失败！");
        return true;
    }
    @WebMethod
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
    @WebMethod
    public boolean watchFileLastModifyTime(String fileName)throws IOException{
        Path targetFile=new Path(rootPath+fileName);
        FileStatus fileStatus=coreSys.getFileStatus(targetFile);
        Long lastTime=fileStatus.getModificationTime();
        Date date=new Date(lastTime);
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.err.println("文件的最后修改时间为:"+format.format(date));
        return true;
    }
    @WebMethod
    public boolean getUnderDirAllFile(String dirName)throws IOException{
        Path targetDir=new Path(rootPath+dirName);
        FileStatus []fileStatus=coreSys.listStatus(targetDir);
        for(FileStatus file:fileStatus){
            System.out.println(file.getPath()+"--"+file.getGroup()+"--"+file.getBlockSize()+"--"+file.getLen()+"--"+file.getModificationTime()+"--"+file.getOwner());
        }
        return true;
    }
    @WebMethod
    public boolean findLocationOnHadoop(String fileName)throws IOException{
        Path targetFile=new Path(rootPath+fileName);
        FileStatus fileStaus  = coreSys.getFileStatus(targetFile);
        BlockLocation []bloLocations = coreSys.getFileBlockLocations(fileStaus, 0, fileStaus.getLen());
        for(int i=0;i<bloLocations.length;i++){
            System.out.println("block_"+i+"_location:"+bloLocations[i].getHosts()[0]);
        }
        return true;
    }
    @WebMethod
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
    @WebMethod
    public HDFSFileByteArray loadFile(String fileName)throws IOException{
        connectNum++;

        SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(time.format(new java.util.Date())+"  loadFile请求:"+fileName + "       次数："+ connectNum);
        HDFSFileByteArray fba = new HDFSFileByteArray();
        //InputStream in = coreSys.open(new Path(rootPath + fileName));
        try {
            FSDataInputStream in = coreSys.open(new Path(rootPath + fileName));
            FileStatus fileStatus = coreSys.getFileStatus(new Path(rootPath + fileName));
            fba.fileLength = fileStatus.getLen();
            fba.fileBuffer = new byte[(int)fba.fileLength];
            int readCount = 0; // 已经成功读取的字节的个数
            while (readCount < fba.fileLength) {
                readCount += in.read(fba.fileBuffer, readCount, (int)(fba.fileLength - readCount));
            }
            in.close();
        } catch (IOException e) {
            System.out.println(time.format(new java.util.Date())+"  loadFile请求:"+fileName + "       失败，HDFS系统中不存在该文件！");
        }
        return fba;
    }
    @WebMethod
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