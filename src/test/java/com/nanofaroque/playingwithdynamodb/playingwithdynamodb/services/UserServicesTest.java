package com.nanofaroque.playingwithdynamodb.playingwithdynamodb.services;

import com.nanofaroque.playingwithdynamodb.playingwithdynamodb.bussiness_models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserServicesTest {
    IUserService userService;
    @BeforeEach
    public void init(){
        userService=new UserService();
    }

    @Test
    public void insert_user_test() throws Exception{
        User mockUser=new User();
        mockUser.setId(2);
        User usr= userService.insert(mockUser);
        Assertions.assertEquals("1",usr.getId());
    }
}
