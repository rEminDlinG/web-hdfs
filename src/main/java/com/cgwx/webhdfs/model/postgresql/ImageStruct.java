package com.cgwx.webhdfs.model.postgresql;

import java.util.Date;
    public class ImageStruct {


        private int imageId;
        private String imageCategory;
        private String imageName;
        private String imageCategoryExtends2;
        private String imageFilePath;
        private String imageGeo;
        private int imageMinLevel;
        private int imageMaxLevel;
        private Date imageCaptureTime;
        private String image_description;
        public int getImageId() {
            return imageId;
        }

        public void setImageId(int imageId) {
            this.imageId = imageId;
        }
        public String getImageCategory() {
            return imageCategory;
        }

        public void setImageCategory(String imageCategory) {
            this.imageCategory = imageCategory;
        }

        public String getImageName() {
            return imageName;
        }

        public void setImageName(String imageName) {
            this.imageName = imageName;
        }

        public String getImageCategoryExtends2() {
            return imageCategoryExtends2;
        }

        public void setImageCategoryExtends2(String imageCategoryExtends2) {
            this.imageCategoryExtends2 = imageCategoryExtends2;
        }

        public String getImageFilePath() {
            return imageFilePath;
        }

        public void setImageFilePath(String imageFilePath) {
            this.imageFilePath = imageFilePath;
        }

        public String getImageGeo() {
            return imageGeo;
        }

        public void setImageGeo(String imageGeo) {
            this.imageGeo = imageGeo;
        }

        public int getImageMinLevel() {
            return imageMinLevel;
        }

        public void setImageMinLevel(int imageMinLevel) {
            this.imageMinLevel = imageMinLevel;
        }

        public int getImageMaxLevel() {
            return imageMaxLevel;
        }

        public void setImageMaxLevel(int imageMaxLevel) {
            this.imageMaxLevel = imageMaxLevel;
        }

        public Date getImageCaptureTime() {
            return imageCaptureTime;
        }

        public void setImageCaptureTime(Date imageCaptureTime) {
            this.imageCaptureTime = imageCaptureTime;
        }

        public String getImage_description() {
            return image_description;
        }

        public void setImage_description(String image_description) {
            this.image_description = image_description;
        }
    }
