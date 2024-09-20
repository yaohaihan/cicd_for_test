package com.example.demo.Impl;

import com.example.demo.DTO.MoodHistoryDTO;
import com.example.demo.Mapper.RecordMapper;
import com.example.demo.Service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService{

    @Autowired
    RecordMapper recordMapper;


    @Override
    public List<MoodHistoryDTO> getMoodHistory(int type, int userId) {
        return recordMapper.getMoodHistory(type, userId);
    }
}
