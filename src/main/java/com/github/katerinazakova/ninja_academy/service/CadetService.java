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

    public Cadet saveNewCadet(Cadet form) {
        form.setId(null);
        return cadetRepository.save(form);
    }

    public int calculateAge(Cadet form) {
        Period period = form.getBirthDay().until(LocalDate.now());
        return period.getYears();
    }

}

