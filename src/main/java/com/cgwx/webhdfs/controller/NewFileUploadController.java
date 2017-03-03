package com.cgwx.webhdfs.controller;

import com.cgwx.webhdfs.WebServiceClient.FileOp;
import com.cgwx.webhdfs.WebServiceClient.FileOpService;
import com.cgwx.webhdfs.WebServiceClient.IOException_Exception;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
@CrossOrigin(origins="*",
             allowCredentials="true",
             methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.OPTIONS,RequestMethod.DELETE},
             allowedHeaders={"x-requested-with", "accept", "authorization", "content-type"},
             exposedHeaders={"access-control-allow-headers", "access-control-allow-methods", "access-control-allow-origin", "access-control-max-age", "X-Frame-Options"},
             maxAge = 3600)

//@CrossOrigin(origins="*",maxAge = 3600,methods = {RequestMethod.POST})
@Controller
@ResponseBody
@RequestMapping("/NewFileUpload")
public class NewFileUploadController {
    @RequestMapping("/hello")
    public ModelAndView hello() {
        String message = "Hello World, Spring 3.0!";
        System.out.println(message);
        return new ModelAndView("hello1", "message", message);
    }
    @CrossOrigin(origins="*",
            allowCredentials="true",
            methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.OPTIONS,RequestMethod.DELETE},
            allowedHeaders={"x-requested-with", "accept", "authorization", "content-type"},
            exposedHeaders={"access-control-allow-headers", "access-control-allow-methods", "access-control-allow-origin", "access-control-max-age", "X-Frame-Options"},
            maxAge = 3600)
    //@CrossOrigin(origins="*",maxAge = 3600,methods = {RequestMethod.POST})

    @RequestMapping(path="/upload",method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.OPTIONS,RequestMethod.DELETE})
    @ResponseBody
    public String  upLoad(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException{
        //解析器解析request的上下文
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //先判断request中是否包涵multipart类型的数据，
        String fileName="";
        if(multipartResolver.isMultipart(request)) {
            //再将request中的数据转化成multipart类型的数据
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;

            Iterator<String> iter = multiRequest.getFileNames();
            while(iter.hasNext()) {
                MultipartFile file = multiRequest.getFile((String)iter.next());
                if(file != null) {
                    CommonsMultipartFile cf= (CommonsMultipartFile)file;
                    //DiskFileItem fi = (DiskFileItem)cf.getFileItem();
                    //File inputFile = fi.getStoreLocation();
                    String date1 = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
                    fileName = ((CommonsMultipartFile) file).getFileItem().getName();
                    String[] allname = fileName.split("\\.");
                    fileName=allname[0]+date1+"."+allname[1];

                    String localFilePath = "G:\\uploadfiles\\" + fileName;
                    File desc = new File(localFilePath);
                    cf.transferTo(desc);            //将临时文件转移至备份文件夹，临时文件删除

                    //异步调用WebService将本地文件上传至HDFS
                    String remotePath = "/user/hadoop/uploadFiles/" + fileName;
                    System.out.println("文件加载至本地成功，开始上传至HDFS......");
                    FileOpService fileOpService = new FileOpService();
                    FileOp fileOp = fileOpService.getPort(FileOp.class);
                    try {
                        System.out.println("开始上传至HDFS......" );
                        System.out.println(fileName + " " + remotePath);
                        fileOp.uploadFile(localFilePath,remotePath);
                        System.out.println("上传至HDFS结束......" );

                    } catch (IOException_Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        }
        return fileName;
    }
}
