package com.cgwx.webhdfs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cgwx.webhdfs.dao.mysql.FsImageUploadMapper;
import com.cgwx.webhdfs.model.mysql.FsImageUpload;
import com.cgwx.webhdfs.model.postgresql.HdfsImageUpload;
import com.cgwx.webhdfs.dao.postgresql.HdfsImageUploadMapper;
@Service
public class ImageUploadServiceImpl implements IImageUploadService {
    @Autowired
    private FsImageUploadMapper fsImageUploadMapper;
    @Autowired
    private HdfsImageUploadMapper hdfsImageUploadMapper;
    @Override
    public int insert(FsImageUpload fsImageUpload) {

        int result = fsImageUploadMapper.insert(fsImageUpload);

        System.out.println(result);
        return result;
    }
    @Override
    public int insert(HdfsImageUpload hdfsImageUpload) {

        int result = hdfsImageUploadMapper.insert(hdfsImageUpload);

        //System.out.println(result);
        return result;
    }
}