package com.cgwx.webhdfs.model;

public class FsUserAccount {
    private String userId;

    private String username;

    private String telephone;

    private String email;

    private String password;

    private String wechatAccount;

    private String qqAccount;

    private String weiboAccount;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getWechatAccount() {
        return wechatAccount;
    }

    public void setWechatAccount(String wechatAccount) {
        this.wechatAccount = wechatAccount == null ? null : wechatAccount.trim();
    }

    public String getQqAccount() {
        return qqAccount;
    }

    public void setQqAccount(String qqAccount) {
        this.qqAccount = qqAccount == null ? null : qqAccount.trim();
    }

    public String getWeiboAccount() {
        return weiboAccount;
    }

    public void setWeiboAccount(String weiboAccount) {
        this.weiboAccount = weiboAccount == null ? null : weiboAccount.trim();
    }
}