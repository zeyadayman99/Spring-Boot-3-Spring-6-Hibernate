package com.springpractice.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Student {
    private String firstName;
    private String lastName;
    private String country;
    private String progLanguage;
    private List<String> favOperatingSystems;
}
