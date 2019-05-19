package cn.itcast.controller;

import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/testString")
    public String testString(Model model) {
        User user = new User();
        user.setUsername("托尼老师");
        user.setPassword("123");
        user.setAge(18);
        model.addAttribute("user",user );
        return "success";
    }

    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setUsername("托尼老师");
        user.setPassword("123");
        user.setAge(18);
        request.setAttribute("user",user );
        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response );
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        user.setUsername("托尼老师");
        user.setPassword("123");
        user.setAge(18);
        modelAndView.addObject(user);
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect() {
//        return "redirect:/index.jsp";
        return "forward:/WEB-INF/pages/success.jsp";
    }

    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user) {
        user.setUsername("托尼老师");
        user.setPassword("123");
        user.setAge(18);
        return user;
    }
}
