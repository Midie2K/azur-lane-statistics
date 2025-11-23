package com.midie2k.azur_lane_statistics.services.filtration.filters;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Filter<T> {
    private T equals;
    private T notEquals;
    private List<T> in;
    private List<T> notIn;

    public T getEquals() {
        return equals;
    }

    public void setEquals(T equals) {
        this.equals = equals;
    }

    public T getNotEquals() {
        return notEquals;
    }

    public void setNotEquals(T notEquals) {
        this.notEquals = notEquals;
    }

    public List<T> getIn() {
        return in;
    }

    public void setIn(List<T> in) {
        this.in = in;
    }

    public List<T> getNotIn() {
        return notIn;
    }

    public void setNotIn(List<T> notIn) {
        this.notIn = notIn;
    }

    public Filter<T> copy(){
        Filter<T> copy = new Filter<>();
        copy.setEquals(getEquals());
        copy.setNotEquals(getNotEquals());
        copy.setIn(getIn() != null ? new ArrayList<>(getIn()) : null);
        copy.setNotIn(getNotIn() != null ? new ArrayList<>(getNotIn()) : null);
        return copy;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Filter<?> filter = (Filter<?>) o;
        return Objects.equals(equals, filter.equals) && Objects.equals(notEquals, filter.notEquals) && Objects.equals(in, filter.in) && Objects.equals(notIn, filter.notIn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equals, notEquals, in, notIn);
    }

    @Override
    public String toString() {
        return "Filter{" +
                "equals=" + equals +
                ", notEquals=" + notEquals +
                ", in=" + in +
                ", notIn=" + notIn +
                '}';
    }
}
