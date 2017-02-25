package com.cgwx.webhdfs.controller;

import com.cgwx.webhdfs.WebServiceClient.*;
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
import java.util.List;

import com.cgwx.webhdfs.dto.Response;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@Controller
@RequestMapping("/FileInfoSubmit")
public class FileInfoSubmitController  {

    @Autowired
    private IImageUploadService imageUploadService;
    @Autowired
    private IImageDailyService imageDailyService;

    @ResponseBody
    @RequestMapping("/SubmitAction")
    public Response SubmitInfos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Response opResult = new Response();
        //temp
        QueryOpService queryOpService = new QueryOpService();
        QueryOp queryOp = queryOpService.getPort(QueryOp.class);

        try {
            List<ImageStruct> hdfsImageStoreList = queryOp.selectByImgGeo("{\"ImageCatagory\":\"1\",\"ImageStartDate\":\"2016-02-21\",\"ImageEndDate\":\"2016-02-21\",\"ImageGeo\":{\"type\":\"Polygon\",\"coordinates\":[[[116.3676,39.8889],[116.5101,39.8887],[116.3679,39.8268],[116.5102,39.8268]]]}}");
            System.out.println(hdfsImageStoreList.size());

        } catch (IOException_Exception e) {
            e.printStackTrace();
        }
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
        opResult.setResult("success");
        return opResult;
    }
}