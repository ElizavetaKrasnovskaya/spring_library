package com.bsuir.test.model;

public enum Genre {
    ADVENTURE("Adventure"),
    THRILLER("Thriller"),
    WESTERN("Western"),
    CRIME("Crime"),
    SCIENCE("Science"),
    POETRY("Poetry"),
    DRAMA("Drama"),
    FAIRY_TAIL("Fairy tail"),
    FANTASY("Fantasy"),
    FICTION("Fiction"),
    FOLKLORE("Folklore");

    private String name;

    Genre() {
    }

    Genre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
