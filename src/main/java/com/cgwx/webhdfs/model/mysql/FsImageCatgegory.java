package com.cgwx.webhdfs.model.mysql;

public class FsImageCatgegory {
    private String imageCategoryId;

    private String parImageCategoryId;

    private String name;

    public String getImageCategoryId() {
        return imageCategoryId;
    }

    public void setImageCategoryId(String imageCategoryId) {
        this.imageCategoryId = imageCategoryId == null ? null : imageCategoryId.trim();
    }

    public String getParImageCategoryId() {
        return parImageCategoryId;
    }

    public void setParImageCategoryId(String parImageCategoryId) {
        this.parImageCategoryId = parImageCategoryId == null ? null : parImageCategoryId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}