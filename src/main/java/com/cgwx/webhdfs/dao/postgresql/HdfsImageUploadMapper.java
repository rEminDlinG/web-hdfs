package com.cgwx.webhdfs.dao.postgresql;

import com.cgwx.webhdfs.model.postgresql.HdfsImageUpload;
import org.springframework.stereotype.Repository;

@Repository
public interface HdfsImageUploadMapper {
    int deleteByPrimaryKey(Integer imageId);

    int insert(HdfsImageUpload record);

    int insertSelective(HdfsImageUpload record);

    HdfsImageUpload selectByPrimaryKey(Integer imageId);

    int updateByPrimaryKeySelective(HdfsImageUpload record);

    int updateByPrimaryKey(HdfsImageUpload record);
}