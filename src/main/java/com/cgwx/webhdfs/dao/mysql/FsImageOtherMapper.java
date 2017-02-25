package com.cgwx.webhdfs.dao.mysql;

import com.cgwx.webhdfs.model.mysql.FsImageOther;
import org.springframework.stereotype.Repository;

@Repository
public interface FsImageOtherMapper {
    int insert(FsImageOther record);

    int insertSelective(FsImageOther record);
}