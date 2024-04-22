package com.github.katerinazakova.ninja_academy.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Cadet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    @Pattern(regexp = "^\\p{IsLatin}+$", message = "Musí obsahovat pouze písmena!")
    private String firstName;
    @NotBlank
    @Pattern(regexp = "^\\p{IsLatin}+$", message = "Musí obsahovat pouze písmena!")
    private String secondName;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDay;

    @Enumerated(EnumType.STRING)
    private CourseEnum nameCourse;

    @Enumerated(EnumType.STRING)
    private DayEnum dayCourse;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime startTimeCourse;
    @NotBlank
    @Pattern(regexp = "^\\p{IsLatin}+(\\s?\\p{IsLatin}+)+$", message = "Musí obsahovat pouze písmena a minimálně 2 slova!")
    private String nameParent;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Pattern(regexp = "^\\+?[0-9]+$", message = "Musí obsahovat pouze čísla nebo znak + pro mezinárodní předvolbu!")
    private String phoneNumber;
    private boolean parentEscort;

    @ManyToOne
    private Dates date;

}
