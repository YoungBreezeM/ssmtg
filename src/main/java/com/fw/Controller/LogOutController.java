package com.fw.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/logout")
public class LogOutController {

    @GetMapping
    public String logOut(HttpSession session){
        session.invalidate();
        return "login";
    }
}
