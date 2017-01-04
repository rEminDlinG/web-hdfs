package com.cgwx.webhdfs.dao;

import com.cgwx.webhdfs.model.FsImageUpload;
import org.springframework.stereotype.Repository;

@Repository
public interface FsImageUploadMapper {
    int deleteByPrimaryKey(Integer imageId);

    int insert(FsImageUpload record);

    int insertSelective(FsImageUpload record);

    FsImageUpload selectByPrimaryKey(Integer imageId);

    int updateByPrimaryKeySelective(FsImageUpload record);

    int updateByPrimaryKeyWithBLOBs(FsImageUpload record);

    int updateByPrimaryKey(FsImageUpload record);
}