package com.midie2k.azur_lane_statistics.data.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "classification")
public class Classification {

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
        Classification that = (Classification) o;
        return Objects.equals(id, that.id) && Objects.equals(index, that.index) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, index, name);
    }

    @Override
    public String toString() {
        return "Classification{" +
                "id=" + id +
                ", index='" + index + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
