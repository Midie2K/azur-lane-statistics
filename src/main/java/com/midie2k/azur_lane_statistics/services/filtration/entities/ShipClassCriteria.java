package com.midie2k.azur_lane_statistics.services.filtration.entities;

import com.midie2k.azur_lane_statistics.data.entities.ShipClass;
import com.midie2k.azur_lane_statistics.services.filtration.filters.LongFilter;
import com.midie2k.azur_lane_statistics.services.filtration.filters.StringFilter;

import java.util.Objects;

public class ShipClassCriteria implements Criteria<ShipClass> {
    private LongFilter id;
    private StringFilter name;

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getName() {
        return name;
    }

    public void setName(StringFilter name) {
        this.name = name;
    }

    @Override
    public Criteria<ShipClass> copy() {
        ShipClassCriteria copy = new ShipClassCriteria();
        copy.id = this.id == null ? null : this.id.copy();
        copy.name = this.name == null ? null : this.name.copy();
        return copy;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ShipClassCriteria that = (ShipClassCriteria) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "ShipClassCriteria{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
