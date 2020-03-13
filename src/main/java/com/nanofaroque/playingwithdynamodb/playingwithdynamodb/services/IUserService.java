package com.nanofaroque.playingwithdynamodb.playingwithdynamodb.services;

import com.nanofaroque.playingwithdynamodb.playingwithdynamodb.bussiness_models.User;

import java.util.List;

public interface IUserService {
    User insert(User user);
    List<User> read(User user);
}
