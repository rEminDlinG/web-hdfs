package com.cgwx.webhdfs.dao;

import com.cgwx.webhdfs.model.FsUserAccount;
import org.springframework.stereotype.Repository;

@Repository
public interface FsUserAccountMapper {

    int insert(FsUserAccount record);

    int insertSelective(FsUserAccount record);

    FsUserAccount getUserByUsernameAndPwd(String username,String psw);
}