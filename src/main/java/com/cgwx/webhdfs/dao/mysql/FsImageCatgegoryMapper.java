package com.cgwx.webhdfs.dao.mysql;

import com.cgwx.webhdfs.model.mysql.FsImageCatgegory;
import org.springframework.stereotype.Repository;

@Repository
public interface FsImageCatgegoryMapper {
    int insert(FsImageCatgegory record);

    int insertSelective(FsImageCatgegory record);
}