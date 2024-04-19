package com.github.katerinazakova.ninja_academy.repository;

import com.github.katerinazakova.ninja_academy.entity.Dates;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatesRepository extends CrudRepository<Dates,Integer> {

}
