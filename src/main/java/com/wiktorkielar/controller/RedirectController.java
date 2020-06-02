package com.wiktorkielar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {

    @RequestMapping("/")
    public String redirect(){
        return "redirect:/contract/list/active";
    }

}
