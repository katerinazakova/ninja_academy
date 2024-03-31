package com.github.katerinazakova.ninja_academy.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class NinjaAcademyForm {
    @Id
    @GeneratedValue()
    private long id;
    private String firstName;
    private String secondName;
    private LocalDate birthDay;
    @Enumerated(EnumType.STRING)
    private Course nameCourse;
    private String timeCourse;
    private String nameParent;
    private String email;
    private String phoneNumber;
    private boolean parentEscort;
    private boolean gdpr;

    public NinjaAcademyForm() {
    }
}
