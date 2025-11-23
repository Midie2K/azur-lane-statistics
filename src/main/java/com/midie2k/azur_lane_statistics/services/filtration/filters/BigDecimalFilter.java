package com.midie2k.azur_lane_statistics.services.filtration.filters;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;

public class BigDecimalFilter extends RangeFilter<BigDecimal> {
    private BigDecimal greaterThan;
    private BigDecimal lessThan;
    private BigDecimal greaterThanOrEqual;
    private BigDecimal lessThanOrEqual;

    @Override
    public BigDecimal getGreaterThan() {
        return greaterThan;
    }

    @Override
    public void setGreaterThan(BigDecimal greaterThan) {
        this.greaterThan = greaterThan;
    }

    @Override
    public BigDecimal getLessThan() {
        return lessThan;
    }

    @Override
    public void setLessThan(BigDecimal lessThan) {
        this.lessThan = lessThan;
    }

    @Override
    public BigDecimal getGreaterThanOrEqual() {
        return greaterThanOrEqual;
    }

    @Override
    public void setGreaterThanOrEqual(BigDecimal greaterThanOrEqual) {
        this.greaterThanOrEqual = greaterThanOrEqual;
    }

    @Override
    public BigDecimal getLessThanOrEqual() {
        return lessThanOrEqual;
    }

    @Override
    public void setLessThanOrEqual(BigDecimal lessThanOrEqual) {
        this.lessThanOrEqual = lessThanOrEqual;
    }

    @Override
    public BigDecimalFilter copy() {
        BigDecimalFilter copy = new BigDecimalFilter();
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BigDecimalFilter that = (BigDecimalFilter) o;
        return Objects.equals(greaterThan, that.greaterThan) && Objects.equals(lessThan, that.lessThan) && Objects.equals(greaterThanOrEqual, that.greaterThanOrEqual) && Objects.equals(lessThanOrEqual, that.lessThanOrEqual);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), greaterThan, lessThan, greaterThanOrEqual, lessThanOrEqual);
    }

    @Override
    public String toString() {
        return "BigDecimalFilter{" +
                "greaterThan=" + greaterThan +
                ", lessThan=" + lessThan +
                ", greaterThanOrEqual=" + greaterThanOrEqual +
                ", lessThanOrEqual=" + lessThanOrEqual +
                '}';
    }
}
