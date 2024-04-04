package com.github.katerinazakova.ninja_academy.controller;

import com.github.katerinazakova.ninja_academy.service.DatesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class DatesController {
    private final DatesService datesService;

    @GetMapping("/termin/{id}")
    public ModelAndView modelAndView(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("dates/detail");
        modelAndView.addObject("termin",datesService.findDateById(id));
        modelAndView.addObject("kadeti", datesService.getAllCadetsById(id));
        return modelAndView;
    }
}
