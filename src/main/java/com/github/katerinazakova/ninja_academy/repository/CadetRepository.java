package com.github.katerinazakova.ninja_academy.repository;

import com.github.katerinazakova.ninja_academy.entity.Cadet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadetRepository extends CrudRepository<Cadet,Integer>{

}
