package com.midie2k.azur_lane_statistics.services.dto;

import java.util.Objects;

public class ShipClassDTO {
    Long id;
    String name;

    public ShipClassDTO() {
    }

    public ShipClassDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ShipClassDTO that = (ShipClassDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "ShipClassDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
