package com.midie2k.azur_lane_statistics.services;

import com.midie2k.azur_lane_statistics.services.dto.ClassificationDTO;

public interface ClassificationService {

    ClassificationDTO save(ClassificationDTO dto);

    void delete(Long id);
}
