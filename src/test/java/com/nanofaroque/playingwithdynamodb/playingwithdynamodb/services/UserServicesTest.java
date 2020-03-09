package com.nanofaroque.playingwithdynamodb.playingwithdynamodb.services;

import com.nanofaroque.playingwithdynamodb.playingwithdynamodb.bussiness_models.User;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServicesTest {

    @Test
    public void insert_user_test() throws Exception{
        User mockUser=new User();
        mockUser.setId("1");
        UserService service =Mockito.mock(UserService.class);
        when(service.insert(mockUser)).thenReturn(mockUser);
        User usr = service.insert(mockUser);
        Assertions.assertEquals("1",usr.getId());
    }
}
