package com.midie2k.azur_lane_statistics.services.filtration.filters;

import java.util.ArrayList;
import java.util.Objects;

public class StringFilter extends Filter<String> {
    private String contains;
    private String notContains;
    private String startsWith;
    private String notStartsWith;
    private String endsWith;
    private String notEndsWith;
    private Boolean specified;

    public String getContains() {
        return contains;
    }

    public void setContains(String contains) {
        this.contains = contains;
    }

    public String getNotContains() {
        return notContains;
    }

    public void setNotContains(String notContains) {
        this.notContains = notContains;
    }

    public String getStartsWith() {
        return startsWith;
    }

    public void setStartsWith(String startsWith) {
        this.startsWith = startsWith;
    }

    public String getNotStartsWith() {
        return notStartsWith;
    }

    public void setNotStartsWith(String notStartsWith) {
        this.notStartsWith = notStartsWith;
    }

    public String getEndsWith() {
        return endsWith;
    }

    public void setEndsWith(String endsWith) {
        this.endsWith = endsWith;
    }

    public String getNotEndsWith() {
        return notEndsWith;
    }

    public void setNotEndsWith(String notEndsWith) {
        this.notEndsWith = notEndsWith;
    }

    public Boolean getSpecified() {
        return specified;
    }

    public void setSpecified(Boolean specified) {
        this.specified = specified;
    }

    @Override
    public StringFilter copy() {
        StringFilter copy = new StringFilter();
        copy.setEquals(getEquals());
        copy.setNotEquals(getNotEquals());
        copy.setIn(getIn() != null ? new ArrayList<>(getIn()) : null);
        copy.setNotIn(getNotIn() != null ? new ArrayList<>(getNotIn()) : null);
        copy.setContains(contains);
        copy.setNotContains(notContains);
        copy.setStartsWith(startsWith);
        copy.setNotStartsWith(notStartsWith);
        copy.setEndsWith(endsWith);
        copy.setNotEndsWith(notEndsWith);
        copy.setSpecified(specified);
        return copy;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StringFilter that = (StringFilter) o;
        return Objects.equals(contains, that.contains) && Objects.equals(notContains, that.notContains) && Objects.equals(startsWith, that.startsWith) && Objects.equals(notStartsWith, that.notStartsWith) && Objects.equals(endsWith, that.endsWith) && Objects.equals(notEndsWith, that.notEndsWith) && Objects.equals(specified, that.specified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), contains, notContains, startsWith, notStartsWith, endsWith, notEndsWith, specified);
    }

    @Override
    public String toString() {
        return "StringFilter{" +
                "contains='" + contains + '\'' +
                ", notContains='" + notContains + '\'' +
                ", startsWith='" + startsWith + '\'' +
                ", notStartsWith='" + notStartsWith + '\'' +
                ", endsWith='" + endsWith + '\'' +
                ", notEndsWith='" + notEndsWith + '\'' +
                ", specified=" + specified +
                '}';
    }
}
