package com.example.demo.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Data
@Getter
@Setter
public class User {
    Integer userId;
    String username;
    String password;
    String gender;
    String email;
    String status;
    Timestamp createdAt;
    Timestamp updatedAt;
    private byte[]profilePicture;
}
