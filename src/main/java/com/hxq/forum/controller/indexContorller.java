package com.hxq.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class indexContorller {

    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }
}
