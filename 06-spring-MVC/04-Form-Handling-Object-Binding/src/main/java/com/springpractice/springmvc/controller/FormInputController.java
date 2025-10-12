package com.springpractice.springmvc.controller;

import com.springpractice.springmvc.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormInputController {

    //Controller Method to Show initial Form
    @GetMapping("/showForm")
    public String handleFormInput(Model model) {
        model.addAttribute("student", new Student());
        return "userInputForm";
    }

    @PostMapping("/processForm")
    public String processFormInput(@ModelAttribute("student") Student student, Model model) {
        return "process-user-info";
    }
}
