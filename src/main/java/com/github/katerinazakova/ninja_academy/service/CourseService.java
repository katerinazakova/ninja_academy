package com.github.katerinazakova.ninja_academy.service;

import com.github.katerinazakova.ninja_academy.entity.Course;
import com.github.katerinazakova.ninja_academy.entity.Dates;
import com.github.katerinazakova.ninja_academy.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }

    public Course findCourseById(int id) {
        return courseRepository.findById(id).get();
    }

    public List<Dates> getDatesById(int id) {
        return courseRepository.findById(id).get().getDates();
    }


}
