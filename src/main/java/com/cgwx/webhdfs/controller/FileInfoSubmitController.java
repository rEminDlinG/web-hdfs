package com.cgwx.webhdfs.controller;

import com.cgwx.webhdfs.dto.Response;
import com.cgwx.webhdfs.model.mysql.FsImageDaily;
import com.cgwx.webhdfs.model.mysql.FsImageUpload;
import com.cgwx.webhdfs.model.postgresql.HdfsImageUpload;
import com.cgwx.webhdfs.service.IImageDailyService;
import com.cgwx.webhdfs.service.IImageUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
@Controller
@RequestMapping("/FileInfoSubmit")
public class FileInfoSubmitController {

    @Autowired
    private IImageUploadService imageUploadService;
    @Autowired
    private IImageDailyService imageDailyService;
    @ResponseBody
    @RequestMapping("/SubmitAction")
    public Response SubmitInfos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Response opResult = new Response();

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String uploadFileName = request.getParameter("uploadFileName");
        String uploadDirectory = request.getParameter("uploadDirectory");
        String fileType = request.getParameter("fileType");
        String introduceContent = request.getParameter("introduceContent");
        String typeAttr = request.getParameter("typeAttr");

        String uploadFilePath = "/user/hadoop/uploadFiles/" + uploadFileName;

        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=format.format(date);

        FsImageUpload fsImageUpload = new FsImageUpload();
        //fsImageUpload.setImageId(5);
        fsImageUpload.setUploadUserId("10086");
        fsImageUpload.setUploadUserName("Jerry");
        fsImageUpload.setImageUploadTime(date);
        fsImageUpload.setImageCategory(fileType);
        fsImageUpload.setImagePath(uploadFilePath);
        fsImageUpload.setCutState("0");
        fsImageUpload.setLevelMin(0);
        fsImageUpload.setLevelMax(17);
        fsImageUpload.setImageCaptureTime(date);
        fsImageUpload.setImageDescription(introduceContent);

        int result = imageUploadService.insert(fsImageUpload);
//        System.out.println(result);

        if (fileType.equals("Daily")) {
            FsImageDaily fsImageDaily = new FsImageDaily();
            fsImageDaily.setImageId(10086);
            fsImageDaily.setArgs1("typeAttr");
            result = imageDailyService.insert(fsImageDaily);


        }
        opResult.setResult("success");
        return opResult;
    }
    @ResponseBody
    @RequestMapping("/SubmitGroup")
    public Response SubmitGroup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Response opResult = new Response();

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String count=request.getParameter("count");
        int size=Integer.parseInt(count);
        System.out.println(size);

        for(int i=0;i<size;i++) {
            String uploadFileName = request.getParameter("uploadFileName"+i);
            String uploadDirectory = request.getParameter("uploadDirectory"+i);
            String fileType = request.getParameter("fileType"+i);
            String introduceContent = request.getParameter("introduceContent"+i);
            String typeAttr = request.getParameter("typeAttr"+i);

            System.out.println(uploadFileName);
            System.out.println(uploadDirectory);
            System.out.println(fileType);
            System.out.println(introduceContent);
            System.out.println(typeAttr);

            String uploadFilePath = "/user/hadoop/uploadFiles/" + uploadFileName;

            try {
                Date date=new Date();
                DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String time=format.format(date);
                String date1 = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
                HdfsImageUpload hdfsImageUpload= new HdfsImageUpload();
                hdfsImageUpload.setImageId(13);
                hdfsImageUpload.setUploadUserId("Jerry");
                hdfsImageUpload.setUploadUserName("Jerry");
                hdfsImageUpload.setImageUploadTime(date);
                hdfsImageUpload.setImageCategory("1");
                hdfsImageUpload.setImageCategoryExtends1("Jerry");
                hdfsImageUpload.setImageCategoryExtends2("Jerry");
                hdfsImageUpload.setImageFilePath(uploadFilePath);
                hdfsImageUpload.setCutState(false);
                hdfsImageUpload.setImageCaptureTime(null);
                hdfsImageUpload.setImageDescription(introduceContent);
                hdfsImageUpload.setImageSize(0L);
                hdfsImageUpload.setImageName(uploadFileName);

                int result = imageUploadService.insert(hdfsImageUpload);

                System.out.println("Table created successfully");
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
        }
        opResult.setResult("success");
        return opResult;
    }
}