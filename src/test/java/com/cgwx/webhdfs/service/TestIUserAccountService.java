package com.cgwx.webhdfs.service;

import com.cgwx.webhdfs.model.mysql.FsUserAccount;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml",
        "classpath:spring-mybatis.xml" })
public class TestIUserAccountService {

    private static final Logger LOGGER = Logger.getLogger(TestTifSchemaService.class);

    @Autowired
    private IUserAccountService userAccountService;
    @Test
    public void testInsert() {
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=format.format(date);

        FsUserAccount fsUserAccount = new FsUserAccount();

        fsUserAccount.setUserId("10086");
        fsUserAccount.setUsername("wangtianyu");
        fsUserAccount.setTelephone("18643223409");
        fsUserAccount.setEmail("wangtianyu0409@sina.com");
        fsUserAccount.setPassword("123456");


        int result = userAccountService.insertUserAccount(fsUserAccount);
        System.out.println(result);
    }

    @Test
    public void testSelect(){
        FsUserAccount fsUserAccount = new FsUserAccount();

        fsUserAccount = userAccountService.getUserByUsernameAndPwd("wangtianyu","123456");

        System.out.println(fsUserAccount.getUsername());
        System.out.println(fsUserAccount.getEmail());
    }
}
