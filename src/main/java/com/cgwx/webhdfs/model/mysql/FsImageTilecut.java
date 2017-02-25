package com.cgwx.webhdfs.model.mysql;

public class FsImageTilecut {
    private Integer imageId;

    private Integer rowMin;

    private Integer rowMax;

    private Integer colMin;

    private Integer colMax;

    private String filePath;

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public Integer getRowMin() {
        return rowMin;
    }

    public void setRowMin(Integer rowMin) {
        this.rowMin = rowMin;
    }

    public Integer getRowMax() {
        return rowMax;
    }

    public void setRowMax(Integer rowMax) {
        this.rowMax = rowMax;
    }

    public Integer getColMin() {
        return colMin;
    }

    public void setColMin(Integer colMin) {
        this.colMin = colMin;
    }

    public Integer getColMax() {
        return colMax;
    }

    public void setColMax(Integer colMax) {
        this.colMax = colMax;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }
}