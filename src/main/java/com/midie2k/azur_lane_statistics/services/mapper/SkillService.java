package com.midie2k.azur_lane_statistics.services.mapper;

import com.midie2k.azur_lane_statistics.services.dto.SkillDTO;

public interface SkillService {

    SkillDTO save(SkillDTO skillDTO);

    void delete(Long id);
}
