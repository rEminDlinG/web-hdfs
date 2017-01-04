package com.cgwx.webhdfs.dao;

import com.cgwx.webhdfs.model.FsImageDaily;
import org.springframework.stereotype.Repository;

@Repository
public interface FsImageDailyMapper {
    int insert(FsImageDaily record);

    int insertSelective(FsImageDaily record);
}