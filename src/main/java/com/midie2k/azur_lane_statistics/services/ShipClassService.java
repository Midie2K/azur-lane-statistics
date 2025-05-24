package com.midie2k.azur_lane_statistics.services;

import com.midie2k.azur_lane_statistics.data.entities.ShipClass;
import com.midie2k.azur_lane_statistics.services.dto.ShipClassDTO;

import java.util.List;

public interface ShipClassService {

    ShipClassDTO save(ShipClassDTO dto);

    void delete(Long id);
}
