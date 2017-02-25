package com.cgwx.webhdfs.dao.mysql;

import com.cgwx.webhdfs.model.mysql.FsImageStandard;
import org.springframework.stereotype.Repository;

@Repository
public interface FsImageStandardMapper {
    int insert(FsImageStandard record);

    int insertSelective(FsImageStandard record);
}