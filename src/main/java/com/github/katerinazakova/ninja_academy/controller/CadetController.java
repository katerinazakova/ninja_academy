package com.github.katerinazakova.ninja_academy.controller;

import com.github.katerinazakova.ninja_academy.entity.Cadet;
import com.github.katerinazakova.ninja_academy.service.CadetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
@RequiredArgsConstructor
@Controller
public class CadetController {
    private final CadetService cadetService;


    @GetMapping("/kadet")
    public ModelAndView zobrazPrazdnyFormular (){
        ModelAndView modelAndView = new ModelAndView("cadet/form");
        modelAndView.addObject("kadet",new Cadet());
        return modelAndView;
    }

    @PostMapping("/kadet")
    public String formular (@Valid @ModelAttribute ("kadet") Cadet form, BindingResult bindingResult){
    if(bindingResult.hasErrors()){
        return "cadet/form";
    }
    cadetService.saveNewCadet(form);
    return "cadet/recap";
    }


}
