package com.github.katerinazakova.ninja_academy.controller;

import com.github.katerinazakova.ninja_academy.entity.Cadet;
import com.github.katerinazakova.ninja_academy.service.CadetService;
import com.github.katerinazakova.ninja_academy.service.DatesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
@RequiredArgsConstructor
@Controller
public class CadetController {
    private final CadetService cadetService;
    private final DatesService datesService;


    @GetMapping("/termin/{id}")
    public ModelAndView zobrazPrazdnyFormular(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("cadet/form");
        modelAndView.addObject("termin", datesService.findDateById(id));
        modelAndView.addObject("kadet", new Cadet());
        return modelAndView;
    }

    @PostMapping("/termin/{id}")
    public Object ulozFormular(@ModelAttribute("kadet") @Valid Cadet form, @PathVariable int id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "cadet/form";
        }
        int age = cadetService.calculateAge(form);
        if (age < 3 || age > 15) {
            bindingResult.rejectValue("birthDay", "dateError", "Akademie je pro děti od 3 do 15 let.");
            return "cadet/form";
        }
        if (age < 7 && !form.isParentEscort()) {
            bindingResult.rejectValue("parentEscort", "ageError", "Dítě do šesti let věku musí odcházet v doprovodu rodičů.");
            return "cadet/form";
        }
        cadetService.saveNewCadet(form, id);
        return "redirect:/";
    }

}
