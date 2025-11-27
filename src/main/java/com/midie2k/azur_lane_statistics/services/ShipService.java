package com.midie2k.azur_lane_statistics.services;


import com.midie2k.azur_lane_statistics.services.dto.ShipDTO;

public interface ShipService {

    ShipDTO save(ShipDTO dto);

    void delete(Long id);
}
