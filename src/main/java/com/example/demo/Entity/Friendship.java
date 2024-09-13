package com.example.demo.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Friendship {
    private Integer friendshipId;
    private Integer userId1;
    private Integer userId2;
    private Timestamp createdAt;
}
