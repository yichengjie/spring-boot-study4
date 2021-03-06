package com.yicj.study.controller;

import com.yicj.study.annnotation.Function;
import com.yicj.study.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.Filter;
import java.util.List;

@Controller
public class HelloController {


    @Autowired(required = false)
    public void setConfigurers(List<Filter> filters){
        for (Filter filter: filters){
            System.out.println("========> " + filter.getClass().getName());
        }
    }

    @ResponseBody
    @RequestMapping("/sayhello.html")
    public String say(String name){
        return "hello " + name ;
    }


    @RequestMapping("/adduser.html")
    @ResponseBody
    //@Function("user.add")
    public String addUser(String name){
        return "add user" ;
    }


    @GetMapping("/{userId}/get.html")
    public String getUser(@PathVariable Long userId, Model model){
        User user = new User(userId, "zhangsan") ;
        model.addAttribute("user",user) ;
        return "userInfo.btl" ;
    }
}
