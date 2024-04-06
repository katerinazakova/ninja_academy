package com.github.katerinazakova.ninja_academy.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Cadet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String secondName;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDay;
    @NotNull
    @Enumerated(EnumType.STRING)
    private CourseEnum nameCourse;
    @NotNull
    @Enumerated(EnumType.STRING)
    private DayEnum dayCourse;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime startTimeCourse;
    @NotBlank
    private String nameParent;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String phoneNumber;
    private boolean parentEscort;

    @ManyToOne
    private Dates date;

}
