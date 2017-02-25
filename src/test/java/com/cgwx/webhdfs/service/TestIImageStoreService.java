package com.cgwx.webhdfs.service;

import com.cgwx.webhdfs.model.postgresql.ImageStruct;
import com.cgwx.webhdfs.model.postgresql.HdfsImageStore;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml",
        "classpath:spring-mybatis.xml" })
public class TestIImageStoreService {

    private static final Logger LOGGER = Logger.getLogger(TestTifSchemaService.class);

    @Autowired
    private IImageStoreService imageStoreService;
    @Test
    public void testInsert() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date);

        HdfsImageStore hdfsImageStore = new HdfsImageStore();
        hdfsImageStore.setImageId(2);
        hdfsImageStore.setImageUploadTime(date);
        hdfsImageStore.setImageCategory("test");
        hdfsImageStore.setImageName("test");
        hdfsImageStore.setImageCategoryExtends2("test");
        hdfsImageStore.setImageGeo("{\"type\":\"Point\",\"coordinates\":[-48.23456,20.12345]}");
        hdfsImageStore.setImageGeom("{\"type\":\"Point\",\"coordinates\":[-48.23456,20.12345]}");
        hdfsImageStore.setImageFilePath("testfilepath");
        hdfsImageStore.setImageMaxLevel(17);
        hdfsImageStore.setImageMinLevel(6);
        System.out.println(hdfsImageStore.getImageGeo());
        int result = imageStoreService.insert(hdfsImageStore);
        System.out.println(result);

    }
    @Test
    public void testSelect() {
        HdfsImageStore hdfsImageStore = imageStoreService.selectByPrimaryKey(1);
        System.out.println(hdfsImageStore.getImageFilePath());
        System.out.println(hdfsImageStore.getImageGeo());
    }
    @Test
    public void testSelectByGeo() {
        String geoJason = "{\"type\":\"Polygon\",\"coordinates\":[[[116.3676,39.8889],[116.5101,39.8887],[116.3679,39.8268],[116.5102,39.8268]]]}";
        List<ImageStruct> hdfsImageStoreList = imageStoreService.selectByGeo(geoJason);

        System.out.println(hdfsImageStoreList.size());

    }
}
