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
    public Object ulozKadeta(@PathVariable int id, @Valid @ModelAttribute("kadet") Cadet form, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("cadet/form");
        modelAndView.addObject("termin", datesService.findDateById(id));
        if (bindingResult.hasErrors()) {
            return modelAndView;
        }
        int age = cadetService.calculateAge(form);

        if (age < datesService.findDateById(id).getAgeFrom() || age > datesService.findDateById(id).getAgeTo()) {
            bindingResult.rejectValue("birthDay", "birthdateError", "Dítě neodpovídá věkové kategorii.");
            return modelAndView;
        }
        if (age < 7 && !form.isParentEscort()) {
            bindingResult.rejectValue("parentEscort", "ageError", "Dítě do šesti let věku musí odcházet v doprovodu rodičů.");
            return modelAndView;
        }

        form.setDate(datesService.findDateById(id));
        cadetService.saveNewCadet(form);
        return "redirect:/obsazenost/{id}";

    }

}
