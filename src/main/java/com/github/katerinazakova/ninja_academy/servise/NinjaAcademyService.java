package com.github.katerinazakova.ninja_academy.servise;

import com.github.katerinazakova.ninja_academy.entity.NinjaAcademyForm;
import com.github.katerinazakova.ninja_academy.repository.NinjaAcademyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NinjaAcademyService {
    private final NinjaAcademyRepository ninjaAcademyRepository;

    public List<NinjaAcademyForm> findAll() {
        return (List<NinjaAcademyForm>) ninjaAcademyRepository.findAll();
    }

    public Optional<NinjaAcademyForm> findCadetById(Long id) {
        return ninjaAcademyRepository.findById(id);
    }
}

