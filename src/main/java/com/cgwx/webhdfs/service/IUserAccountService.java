package com.cgwx.webhdfs.service;


import com.cgwx.webhdfs.model.mysql.FsUserAccount;
/**
 * Created by hadoop on 2017/1/1.
 */
public interface IUserAccountService {

    int insertUserAccount(FsUserAccount fsUserAccount);

    FsUserAccount getUserByUsernameAndPwd(String username,String pwd);

}
