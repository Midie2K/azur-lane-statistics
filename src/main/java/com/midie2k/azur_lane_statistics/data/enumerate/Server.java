package com.midie2k.azur_lane_statistics.data.enumerate;

public enum Server {
    AVRORA(1, "Aurora"),
    LEXINGTON(2, "Lexington"),
    SANDY(3, "Sandy"),
    WASHINGTON(4, "Washington"),
    AMAGI(5, "Amagi"),
    LITTLE_ENTERPRISE(6, "LittleEnterprise");

    private final int id;
    private final String name;

    Server(int id, String name) {
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
