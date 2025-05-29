package com.midie2k.azur_lane_statistics.services.filtration.entities;

import com.midie2k.azur_lane_statistics.data.entities.Classification;
import com.midie2k.azur_lane_statistics.services.filtration.filters.LongFilter;
import com.midie2k.azur_lane_statistics.services.filtration.filters.StringFilter;

import java.util.Objects;

public class ClassificationCriteria implements Criteria<Classification>{

    private LongFilter id;
    private StringFilter index;
    private StringFilter name;

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getIndex() {
        return index;
    }

    public void setIndex(StringFilter index) {
        this.index = index;
    }

    public StringFilter getName() {
        return name;
    }

    public void setName(StringFilter name) {
        this.name = name;
    }

    @Override
    public Criteria<Classification> copy() {
        ClassificationCriteria copy = new ClassificationCriteria();
        copy.id = this.id == null ? null : this.id.copy();
        copy.index = this.index == null ? null : this.index.copy();
        copy.name = this.name == null ? null : this.name.copy();
        return copy;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ClassificationCriteria that = (ClassificationCriteria) o;
        return Objects.equals(id, that.id) && Objects.equals(index, that.index) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, index, name);
    }

    @Override
    public String toString() {
        return "ClassificationCriteria{" +
                "id=" + id +
                ", index=" + index +
                ", name=" + name +
                '}';
    }
}
