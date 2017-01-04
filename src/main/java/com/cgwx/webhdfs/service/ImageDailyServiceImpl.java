package com.cgwx.webhdfs.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cgwx.webhdfs.dao.FsImageDailyMapper;
import com.cgwx.webhdfs.model.FsImageDaily;
/**
 * Created by hadoop on 2017/1/3.
 */
@Service
public class ImageDailyServiceImpl implements IImageDailyService{

    @Autowired
    private FsImageDailyMapper fsImageDailyMapper;

    @Override
    public int insert(FsImageDaily fsImageDaily) {

        int result = fsImageDailyMapper.insert(fsImageDaily);

        System.out.println(result);
        return result;

    }
}
