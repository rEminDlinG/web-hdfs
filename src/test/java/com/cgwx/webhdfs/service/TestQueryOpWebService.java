package com.cgwx.webhdfs.service;

import com.cgwx.webhdfs.WebServiceClient.*;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml",
        "classpath:spring-mybatis.xml" })
public class TestQueryOpWebService {

    private static final Logger LOGGER = Logger
            .getLogger(TestTifSchemaService.class);

    @Test
    public void testSelectByGeo() {
        QueryOpService queryOpService = new QueryOpService();
        QueryOp queryOp = queryOpService.getPort(QueryOp.class);

        try {
            List<ImageStruct> hdfsImageStoreList = queryOp.selectByImgGeo("{\"ImageCatagory\":\"1\",\"ImageStartDate\":\"2016-02-21\",\"ImageEndDate\":\"2016-02-21\",\"ImageGeo\":{\"type\":\"Polygon\",\"coordinates\":[[[116.3676,39.8889],[116.5101,39.8887],[116.3679,39.8268],[116.5102,39.8268]]]}}");
            System.out.println(hdfsImageStoreList.size());

        } catch (IOException_Exception e) {
            e.printStackTrace();
        }
    }
}
