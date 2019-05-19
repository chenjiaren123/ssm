package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/user")
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello");
        return "success";
    }

    @RequestMapping(path = "/testRequestMapping",params = {"username=heihei"})
    public String testRequestMapping(){
        System.out.println("testRequestMapping");
        return "success";
    }
}
