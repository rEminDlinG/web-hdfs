package com.cgwx.webhdfs.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.cgwx.webhdfs.dao.mysql.FsUserAccountMapper;
import com.cgwx.webhdfs.model.mysql.FsUserAccount;

@Service
public class UserAccountServiceImpl implements IUserAccountService{

    @Autowired
    private FsUserAccountMapper fsUserAccountMapper;

    @Override
    public int insertUserAccount(FsUserAccount fsUserAccount) {
        int result = fsUserAccountMapper.insert(fsUserAccount);

        System.out.println(result);
        return result;
    }

    @Override
    public FsUserAccount getUserByUsernameAndPwd(String username,String pwd){
        FsUserAccount fsUserAccount = fsUserAccountMapper.getUserByUsernameAndPwd(username,pwd);
        return fsUserAccount;
    }
}
