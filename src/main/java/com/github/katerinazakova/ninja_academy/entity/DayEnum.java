package com.github.katerinazakova.ninja_academy.entity;

import lombok.Getter;

@Getter
public enum DayEnum {
    PO ("po"), UT ("út"), ST("st"), CT ("čt"), PA("pá"), SO("so"), NE ("ne");

    private final String title;

    DayEnum(String title){
        this.title=title;
    }

}
