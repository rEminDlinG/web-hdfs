package com.cgwx.webhdfs.dao.mysql;

import com.cgwx.webhdfs.model.mysql.FsImageTilecut;
import org.springframework.stereotype.Repository;

@Repository
public interface FsImageTilecutMapper {
    int insert(FsImageTilecut record);

    int insertSelective(FsImageTilecut record);
}