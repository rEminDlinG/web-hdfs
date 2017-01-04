package com.cgwx.webhdfs.dao;

import com.cgwx.webhdfs.model.tif_schema;
import org.springframework.stereotype.Repository;

@Repository
public interface tif_schemaMapper {
    int deleteByPrimaryKey(String id);

    int insert(tif_schema record);

    int insertSelective(tif_schema record);

    tif_schema selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(tif_schema record);

    int updateByPrimaryKeyWithBLOBs(tif_schema record);

    int updateByPrimaryKey(tif_schema record);
}