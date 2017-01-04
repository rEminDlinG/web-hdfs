package com.cgwx.webhdfs.dao;

import com.cgwx.webhdfs.model.FsImageOther;
import org.springframework.stereotype.Repository;

@Repository
public interface FsImageOtherMapper {
    int insert(FsImageOther record);

    int insertSelective(FsImageOther record);
}