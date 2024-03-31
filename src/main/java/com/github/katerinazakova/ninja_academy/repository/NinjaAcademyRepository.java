package com.github.katerinazakova.ninja_academy.repository;

import com.github.katerinazakova.ninja_academy.entity.NinjaAcademyForm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NinjaAcademyRepository extends CrudRepository<NinjaAcademyForm,Long>{

}
