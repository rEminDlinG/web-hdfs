package com.cgwx.webhdfs.dao.mysql;

import com.cgwx.webhdfs.model.mysql.FsImageAdvance;
import org.springframework.stereotype.Repository;

@Repository
public interface FsImageAdvanceMapper {
    int insert(FsImageAdvance record);

    int insertSelective(FsImageAdvance record);
}