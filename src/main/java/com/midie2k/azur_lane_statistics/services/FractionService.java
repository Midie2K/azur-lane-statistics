package com.midie2k.azur_lane_statistics.services;

import com.midie2k.azur_lane_statistics.services.dto.FractionDTO;

public interface FractionService {

    FractionDTO save(FractionDTO fractionDTO);

    void delete(Long id);
}
