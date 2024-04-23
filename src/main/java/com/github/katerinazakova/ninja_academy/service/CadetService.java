package com.github.katerinazakova.ninja_academy.service;

import com.github.katerinazakova.ninja_academy.entity.Cadet;
import com.github.katerinazakova.ninja_academy.repository.CadetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.time.LocalDate;
import java.time.Period;

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


    public boolean isParentEscortRequired(Cadet form, BindingResult bindingResult) {
       int age = calculateAge(form);
        if (age < 7 && !form.isParentEscort()) {
            bindingResult.rejectValue("parentEscort", "errorParentEscort", "Dítě do 6 let musí mít zajištěno při odchodu z kurzu doprovod.");
            return true;
        }
        return false;
    }

    public boolean isKidOutOfAgeCategory(Cadet form, int from, int to, BindingResult bindingResult) {
        int age = calculateAge(form);
        if (age < from || age > to) {
            bindingResult.rejectValue("birthDay", "errorBirthday", "Dítě je mimo věkovou kategorii.");
            return true;
        }
        return false;
    }

}

