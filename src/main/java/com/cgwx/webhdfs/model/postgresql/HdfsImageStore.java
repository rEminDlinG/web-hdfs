package com.cgwx.webhdfs.model.postgresql;

import java.util.Date;

public class HdfsImageStore {
    private Integer imageId;

    private Date imageUploadTime;

    private String imageCategory;

    private String imageName;

    private String imageCategoryExtends2;

    private Object imageGeo;

    private Object imageGeom;

    private String imageFilePath;

    private Integer imageMaxLevel;

    private Integer imageMinLevel;

    private Date imageCaptureTime;

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public Date getImageUploadTime() {
        return imageUploadTime;
    }

    public void setImageUploadTime(Date imageUploadTime) {
        this.imageUploadTime = imageUploadTime;
    }

    public String getImageCategory() {
        return imageCategory;
    }

    public void setImageCategory(String imageCategory) {
        this.imageCategory = imageCategory == null ? null : imageCategory.trim();
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName == null ? null : imageName.trim();
    }

    public String getImageCategoryExtends2() {
        return imageCategoryExtends2;
    }

    public void setImageCategoryExtends2(String imageCategoryExtends2) {
        this.imageCategoryExtends2 = imageCategoryExtends2 == null ? null : imageCategoryExtends2.trim();
    }

    public Object getImageGeo() {
        return imageGeo;
    }

    public void setImageGeo(Object imageGeo) {
        this.imageGeo = imageGeo;
    }

    public Object getImageGeom() {
        return imageGeom;
    }

    public void setImageGeom(Object imageGeom) {
        this.imageGeom = imageGeom;
    }

    public String getImageFilePath() {
        return imageFilePath;
    }

    public void setImageFilePath(String imageFilePath) {
        this.imageFilePath = imageFilePath == null ? null : imageFilePath.trim();
    }

    public Integer getImageMaxLevel() {
        return imageMaxLevel;
    }

    public void setImageMaxLevel(Integer imageMaxLevel) {
        this.imageMaxLevel = imageMaxLevel;
    }

    public Integer getImageMinLevel() {
        return imageMinLevel;
    }

    public void setImageMinLevel(Integer imageMinLevel) {
        this.imageMinLevel = imageMinLevel;
    }

    public Date getImageCaptureTime() {
        return imageCaptureTime;
    }

    public void setImageCaptureTime(Date imageCaptureTime) {
        this.imageCaptureTime = imageCaptureTime;
    }
}