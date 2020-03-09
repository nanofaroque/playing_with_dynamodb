package com.nanofaroque.playingwithdynamodb.playingwithdynamodb.services;

import com.nanofaroque.playingwithdynamodb.playingwithdynamodb.bussiness_models.User;

public interface IUserService {
    User insert(User user);
}
