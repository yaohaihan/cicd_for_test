package com.example.demo.Service;

import com.example.demo.Entity.Friendship;

public interface FriendshipService {
    public void buildFriendship(int userId1, int userId2);

    public Friendship getFriendship(int friendshipId);

    public Friendship getFriendshipByTwoUserId(int userId1, int userId2);
}
