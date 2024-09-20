package com.example.demo.Mapper;

import com.example.demo.DTO.MoodHistoryDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RecordMapper {

    List<MoodHistoryDTO>getMoodHistory(int type, int userId);
}
