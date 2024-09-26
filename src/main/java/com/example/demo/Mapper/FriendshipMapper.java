package com.example.demo.Mapper;

import com.example.demo.Entity.Friendship;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FriendshipMapper {
    @Insert("INSERT INTO friendship(userId1,userId2) VALUES (#{userId1},#{userId2})")
    public void BuildRelationship(int userId1, int userId2);

    @Select("SELECT * from friendship where friendshipId = #{friendshipId}")
    public Friendship GetFriendship(int friendshipId);

    @Select("SELECT * FROM friendship where (userId1 = #{userId1} AND userId2 = #{userId2}) OR (userId1 = #{userId2} AND userId2 = #{userId1})")
    public Friendship GetFriendshipByTwoUserId(int userId1, int userId2);
}
