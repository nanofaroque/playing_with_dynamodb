package com.nanofaroque.playingwithdynamodb.playingwithdynamodb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeartbeatController {
    @GetMapping("/heartbeat")
    public String greeting() {
        return "hello from heartbeat";
    }
}
