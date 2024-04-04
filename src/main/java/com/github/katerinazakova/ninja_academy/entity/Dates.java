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
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Dates {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private CourseEnum nameCourse;
    @Enumerated(EnumType.STRING)
    private DayEnum dayCourse;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime timeCourseFrom;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime timeCourseTo;
    private int ageFrom;
    private int ageTo;
    @ManyToOne
    private Course course;

    @OneToMany (mappedBy = "date")
    private List<Cadet> cadets;

}
