package com.midie2k.azur_lane_statistics.services.dto;

import java.util.Objects;

public class ClassificationDTO {
    Long id;
    String index;
    String name;

    public ClassificationDTO() {
    }

    public ClassificationDTO(Long id, String index, String name) {
        this.id = id;
        this.index = index;
        this.name = name;
    }

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
        ClassificationDTO that = (ClassificationDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(index, that.index) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, index, name);
    }

    @Override
    public String toString() {
        return "ClassificationDTO{" +
                "id=" + id +
                ", index='" + index + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
