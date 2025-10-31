package com.spring_mvc_demo.validation_demo.validation.annotations;

import com.spring_mvc_demo.validation_demo.validation.CourseCodeConstraintValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
public @interface CourseCode {

    //define default value
    String value() default "HSA";

    //define default error message
    String message() default "Course Code must start with HSA";

    //define default groups
    public Class<?>[] groups() default {};

    //define default payloads
    //payloads provides additional details or custom details about validation failure
    //(severity, error codes, ....)
    public Class<? extends Payload>[] payload() default {};
}
