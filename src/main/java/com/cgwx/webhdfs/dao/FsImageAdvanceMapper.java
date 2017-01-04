package com.cgwx.webhdfs.dao;

import com.cgwx.webhdfs.model.FsImageAdvance;
import org.springframework.stereotype.Repository;

@Repository
public interface FsImageAdvanceMapper {
    int insert(FsImageAdvance record);

    int insertSelective(FsImageAdvance record);
}