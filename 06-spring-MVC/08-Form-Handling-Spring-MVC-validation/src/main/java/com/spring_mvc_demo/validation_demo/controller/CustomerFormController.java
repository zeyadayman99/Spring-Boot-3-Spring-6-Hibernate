package com.spring_mvc_demo.validation_demo.controller;

import com.spring_mvc_demo.validation_demo.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerFormController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/showForm")
    public String showCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "showCustomerForm";
    }

    @PostMapping("/processForm")
    public String processCustomerForm(@Valid @ModelAttribute("customer") Customer customer
            , BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "showCustomerForm";
        } else {
            return "processCustomerForm";
        }
    }
}
