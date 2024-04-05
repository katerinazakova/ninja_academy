package com.github.katerinazakova.ninja_academy.repository;

import com.github.katerinazakova.ninja_academy.entity.CourseEnum;
import com.github.katerinazakova.ninja_academy.entity.Dates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatesRepository extends JpaRepository<Dates,Integer> {

    List<Dates> findByNameCourse (CourseEnum nameCourse);
}
