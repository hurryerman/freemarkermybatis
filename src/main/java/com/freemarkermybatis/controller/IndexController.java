package com.freemarkermybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String TestIndexController(ModelMap modelMap)
    {
        modelMap.addAttribute("IndexText", "I am Index");
        return "Index";
    }
}
