package com.spring_mvc_demo.validation_demo.model;

import com.spring_mvc_demo.validation_demo.validation.annotations.CourseCode;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Customer {
    @NotNull(message = "first name can't be empty")
    @Size(min = 1, message = "first name required")
    private String firstName;

    @NotNull(message = "last name can't be empty")
    @Size(min = 1, message = "last name required")
    private String lastName;

    @NotNull(message = "field can't be empty")
    @Min(value = 0, message = "free passes can't be less than 0")
    @Max(value = 10, message = "free passes can't be more than 10")
    private Integer freePasses;

    @NotNull(message = "postal code can't be empty")
    @Min(value = 0, message = "postal code can't be less than 0")
    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits allowed")
    private String postalCode;

    @NotNull(message = "Course code can't be empty")
    @CourseCode(value = "LUV", message = "Course Code must start with LUV")
    private String course;
}
