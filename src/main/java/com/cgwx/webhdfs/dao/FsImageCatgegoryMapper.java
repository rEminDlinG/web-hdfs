package com.cgwx.webhdfs.dao;

import com.cgwx.webhdfs.model.FsImageCatgegory;
import org.springframework.stereotype.Repository;

@Repository
public interface FsImageCatgegoryMapper {
    int insert(FsImageCatgegory record);

    int insertSelective(FsImageCatgegory record);
}