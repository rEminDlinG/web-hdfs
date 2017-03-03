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
            List<ImageStruct> hdfsImageStoreList = queryOp.selectByImgGeo("{\"ImageCatagory\":\"1\",\"ImageStartDate\":\"2016-02-21\",\"ImageEndDate\":\"2016-02-21\",\"ImageGeo\":{\"type\":\"Polygon\",\"coordinates\":[[[117.4219,40.21],[117.334,40.1221],[117.2461,40.0781],[116.8066,39.9902],[116.8945,39.8145],[116.8945,39.6826],[116.8066,39.5947],[116.543,39.5947],[116.3672,39.4629],[116.1914,39.5947],[115.752,39.5068],[115.4883,39.6387],[115.4004,39.9463],[115.9277,40.2539],[115.752,40.5615],[116.1035,40.6055],[116.1914,40.7813],[116.4551,40.7813],[116.3672,40.9131],[116.6309,41.0449],[116.9824,40.6934],[117.4219,40.6494],[117.2461,40.5176],[117.4219,40.21]]]}}");
            System.out.println(hdfsImageStoreList.size());

        } catch (IOException_Exception e) {
            e.printStackTrace();
        }
    }
}
