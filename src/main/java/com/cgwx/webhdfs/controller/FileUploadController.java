package com.cgwx.webhdfs.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceClient;


import com.cgwx.webhdfs.WebServiceClient.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/FileUpload")
public class FileUploadController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String remotePath = "";
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");

        //1、创建一个DiskFileItemFactory工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //2、创建一个文件上传解析器
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解决上传文件名的中文乱码
        upload.setHeaderEncoding("UTF-8");
        factory.setSizeThreshold(1024 * 1024 * 1024 * 10);//设置内存的临界值为500K
        File linshi = new File("E://files//");//当超过500K的时候，存到一个临时文件夹中
        factory.setRepository(linshi);
        upload.setSizeMax(1024 * 1024 * 1024 * 10);//设置上传的文件总的大小不能超过10GB
        try {
            // 1. 得到 FileItem 的集合 items
            List<FileItem> /* FileItem */items = upload.parseRequest(request);
            String fileName = "";
            String filePath = "";
            // 2. 遍历 items:
            for (FileItem item : items) {
                // 若是一个一般的表单域, 打印信息
                if (item.isFormField()) {
                    String name = item.getFieldName();
                    String value = item.getString("utf-8");

                    System.out.println(name + ": " + value);
                    remotePath = value;

                }
                // 若是文件域则把文件保存到 e:\\files 目录下.
                else {
                    fileName = item.getName();
                    long sizeInBytes = item.getSize();
                    System.out.println("文件名称：" + fileName + "   文件大小(字节)：" + sizeInBytes);


                    InputStream in = item.getInputStream();
                    byte[] buffer = new byte[1024];
                    int len = 0;

                    filePath = "E://files//" + fileName;//文件最终上传的位置
                    //System.out.println(fileName);
                    OutputStream out = new FileOutputStream(filePath);

                    while ((len = in.read(buffer)) != -1) {
                        out.write(buffer, 0, len);
                    }

                    out.close();
                    in.close();
                }
            }
            remotePath = "/user/hadoop/uploadFiles/" + fileName;
            //加入上传至HDFS的代码
            System.out.println("文件加载至本地成功，开始上传至HDFS......");
            FileOp_Service fileOpService = new FileOp_Service();

            FileOp fileOp = fileOpService.getPort(FileOp.class);
            try {
                System.out.println("开始上传至HDFS......" );
                //fileOp.getNodeMsgHdfs();
                System.out.println(fileName + " " + remotePath);
                fileOp.uploadFile(filePath,remotePath);
                System.out.println("上传至HDFS结束......" );
            } catch (IOException_Exception e) {
                e.printStackTrace();
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }


    }
}