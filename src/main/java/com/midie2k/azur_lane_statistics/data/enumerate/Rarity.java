package com.midie2k.azur_lane_statistics.data.enumerate;

public enum Rarity {
    COMMON(1, "common"),
    RARE(2, "rare"),
    ELITE(3, "elite"),
    SUPER_RARE(4, "superRare"),
    ULTRA_RARE(5, "ultraRare");

    private final int id;
    private final String name;

    Rarity(int id, String name) {
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
