package com.midie2k.azur_lane_statistics.services;

import com.midie2k.azur_lane_statistics.services.dto.EventDTO;

public interface EventService {

    EventDTO save(EventDTO dto);

    void delete(Long id);
}
