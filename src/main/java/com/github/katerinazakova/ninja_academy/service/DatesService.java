package com.github.katerinazakova.ninja_academy.service;

import com.github.katerinazakova.ninja_academy.entity.Cadet;
import com.github.katerinazakova.ninja_academy.entity.Dates;
import com.github.katerinazakova.ninja_academy.repository.DatesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DatesService {
    private final DatesRepository datesRepository;
    public List<Dates> findAllDates (){
        return (List<Dates>) datesRepository.findAll();
    }
    public Dates findDateById (int id){
        return datesRepository.findById(id).get();
    }
    public List<Cadet> getAllCadetsById (int id){
        return datesRepository.findById(id).get().getCadets();

    }
}
