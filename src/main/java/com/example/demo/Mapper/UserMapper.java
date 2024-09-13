package com.example.demo.Mapper;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import com.example.demo.Utils.Result;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Mapper
public interface UserMapper{
    @Insert("INSERT INTO tb_user(Username,Password,gender,email,status) VALUES (#{username},#{password},#{gender},#{email},#{status})")
    void addUser(User user);

    @Select("SELECT * FROM tb_user WHERE userId = #{userId}")
    User getUserById(int userId);
}
