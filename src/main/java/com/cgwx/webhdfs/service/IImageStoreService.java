package com.cgwx.webhdfs.service;


import com.cgwx.webhdfs.model.postgresql.ImageStruct;
import com.cgwx.webhdfs.model.postgresql.HdfsImageStore;

import java.util.List;


public interface IImageStoreService {
    int insert(HdfsImageStore hdfsImageStore);
    HdfsImageStore selectByPrimaryKey(Integer imageId);
    List<ImageStruct> selectByGeo(String geoJason);
}
