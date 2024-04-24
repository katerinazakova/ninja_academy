package com.github.katerinazakova.ninja_academy.service;

import com.github.katerinazakova.ninja_academy.entity.Cadet;
import com.github.katerinazakova.ninja_academy.entity.Dates;
import com.github.katerinazakova.ninja_academy.repository.DatesRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DatesService {
    private final DatesRepository datesRepository;
    private final Logger logger = LoggerFactory.getLogger(DatesService.class);

    public Dates findDateById (int id){
       Optional<Dates> date = datesRepository.findById(id);
       if(date.isPresent()){
           return date.get();
       } else {
           logger.warn("termín s id{} není nalezen",id);
           throw new ResponseStatusException(HttpStatus.NOT_FOUND);
       }
    }

    public List<Cadet> getAllCadetsById (int id){
        return datesRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)).getCadets();

    }

}
