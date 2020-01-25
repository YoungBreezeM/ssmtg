package com.fw.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/msg")
public class MsgController {

    @GetMapping(value = "/noPermission")
    public String getNoPermissionPage(){
        return "msg/noPermission";
    }
}
