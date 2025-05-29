package com.midie2k.azur_lane_statistics.services;

import com.midie2k.azur_lane_statistics.services.dto.ShipClassDTO;

public interface ShipClassService {

    ShipClassDTO save(ShipClassDTO dto);

    void delete(Long id);
}
