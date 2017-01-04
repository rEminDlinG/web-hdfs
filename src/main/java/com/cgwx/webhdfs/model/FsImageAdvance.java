package com.cgwx.webhdfs.model;

public class FsImageAdvance {
    private Integer imageId;

    private Integer args0;

    private String args1;

    private String args2;

    private String args3;

    private String args4;

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public Integer getArgs0() {
        return args0;
    }

    public void setArgs0(Integer args0) {
        this.args0 = args0;
    }

    public String getArgs1() {
        return args1;
    }

    public void setArgs1(String args1) {
        this.args1 = args1 == null ? null : args1.trim();
    }

    public String getArgs2() {
        return args2;
    }

    public void setArgs2(String args2) {
        this.args2 = args2 == null ? null : args2.trim();
    }

    public String getArgs3() {
        return args3;
    }

    public void setArgs3(String args3) {
        this.args3 = args3 == null ? null : args3.trim();
    }

    public String getArgs4() {
        return args4;
    }

    public void setArgs4(String args4) {
        this.args4 = args4 == null ? null : args4.trim();
    }
}