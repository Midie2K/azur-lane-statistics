package com.midie2k.azur_lane_statistics.data.enumerate;

public enum SkillType {
    OFFENSIVE(1, "OFFENSIVE"),
    DEFENSIVE(2, "DEFENSIVE"),
    SUPPORT(3, "SUPPORT");


    private final int id;
    private final String name;

    SkillType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
