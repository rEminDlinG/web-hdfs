package com.cgwx.webhdfs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cgwx.webhdfs.dao.FsImageUploadMapper;
import com.cgwx.webhdfs.model.FsImageUpload;

@Service
public class ImageUploadServiceImpl implements IImageUploadService {
    @Autowired
    private FsImageUploadMapper fsImageUploadMapper;

    @Override
    public int insert(FsImageUpload fsImageUpload) {

        int result = fsImageUploadMapper.insert(fsImageUpload);

        System.out.println(result);
        return result;

    }
}