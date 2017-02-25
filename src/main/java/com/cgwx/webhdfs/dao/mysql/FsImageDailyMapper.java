package com.cgwx.webhdfs.dao.mysql;

import com.cgwx.webhdfs.model.mysql.FsImageDaily;
import org.springframework.stereotype.Repository;

@Repository
public interface FsImageDailyMapper {
    int insert(FsImageDaily record);

    int insertSelective(FsImageDaily record);
}