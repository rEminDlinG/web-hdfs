package com.cgwx.webhdfs.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;
import com.cgwx.webhdfs.model.postgresql.ImageStruct;

import java.util.*;

/**
 * Created by hadoop on 2017/2/22.
 */@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml",
        "classpath:spring-mybatis.xml" })
public class TestJasonOp {

    @Test
    public void JasonOp()
    {
        String jsonString = "{\"ImageCatagory\":\"1\",\"ImageStartDate\":\"2016-02-21\",\"ImageEndDate\":\"2016-02-21\",\"ImageGeo\":{\"type\":\"Polygon\",\"coordinates\":[[[116.3676,39.8889],[116.5101,39.8887],[116.3679,39.8268],[116.5102,39.8268]]]}}";
        JSONObject jsonObject = JSONObject.fromObject(jsonString);  ;
        System.out.println("jsonObject：" + jsonObject);
        int ImageCatagory = jsonObject.getInt("ImageCatagory");
        String ImageStartDate = jsonObject.getString("ImageStartDate");
        String ImageEndDate = jsonObject.getString("ImageEndDate");
        String ImageGeo = jsonObject.getString("ImageGeo");
        System.out.println(ImageCatagory);
        System.out.println(ImageStartDate);
        System.out.println(ImageEndDate);
        System.out.println(ImageGeo);

        Date date = new Date();
        ImageStruct imageStruct1 = new ImageStruct();
        imageStruct1.setImageCategory("长春");
        imageStruct1.setImageName("长春");
        imageStruct1.setImageCategoryExtends2("长春");
        imageStruct1.setImageFilePath("path1");
        imageStruct1.setImageGeo("{\"type\":\"Polygon\",\"coordinates\":[[[116.3676,39.8889],[116.5101,39.8887],[116.3679,39.8268],[116.5102,39.8268]]]}}");
        imageStruct1.setImageMinLevel(6);
        imageStruct1.setImageMaxLevel(17);
        imageStruct1.setImageCaptureTime(date);
        imageStruct1.setImage_description("北京");
        ImageStruct imageStruct2 = new ImageStruct();
        imageStruct2.setImageCategory("北京");
        imageStruct2.setImageName("北京");
        imageStruct2.setImageCategoryExtends2("北京");
        imageStruct2.setImageFilePath("path1");
        imageStruct2.setImageGeo("{\"type\":\"Polygon\",\"coordinates\":[[[116.3676,39.8889],[116.5101,39.8887],[116.3679,39.8268],[116.5102,39.8268]]]}}");
        imageStruct2.setImageMinLevel(6);
        imageStruct2.setImageMaxLevel(17);
        imageStruct2.setImageCaptureTime(date);
        imageStruct2.setImage_description("北京");
        List<ImageStruct> imageStructList = new ArrayList<ImageStruct>();
        imageStructList.add(imageStruct1);
        imageStructList.add(imageStruct2);
        JSONArray jsonObject1 = new JSONArray();
        for (ImageStruct a : imageStructList)
        {
            JSONObject jo = new JSONObject();
            jo.put("image_category",a.getImageCategory());
            jo.put("image_name",a.getImageName());
            jo.put("image_catgegory_extend2",a.getImageCategoryExtends2());
            jo.put("image_file_path",a.getImageFilePath());
            jo.put("image_geo",a.getImageGeo());
            jo.put("image_min_level",a.getImageMinLevel());
            jo.put("image_capture_time",a.getImageCaptureTime());
            jo.put("image_max_level",a.getImageMaxLevel());
            jo.put("image_description",a.getImage_description());
            jsonObject1.add(jo);
        }

        System.out.println(jsonObject1.toString());
        System.out.println(jsonObject1);


    }

}
