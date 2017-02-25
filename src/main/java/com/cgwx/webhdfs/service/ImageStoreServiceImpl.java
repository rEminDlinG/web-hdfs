package com.cgwx.webhdfs.service;

import com.cgwx.webhdfs.model.postgresql.ImageStruct;
import com.cgwx.webhdfs.dao.postgresql.HdfsImageStoreMapper;
import com.cgwx.webhdfs.model.postgresql.HdfsImageStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageStoreServiceImpl implements IImageStoreService{

    @Autowired
    private HdfsImageStoreMapper hdfsImageStoreMapper;
    @Override
    public int insert(HdfsImageStore hdfsImageStore)
    {
        int result = hdfsImageStoreMapper.insert(hdfsImageStore);

        System.out.println(result);
        return result;
    }
    @Override
    public HdfsImageStore selectByPrimaryKey(Integer imageId)
    {
        return hdfsImageStoreMapper.selectByPrimaryKey(imageId);
    }
    @Override
    public List<ImageStruct> selectByGeo(String geoJason)
    {
        List<ImageStruct> hdfsImageStoreList = hdfsImageStoreMapper.selectByGeo(geoJason);
        return hdfsImageStoreList;
    }
}
