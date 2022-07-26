package com.ats.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users/health")
public class HealthCheckController {

    @GetMapping("getAppHealth")
    public String checkApplicationHealth(){
        return "Congratulations!! \n Woohoo !! RestAPIsDockerDemo application is up and running";
    }
}
