package com.github.katerinazakova.ninja_academy.entity;

import lombok.Getter;

@Getter
public enum Course {
    TAEKWONDO ("taekwon-do"), KICKBOX("kickbox"), GYMNASTIKA ("gymnastika"), KRAVMAGA ("krav maga");

    private final String title;

    Course(String title) {
        this.title = title;
    }
}
