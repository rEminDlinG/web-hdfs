package com.cgwx.webhdfs.model.mysql;

import java.util.Date;

public class FsImageUpload {
    private Integer imageId;

    private String uploadUserId;

    private String uploadUserName;

    private Date imageUploadTime;

    private String imageCategory;

    private String imagePath;

    private String cutState;

    private Integer levelMin;

    private Integer levelMax;

    private Date imageCaptureTime;

    private String imageDescription;

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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath == null ? null : imagePath.trim();
    }

    public String getCutState() {
        return cutState;
    }

    public void setCutState(String cutState) {
        this.cutState = cutState == null ? null : cutState.trim();
    }

    public Integer getLevelMin() {
        return levelMin;
    }

    public void setLevelMin(Integer levelMin) {
        this.levelMin = levelMin;
    }

    public Integer getLevelMax() {
        return levelMax;
    }

    public void setLevelMax(Integer levelMax) {
        this.levelMax = levelMax;
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
}