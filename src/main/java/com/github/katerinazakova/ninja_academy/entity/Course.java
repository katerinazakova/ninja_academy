package com.github.katerinazakova.ninja_academy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;
import java.util.EnumSet;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = CourseEnum.class)
    private EnumSet <CourseEnum> nameCourse = EnumSet.allOf(CourseEnum.class);
    private String characteristic;
    private String coach;
    @Enumerated(EnumType.STRING)
    private DayEnum dayOfCourse;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime timeOfCourse;

    @OneToMany (mappedBy = "course")
    private List<Cadet> cadets;

}
