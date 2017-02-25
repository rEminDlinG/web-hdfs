package com.cgwx.webhdfs.model.postgresql;

import java.util.Date;

public class HdfsImageUpload {
    private Integer imageId;

    private String uploadUserId;

    private String uploadUserName;

    private Date imageUploadTime;

    private String imageCategory;

    private String imageCategoryExtends1;

    private String imageCategoryExtends2;

    private String imageFilePath;

    private Boolean cutState;

    private Date imageCaptureTime;

    private String imageDescription;

    private Long imageSize;

    private String imageName;

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getUploadUserId() {
        return uploadUserId;
    }

    public void setUploadUserId(String uploadUserId) {
        this.uploadUserId = uploadUserId == null ? null : uploadUserId.trim();
    }

    public String getUploadUserName() {
        return uploadUserName;
    }

    public void setUploadUserName(String uploadUserName) {
        this.uploadUserName = uploadUserName == null ? null : uploadUserName.trim();
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

    public String getImageCategoryExtends1() {
        return imageCategoryExtends1;
    }

    public void setImageCategoryExtends1(String imageCategoryExtends1) {
        this.imageCategoryExtends1 = imageCategoryExtends1 == null ? null : imageCategoryExtends1.trim();
    }

    public String getImageCategoryExtends2() {
        return imageCategoryExtends2;
    }

    public void setImageCategoryExtends2(String imageCategoryExtends2) {
        this.imageCategoryExtends2 = imageCategoryExtends2 == null ? null : imageCategoryExtends2.trim();
    }

    public String getImageFilePath() {
        return imageFilePath;
    }

    public void setImageFilePath(String imageFilePath) {
        this.imageFilePath = imageFilePath == null ? null : imageFilePath.trim();
    }

    public Boolean getCutState() {
        return cutState;
    }

    public void setCutState(Boolean cutState) {
        this.cutState = cutState;
    }

    public Date getImageCaptureTime() {
        return imageCaptureTime;
    }

    public void setImageCaptureTime(Date imageCaptureTime) {
        this.imageCaptureTime = imageCaptureTime;
    }

    public String getImageDescription() {
        return imageDescription;
    }

    public void setImageDescription(String imageDescription) {
        this.imageDescription = imageDescription == null ? null : imageDescription.trim();
    }

    public Long getImageSize() {
        return imageSize;
    }

    public void setImageSize(Long imageSize) {
        this.imageSize = imageSize;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName == null ? null : imageName.trim();
    }
}