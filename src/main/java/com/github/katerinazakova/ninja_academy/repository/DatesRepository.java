package com.github.katerinazakova.ninja_academy.repository;

import com.github.katerinazakova.ninja_academy.entity.CourseEnum;
import com.github.katerinazakova.ninja_academy.entity.Dates;
import com.github.katerinazakova.ninja_academy.entity.DayEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;

@Repository
public interface DatesRepository extends JpaRepository<Dates,Integer> {

    List<Dates> findByNameCourseAndDayCourseAndTimeCourseFrom (CourseEnum nameCourse, DayEnum dayEnum, LocalTime TimeCourseFrom);
}
