package com.github.katerinazakova.ninja_academy.controller;

import com.github.katerinazakova.ninja_academy.entity.Cadet;
import com.github.katerinazakova.ninja_academy.entity.Dates;
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
        Dates dateOfCadetById = datesService.findDateById(id);
        modelAndView.addObject("termin", dateOfCadetById);
        if (cadetService.processRegistration(form, dateOfCadetById, bindingResult)) {
            return modelAndView;
        }
        cadetService.saveNewCadet(form);
        return "cadet/recap";
    }

    @GetMapping("/editCadet/{id}")
    public ModelAndView zobrazRegistraci(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("cadet/form");
        modelAndView.addObject("kadet", cadetService.findCadetById(id));
        modelAndView.addObject("termin", cadetService.findCadetById(id).getDate());
        return modelAndView;
    }

    @PostMapping("/editCadet/{id}")
    public Object upravRegistraci(@PathVariable int id, @Valid @ModelAttribute("kadet") Cadet form, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("cadet/form");
        Dates dateOfCadetById = cadetService.findCadetById(id).getDate();
        modelAndView.addObject("termin", dateOfCadetById);

        if (cadetService.processRegistration(form, dateOfCadetById, bindingResult)) {
            return modelAndView;
        }
        cadetService.saveCadetChanges(form);
        return "redirect:/obsazenost/" + (dateOfCadetById.getId());
    }

    @PostMapping ("/cadet/{id}")
    public String smazatKadeta (@PathVariable int id) {
        cadetService.deleteCadetById(id);
        return "cadet/delete";
    }

}
