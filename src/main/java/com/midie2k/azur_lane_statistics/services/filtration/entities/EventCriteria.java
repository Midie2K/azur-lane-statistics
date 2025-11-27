package com.midie2k.azur_lane_statistics.services.filtration.entities;

import com.midie2k.azur_lane_statistics.data.entities.Event;

import com.midie2k.azur_lane_statistics.services.filtration.filters.LongFilter;
import com.midie2k.azur_lane_statistics.services.filtration.filters.StringFilter;

import java.util.Objects;

public class EventCriteria implements Criteria<Event>{

    private LongFilter id;

    private StringFilter name;

    @Override
    public Criteria<Event> copy() {
        EventCriteria copy = new EventCriteria();
        copy.id = this.id == null ? null : this.id.copy();
        copy.name = this.name == null ? null : this.name.copy();

        return copy;
    }

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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EventCriteria that = (EventCriteria) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "EventCriteria{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
