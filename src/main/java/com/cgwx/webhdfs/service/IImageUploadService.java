package com.cgwx.webhdfs.service;

import com.cgwx.webhdfs.model.mysql.FsImageUpload;
import com.cgwx.webhdfs.model.postgresql.HdfsImageUpload;

public interface IImageUploadService {
    int insert(FsImageUpload fsImageUpload);
    int insert(HdfsImageUpload hdfsImageUpload);
}
