package com.example.demo.Entity;

import java.sql.Blob;
import java.sql.Timestamp;

public class Photo {
    private Integer photoId;    // 照片 ID
    private Integer recordId;   // 外键，关联到 Record
    private Blob photoData;     // 存储照片的 BLOB 数据
    private Timestamp createdAt; // 创建时间

    // Getter 和 Setter 方法

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Blob getPhotoData() {
        return photoData;
    }

    public void setPhotoData(Blob photoData) {
        this.photoData = photoData;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}