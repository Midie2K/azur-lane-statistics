package com.midie2k.azur_lane_statistics.services.filtration.filters;

import java.util.ArrayList;
import java.util.List;

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

}
