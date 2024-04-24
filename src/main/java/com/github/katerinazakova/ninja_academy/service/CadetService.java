package com.github.katerinazakova.ninja_academy.service;

import com.github.katerinazakova.ninja_academy.entity.Cadet;
import com.github.katerinazakova.ninja_academy.entity.Dates;
import com.github.katerinazakova.ninja_academy.repository.CadetRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CadetService {
    private final Logger logger = LoggerFactory.getLogger(CadetService.class);
    private final CadetRepository cadetRepository;

    public Cadet findCadetById(int id) {
        Optional<Cadet> cadet = cadetRepository.findById(id);

        if(cadet.isPresent()){
            return cadet.get();
        } else {
            logger.warn("Kadet s id{} nebyl nalezen", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    public Cadet saveCadetChanges(Cadet cadet) {
        return cadetRepository.save(cadet);
    }

    public Cadet saveNewCadet(Cadet form) {
        form.setId(null);
        return cadetRepository.save(form);
    }

    public void deleteCadetById(int id) {
        cadetRepository.deleteById(id);
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

    public boolean processRegistration(Cadet form, Dates dateOfCadetById, BindingResult bindingResult) {
        int from = dateOfCadetById.getAgeFrom();
        int to = dateOfCadetById.getAgeTo();

        if (bindingResult.hasErrors()) {
            return true;
        }

        if (isKidOutOfAgeCategory(form, from, to, bindingResult)
                || isParentEscortRequired(form, bindingResult)) {
            return true;
        }

        form.setDate(dateOfCadetById);
        return false;
    }

}

