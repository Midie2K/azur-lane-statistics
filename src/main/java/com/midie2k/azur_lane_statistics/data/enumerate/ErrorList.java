package com.midie2k.azur_lane_statistics.data.enumerate;

public enum ErrorList {
    CLASS_NOT_FOUND("classNotFound"),
    CLASSIFICATION_NOT_FOUND("classificationNotFound"),
    ID_IS_GIVEN("idIsGiven"),
    ID_IS_MISSING("idIsMissing"),
    NAME_MISSING("nameMissing"),
    INDEX_MISSING("indexMissing");

    private final String name;

    ErrorList( String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
