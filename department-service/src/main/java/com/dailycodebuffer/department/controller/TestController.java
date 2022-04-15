package com.dailycodebuffer.department.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/departments")
public class TestController {
    @GetMapping("/homeDepartment")
    public String department(){
        return "homeDepartment";
    }

}
