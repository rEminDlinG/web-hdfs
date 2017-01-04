package com.cgwx.webhdfs.dao;

import com.cgwx.webhdfs.model.FsImageStandard;
import org.springframework.stereotype.Repository;

@Repository
public interface FsImageStandardMapper {
    int insert(FsImageStandard record);

    int insertSelective(FsImageStandard record);
}