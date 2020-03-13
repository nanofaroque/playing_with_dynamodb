package com.nanofaroque.playingwithdynamodb.playingwithdynamodb.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nanofaroque.playingwithdynamodb.playingwithdynamodb.bussiness_models.User;
import com.nanofaroque.playingwithdynamodb.playingwithdynamodb.services.IUserService;
import com.nanofaroque.playingwithdynamodb.playingwithdynamodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private IUserService service;

    @RequestMapping(value="/users", method= RequestMethod.POST)
    public @ResponseBody String insertUser() throws JsonProcessingException {
        User user=new User();
        user.setId("1");
        service=new UserService();
        User usr= service.insert(user);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(usr);
        return json;
    }

    @RequestMapping(value="/users", method= RequestMethod.GET)
    public @ResponseBody String readUser() throws JsonProcessingException {
        User user=new User();
        user.setId("1");
        service=new UserService();
        List<User> usr= service.read(user);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(usr);
        return json;
    }
}
