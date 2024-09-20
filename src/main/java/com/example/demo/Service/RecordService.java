package com.example.demo.Service;

import com.example.demo.DTO.MoodHistoryDTO;

import java.util.List;

public interface RecordService {

    public List<MoodHistoryDTO> getMoodHistory(int type,int userId);
}
