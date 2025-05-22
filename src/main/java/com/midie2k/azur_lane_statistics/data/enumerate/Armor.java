package com.midie2k.azur_lane_statistics.data.enumerate;

public enum Armor {
    LIGHT(1, "LIGHT"),
    MEDIUM(2, "MEDIUM"),
    HEAVY(2, "HEAVY");

    private final int id;
    private final String name;

    Armor(int id, String name) {
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
