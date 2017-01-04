package com.cgwx.webhdfs.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.cgwx.webhdfs.model.tif_schema;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

/**
 * 创建时间：2015-1-27 下午10:45:38
 *
 * @author andy
 * @version 2.2
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml",
        "classpath:spring-mybatis.xml" })
public class TestTifSchemaService {

    private static final Logger LOGGER = Logger
            .getLogger(TestTifSchemaService.class);

    @Autowired
    private Itif_schemaService tifSchemaService;



    @Test
    public void testInsert() {
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=format.format(date);

        tif_schema tifSchema = new tif_schema();
        tifSchema.setId("5");
        tifSchema.setPath("fasfsad");
        tifSchema.setType("fasfsafds");
        tifSchema.setLevelMin(0);
        tifSchema.setLevelMax(17);
        tifSchema.setDescription("fsadfsafsfsafasfasfdsafsadfsafsa");
        tifSchema.setFlag(false);
        tifSchema.setDate(date);
        int result = tifSchemaService.insert(tifSchema);
        System.out.println(result);
    }

}
