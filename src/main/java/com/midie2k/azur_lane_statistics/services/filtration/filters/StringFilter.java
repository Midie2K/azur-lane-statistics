package com.midie2k.azur_lane_statistics.services.filtration.filters;

import java.util.ArrayList;

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
}
