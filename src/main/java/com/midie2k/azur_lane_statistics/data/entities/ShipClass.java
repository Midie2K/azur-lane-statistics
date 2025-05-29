package com.midie2k.azur_lane_statistics.data.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "ship_class")
public class ShipClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

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
        ShipClass shipClass = (ShipClass) o;
        return Objects.equals(id, shipClass.id) && Objects.equals(name, shipClass.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "ShipClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
