package com.cgwx.webhdfs.service;

import com.cgwx.webhdfs.model.postgresql.HdfsImageUpload;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml",
        "classpath:spring-mybatis.xml" })
public class TestIImageUploadService {

    private static final Logger LOGGER = Logger.getLogger(TestTifSchemaService.class);

    @Autowired
    private IImageUploadService imageUploadService;
    @Test
    public void testInsert() {
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=format.format(date);

        HdfsImageUpload hdfsImageUpload= new HdfsImageUpload();

        hdfsImageUpload.setUploadUserId("10086");
        hdfsImageUpload.setUploadUserName("wangtianyu");
        hdfsImageUpload.setImageUploadTime(date);
        hdfsImageUpload.setImageCategory("2");
        hdfsImageUpload.setImageCategoryExtends1("other");
        hdfsImageUpload.setImageCategoryExtends2("other");
        hdfsImageUpload.setImageFilePath("testpath");
        hdfsImageUpload.setCutState(true);
        hdfsImageUpload.setImageCaptureTime(date);
        hdfsImageUpload.setImageDescription("just an image");
        hdfsImageUpload.setImageSize(65536L);
        hdfsImageUpload.setImageName("testfile.tiff");

        int result = imageUploadService.insert(hdfsImageUpload);
        //System.out.println(result);
    }


}
