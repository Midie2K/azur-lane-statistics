package com.midie2k.azur_lane_statistics.services.implementation;

import com.midie2k.azur_lane_statistics.data.entities.Skill;
import com.midie2k.azur_lane_statistics.repository.SkillRepository;
import com.midie2k.azur_lane_statistics.services.dto.SkillDTO;
import com.midie2k.azur_lane_statistics.services.mapper.SkillMapper;
import com.midie2k.azur_lane_statistics.services.SkillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SkillServiceImpl implements SkillService {
    private final Logger log = LoggerFactory.getLogger(SkillServiceImpl.class);
    private final SkillMapper skillMapper;
    private final SkillRepository skillRepository;

    public SkillServiceImpl(SkillMapper skillMapper, SkillRepository skillRepository) {
        this.skillMapper = skillMapper;
        this.skillRepository = skillRepository;
    }

    @Override
    public SkillDTO save(SkillDTO skillDTO) {
        log.debug("Save skill : {}", skillDTO);
        Skill skill = skillMapper.toEntity(skillDTO);
        return skillMapper.toDTO(skillRepository.save(skill));
    }

    @Override
    public void delete(Long id) {
        log.debug("Delete skill by id: {}", id);
        skillRepository.deleteById(id);
    }
}
