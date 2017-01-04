package com.cgwx.webhdfs.controller;

import com.cgwx.webhdfs.model.FsImageDaily;
import com.cgwx.webhdfs.model.tif_schema;
import com.cgwx.webhdfs.model.FsImageUpload;
import com.cgwx.webhdfs.service.IImageDailyService;
import com.cgwx.webhdfs.service.Itif_schemaService;
import com.cgwx.webhdfs.service.IImageUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
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
    public void SubmitInfos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String uploadFileName = request.getParameter("uploadFileName");
        String uploadDirectory = request.getParameter("uploadDirectory");
        String fileType = request.getParameter("fileType");
        String introduceContent = request.getParameter("introduceContent");
        String typeAttr = request.getParameter("typeAttr");

        System.out.println(uploadFileName);
        System.out.println(uploadDirectory);
        System.out.println(fileType);
        System.out.println(introduceContent);
        System.out.println(typeAttr);

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
        System.out.println(result);
        if (fileType.equals("Daily")) {
            FsImageDaily fsImageDaily = new FsImageDaily();
            fsImageDaily.setImageId(10086);
            fsImageDaily.setArgs1("typeAttr");
            result = imageDailyService.insert(fsImageDaily);
            System.out.println(result);
        }

    }
}