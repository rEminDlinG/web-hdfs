package com.cgwx.webhdfs.service;

import com.cgwx.webhdfs.model.mysql.FsImageDaily;
/**
 * Created by hadoop on 2017/1/3.
 */
public interface IImageDailyService {
    int insert(FsImageDaily fsImageDaily);
}
