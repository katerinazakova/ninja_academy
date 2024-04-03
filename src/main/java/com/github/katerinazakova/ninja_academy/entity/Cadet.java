package com.github.katerinazakova.ninja_academy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.EnumSet;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Cadet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String secondName;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDay;
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = CourseEnum.class)
    private EnumSet<CourseEnum> nameCourse = EnumSet.noneOf(CourseEnum.class);
    private String dateCourse;
    private String nameParent;
    private String email;
    private String phoneNumber;
    private boolean parentEscort;

    @ManyToOne
    private Dates date;

}
