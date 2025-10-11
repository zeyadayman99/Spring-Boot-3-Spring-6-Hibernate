package com.springpractice.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormInputController {

    //Controller Method to Show initial Form
    @RequestMapping("/showForm")
    public String handleFormInput() {
        return "userInputForm";
    }

    @RequestMapping("/processForm")
    public String processFormInput(HttpServletRequest request, Model model) {
        String username = request.getParameter("userName");
        username = username.toUpperCase();
        model.addAttribute("userName", username);
        return "process-user-info";
    }
}
