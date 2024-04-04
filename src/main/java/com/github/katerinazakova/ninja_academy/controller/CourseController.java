package com.github.katerinazakova.ninja_academy.controller;

import com.github.katerinazakova.ninja_academy.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
public class CourseController {
    private final CourseService courseService;


    @GetMapping("/")
    public ModelAndView modelAndView(){
        ModelAndView modelAndView = new ModelAndView("/course/index");
        modelAndView.addObject("seznam", courseService.findAll());
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView modelAndView(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/course/detail");
        modelAndView.addObject("kurz", courseService.findCourseById(id));
        modelAndView.addObject("terminy",courseService.getDatesById(id));
        return modelAndView;
    }
}
