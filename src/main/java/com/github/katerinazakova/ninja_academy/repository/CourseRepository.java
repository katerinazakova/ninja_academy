package com.github.katerinazakova.ninja_academy.repository;

import com.github.katerinazakova.ninja_academy.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course,Integer> {

}
