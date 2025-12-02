package com.midie2k.azur_lane_statistics.services;

import com.midie2k.azur_lane_statistics.data.entities.*;
import com.midie2k.azur_lane_statistics.repository.SkillRepository;
import com.midie2k.azur_lane_statistics.services.dto.SkillDTO;
import com.midie2k.azur_lane_statistics.services.filtration.entities.SkillCriteria;
import com.midie2k.azur_lane_statistics.services.implementation.SkillServiceImpl;
import com.midie2k.azur_lane_statistics.services.mapper.SkillMapper;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillQueryService extends QueryService<Skill>{
    private final Logger log = LoggerFactory.getLogger(SkillServiceImpl.class);
    private final SkillRepository skillRepository;
    private final SkillMapper skillMapper;

    public SkillQueryService(SkillRepository skillRepository, SkillMapper skillMapper) {
        this.skillRepository = skillRepository;
        this.skillMapper = skillMapper;
    }

    public List<SkillDTO> findAll(SkillCriteria criteria){
        log.debug("Find all skills by criteria : {}", criteria);
        Specification<Skill> specification = createSpecification(criteria);
        return skillMapper.toDTO(skillRepository.findAll(specification));
    }

    public Page<SkillDTO> findAllPage(SkillCriteria criteria, Pageable pageable) {
        log.debug("Find all skills by criteria: {}", criteria);
        Specification<Skill> specification = createSpecification(criteria);
        return skillRepository.findAll(specification, pageable)
                .map(skillMapper::toDTO);
    }

    public List<SkillDTO> getByShipId(Long id){
        log.debug("Find all skills by ship id : {}", id);
        return skillMapper.toDTO(skillRepository.findBySkipId(id));
    }



    private Specification<Skill> createSpecification(SkillCriteria criteria) {
        Specification<Skill> specification = Specification.where(null);

        if (criteria.getShipId() != null) {
            specification = specification.and((root, query, cb) -> {
                return cb.equal(root.get(Skill_.id), criteria.getShipId());
            });
        }

        return specification;
    }
}
