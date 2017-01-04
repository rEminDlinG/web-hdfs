package com.cgwx.webhdfs.dao;

import com.cgwx.webhdfs.model.FsImageTilecut;
import org.springframework.stereotype.Repository;

@Repository
public interface FsImageTilecutMapper {
    int insert(FsImageTilecut record);

    int insertSelective(FsImageTilecut record);
}