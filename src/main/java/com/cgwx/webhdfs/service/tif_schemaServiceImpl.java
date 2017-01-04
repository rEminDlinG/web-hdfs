package com.cgwx.webhdfs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cgwx.webhdfs.dao.tif_schemaMapper;
import com.cgwx.webhdfs.model.tif_schema;
/**
 * Created by hadoop on 2016/12/30.
 */
@Service
public class tif_schemaServiceImpl implements Itif_schemaService{

    @Autowired
    private tif_schemaMapper tifSchemaMapper;

    @Override
    public int insert(tif_schema tifSchema) {

        int result = tifSchemaMapper.insert(tifSchema);

        System.out.println(result);
        return result;
    }
}
