package com.cgwx.webhdfs.dao.postgresql;

import com.cgwx.webhdfs.model.postgresql.HdfsImageStore;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.cgwx.webhdfs.model.postgresql.ImageStruct;
@Repository
public interface HdfsImageStoreMapper {
    int deleteByPrimaryKey(Integer imageId);

    int insert(HdfsImageStore record);

    int insertSelective(HdfsImageStore record);

    HdfsImageStore selectByPrimaryKey(Integer imageId);

    int updateByPrimaryKeySelective(HdfsImageStore record);

    int updateByPrimaryKey(HdfsImageStore record);

    List<ImageStruct> selectByGeo(String geoJason);
}