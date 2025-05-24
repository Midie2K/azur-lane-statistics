package com.midie2k.azur_lane_statistics.services.errors;

import com.midie2k.azur_lane_statistics.data.enumerate.ErrorList;

public class ObjectException extends RuntimeException {

    private final ErrorList error;

    public ObjectException(String message, ErrorList error) {
        super(message);
        this.error = error;
    }

    public ErrorList getError() {
        return error;
    }
}
