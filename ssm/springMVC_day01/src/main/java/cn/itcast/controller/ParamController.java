package cn.itcast.controller;

import cn.itcast.domain.Account;
import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/param")
public class ParamController {
    @RequestMapping("/testParam")
    public String testParam(String username,String password){
        System.out.println(username);
        System.out.println(password);
        return "success";
    }

    @RequestMapping("/saveAccount")
    public String saveAccount(Account account){
        System.out.println(account);
        return "success";
    }

    @RequestMapping("/saveUser")
    public String saveUser(User user){
        System.out.println(user);
        return "success";
    }
}
