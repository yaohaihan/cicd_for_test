package com.example.demo.Controller;


import com.example.demo.DTO.MoodHistoryDTO;
import com.example.demo.Service.RecordService;
import com.example.demo.Utils.Result;
import com.example.demo.Utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Record")
public class RecordController {
    @Autowired
    RecordService recordService;


    @GetMapping("/History")
    public Result getMoodHistory(@RequestParam int queryPeriod){
//        1：当天；2：本周；3：本月。
        Map<String, Object> claims = ThreadLocalUtil.get();
        int userId = (int)claims.get("id");
        List<MoodHistoryDTO> result = recordService.getMoodHistory(queryPeriod,userId);
        return Result.success(result);
    }


    @GetMapping("/Intensity/")
    public Result getIntensity(@RequestParam int queryPeriod){
//        1: 本周；2：本月
        Map<String, Object> claims = ThreadLocalUtil.get();
        int userId = (int)claims.get("id");
        return Result.success(recordService.getIntensity(queryPeriod,userId));
    }




}
