package com.midie2k.azur_lane_statistics.data.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "fraction")
public class Fraction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "index")
    private String index;

    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
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
        Fraction fraction = (Fraction) o;
        return Objects.equals(id, fraction.id) && Objects.equals(index, fraction.index) && Objects.equals(name, fraction.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, index, name);
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "id=" + id +
                ", index='" + index + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
