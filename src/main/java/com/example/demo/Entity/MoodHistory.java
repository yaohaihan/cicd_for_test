package com.example.demo.Entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class MoodHistory {
    private Integer moodHistoryId;
    private Integer userId; // 外键
    private Integer mood;
    private Timestamp createdAt;

}
