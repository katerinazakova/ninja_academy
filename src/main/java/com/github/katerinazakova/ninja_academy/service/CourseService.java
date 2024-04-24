package com.github.katerinazakova.ninja_academy.service;

import com.github.katerinazakova.ninja_academy.entity.Course;
import com.github.katerinazakova.ninja_academy.entity.Dates;
import com.github.katerinazakova.ninja_academy.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final Logger logger = LoggerFactory.getLogger(CourseService.class);

    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }

    public Course findCourseById(int id) {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isPresent()) {
            return course.get();
        } else {
            logger.warn("kurz s id {} nebyl nalezen", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    public List<Dates> getDatesById(int id) {
       return courseRepository.findById(id)
               .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND)).getDates();

    }

}
