package com.cgwx.webhdfs.controller;

import com.cgwx.webhdfs.model.mysql.FsUserAccount;
import com.cgwx.webhdfs.service.IUserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
/**
 * Created by hadoop on 2017/1/1.
 */
@Controller
@RequestMapping("/UserLogin")
public class LoginController {

    @Autowired
    private IUserAccountService userAccountService;

    @RequestMapping(value = "/loginWithUserAccount")
    @ResponseBody
    public FsUserAccount loginWithUserAccount(HttpServletRequest request,
                                                     @RequestParam(value = "username", required = false, defaultValue = "") String username,
                                                     @RequestParam(value = "password", required = false, defaultValue = "") String pwd) {

        System.out.println("fdsafdsasdf");
        FsUserAccount fsUserAccount = userAccountService.getUserByUsernameAndPwd(username,pwd);
        System.out.println(fsUserAccount.getEmail());

        return fsUserAccount;
    }
}
