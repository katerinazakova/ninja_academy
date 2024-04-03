package com.github.katerinazakova.ninja_academy.entity;

import lombok.Getter;

@Getter
public enum DayEnum {
    PO ("Po"), UT ("Út"), ST("St"), CT ("Čt"), PA("Pá"), SO("So"), NE ("Ne");

    private final String title;

    DayEnum(String title){
        this.title=title;
    }

}
