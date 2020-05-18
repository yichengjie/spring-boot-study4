package com.yicj.study.controller;

import com.yicj.study.annnotation.Function;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/sayhello.html")
    public String say(String name){
        return "hello " + name ;
    }


    @RequestMapping("/adduser.html")
    @ResponseBody
    @Function("user.add")
    public String addUser(String name){
        return "add user" ;
    }
}
