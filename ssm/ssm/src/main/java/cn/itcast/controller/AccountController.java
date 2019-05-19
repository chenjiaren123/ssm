package cn.itcast.controller;

import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerMapping;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/save")
    public String save(Account account) {
        accountService.saveAccount(account);
        return "redirect:/account/findAll";
    }

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<Account> list = accountService.findAll();
        model.addAttribute("list",list );
        return "list";
    }
}
