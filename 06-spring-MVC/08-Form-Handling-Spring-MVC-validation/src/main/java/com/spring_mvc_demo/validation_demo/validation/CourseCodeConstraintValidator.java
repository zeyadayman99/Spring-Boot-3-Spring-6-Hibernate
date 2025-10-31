package com.spring_mvc_demo.validation_demo.validation;

import com.spring_mvc_demo.validation_demo.validation.annotations.CourseCode;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator
        implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode theCourse) {
        coursePrefix = theCourse.value();
    }

    //the first parameter here is the HTML form data entered byb the user
    @Override
    public boolean isValid(String courseUserEnteredData, ConstraintValidatorContext constraintValidatorContext) {
        if (courseUserEnteredData != null) {
            return courseUserEnteredData.startsWith(coursePrefix);
        }
        return true;
    }
}
