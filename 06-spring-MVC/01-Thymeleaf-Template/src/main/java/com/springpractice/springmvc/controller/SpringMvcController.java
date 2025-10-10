package com.springpractice.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mvc")
public class SpringMvcController {

    @GetMapping("/date")
    public String getDate(Model model) {
        model.addAttribute("date", java.time.LocalDate.now());

        //now spring will automatically read the thymeleaf dependency and will auto-configure
        //to read the .html file at /src/resources/templates/helloworld.html
        return "helloworld";
    }
}
