package com.github.katerinazakova.ninja_academy.service;

import com.github.katerinazakova.ninja_academy.entity.Cadet;
import com.github.katerinazakova.ninja_academy.entity.Dates;
import com.github.katerinazakova.ninja_academy.repository.CadetRepository;
import com.github.katerinazakova.ninja_academy.repository.DatesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CadetService {
    private final CadetRepository cadetRepository;
    private final DatesRepository datesRepository;


    public Cadet saveNewCadet (Cadet form){

        List<Dates> listDates = datesRepository.findByNameCourseAndDayCourseAndTimeCourseFrom(form.getNameCourse(), form.getDayCourse(),form.getStartTimeCourse());

        for(Dates selectedDate : listDates){
            if(form.getDayCourse()==selectedDate.getDayCourse()){
                form.setDate(selectedDate);
                return cadetRepository.save(form);
            }
        }
        throw new IllegalStateException("Nelze najít vhodný termín pro zadaný věk a název kurzu.");
    }


    public int calculateAge(Cadet form){
        Period period = form.getBirthDay().until(LocalDate.now());
        return period.getYears();
    }

}

