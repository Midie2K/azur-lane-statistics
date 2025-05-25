package com.midie2k.azur_lane_statistics.services.filtration.filters;

import java.util.ArrayList;

public class RangeFilter<T extends Comparable<? super T>> extends Filter<T> {
    private T greaterThan;
    private T lessThan;
    private T greaterThanOrEqual;
    private T lessThanOrEqual;

    public T getGreaterThan() {
        return greaterThan;
    }

    public void setGreaterThan(T greaterThan) {
        this.greaterThan = greaterThan;
    }

    public T getLessThan() {
        return lessThan;
    }

    public void setLessThan(T lessThan) {
        this.lessThan = lessThan;
    }

    public T getGreaterThanOrEqual() {
        return greaterThanOrEqual;
    }

    public void setGreaterThanOrEqual(T greaterThanOrEqual) {
        this.greaterThanOrEqual = greaterThanOrEqual;
    }

    public T getLessThanOrEqual() {
        return lessThanOrEqual;
    }

    public void setLessThanOrEqual(T lessThanOrEqual) {
        this.lessThanOrEqual = lessThanOrEqual;
    }

    @Override
    public RangeFilter<T> copy() {
        RangeFilter<T> copy = new RangeFilter<>();
        copy.setEquals(getEquals());
        copy.setNotEquals(getNotEquals());
        copy.setIn(getIn() != null ? new ArrayList<>(getIn()) : null);
        copy.setNotIn(getNotIn() != null ? new ArrayList<>(getNotIn()) : null);
        copy.setGreaterThan(greaterThan);
        copy.setLessThan(lessThan);
        copy.setGreaterThanOrEqual(greaterThanOrEqual);
        copy.setLessThanOrEqual(lessThanOrEqual);
        return copy;
    }
}
