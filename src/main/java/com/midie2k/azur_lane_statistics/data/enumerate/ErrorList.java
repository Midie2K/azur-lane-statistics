package com.midie2k.azur_lane_statistics.data.enumerate;

public enum ErrorList {
    CLASS_NOT_FOUND("classNotFound"),
    ID_IS_GIVEN("idIsGiven"),
    ID_IS_MISSING("idIsMissing");

    private final String name;

    ErrorList( String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
