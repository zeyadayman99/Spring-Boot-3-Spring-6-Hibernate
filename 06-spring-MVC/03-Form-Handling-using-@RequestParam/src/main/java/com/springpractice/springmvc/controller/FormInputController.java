package com.springpractice.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormInputController {

    //Controller Method to Show initial Form
    @GetMapping("/showForm")
    public String handleFormInput() {
        return "userInputForm";
    }

    @PostMapping("/processForm")
    public String processFormInput(@RequestParam("userName") String userName, Model model) {
        userName = userName.toLowerCase();
        model.addAttribute("userName", userName);
        return "process-user-info";
    }
}
