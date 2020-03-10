package com.nanofaroque.playingwithdynamodb.playingwithdynamodb.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nanofaroque.playingwithdynamodb.playingwithdynamodb.bussiness_models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeartbeatController {
    @GetMapping("/heartbeat")
    public User greeting() throws JsonProcessingException {
        User usr=new User();
        usr.setId("1");
        return usr;
    }
}
