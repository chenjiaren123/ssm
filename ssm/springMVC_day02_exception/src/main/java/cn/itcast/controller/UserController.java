package cn.itcast.controller;

import cn.itcast.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/testException")
    public String testException() throws SysException {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("出现错误了...");
        }
        return "success";
    }
}
