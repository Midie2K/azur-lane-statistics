package com.midie2k.azur_lane_statistics.services.filtration.filters;

import java.util.ArrayList;

public class LongFilter extends RangeFilter<Long>{
    private Long greaterThan;
    private Long lessThan;
    private Long greaterThanOrEqual;
    private Long lessThanOrEqual;

    @Override
    public Long getGreaterThan() {
        return greaterThan;
    }

    @Override
    public void setGreaterThan(Long greaterThan) {
        this.greaterThan = greaterThan;
    }

    @Override
    public Long getLessThan() {
        return lessThan;
    }

    @Override
    public void setLessThan(Long lessThan) {
        this.lessThan = lessThan;
    }

    @Override
    public Long getGreaterThanOrEqual() {
        return greaterThanOrEqual;
    }

    @Override
    public void setGreaterThanOrEqual(Long greaterThanOrEqual) {
        this.greaterThanOrEqual = greaterThanOrEqual;
    }

    @Override
    public Long getLessThanOrEqual() {
        return lessThanOrEqual;
    }

    @Override
    public void setLessThanOrEqual(Long lessThanOrEqual) {
        this.lessThanOrEqual = lessThanOrEqual;
    }

    @Override
    public LongFilter copy() {
        LongFilter copy = new LongFilter();
        copy.setEquals(this.getEquals());
        copy.setNotEquals(this.getNotEquals());
        copy.setIn(this.getIn() != null ? new ArrayList<>(getIn()) : null);
        copy.setNotIn(this.getNotIn() != null ? new ArrayList<>(getNotIn()) : null);
        copy.setGreaterThan(this.greaterThan);
        copy.setLessThan(this.lessThan);
        copy.setGreaterThanOrEqual(this.greaterThanOrEqual);
        copy.setLessThanOrEqual(this.lessThanOrEqual);
        return copy;
    }
}
