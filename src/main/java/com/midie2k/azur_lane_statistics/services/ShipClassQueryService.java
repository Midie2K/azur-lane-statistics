package com.midie2k.azur_lane_statistics.services;

import com.midie2k.azur_lane_statistics.data.entities.ShipClass;
import com.midie2k.azur_lane_statistics.data.entities.ShipClass_;
import com.midie2k.azur_lane_statistics.repository.ShipClassRepository;
import com.midie2k.azur_lane_statistics.services.dto.ShipClassDTO;
import com.midie2k.azur_lane_statistics.services.filtration.entities.ShipClassCriteria;
import com.midie2k.azur_lane_statistics.services.implementation.ShipClassServiceImpl;
import com.midie2k.azur_lane_statistics.services.mapper.ShipClassMapper;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShipClassQueryService extends QueryService<ShipClass> {

    private final Logger log = LoggerFactory.getLogger(ShipClassQueryService.class);
    private final ShipClassRepository shipClassRepository;
    private final ShipClassMapper shipClassMapper;

    public ShipClassQueryService(ShipClassRepository shipClassRepository, ShipClassMapper shipClassMapper) {
        this.shipClassRepository = shipClassRepository;
        this.shipClassMapper = shipClassMapper;
    }

    @Transactional(readOnly = true, isolation = Isolation.READ_UNCOMMITTED)
    public List<ShipClassDTO> getAll(ShipClassCriteria classCriteria){
        log.debug("Request to get all ship list");
        Specification<ShipClass> specification = createSpecification(classCriteria);
        return shipClassMapper.toDTO(shipClassRepository.findAll(specification));
    }

    @Transactional(readOnly = true, isolation = Isolation.READ_UNCOMMITTED)
    public ShipClassDTO getById(Long id){
        log.debug("Request to get ship class by id : {}", id);
        return shipClassMapper.toDTO(shipClassRepository.getById(id));
    }

    private Specification<ShipClass> createSpecification(ShipClassCriteria criteria) {
        Specification<ShipClass> specification = Specification.where(null);

        if (criteria.getId() != null) {
            specification = specification.and(buildRangeSpecification(criteria.getId(), ShipClass_.id));
        }
        if (criteria.getName() != null) {
            specification = specification.and(buildStringSpecification(criteria.getName(), ShipClass_.name));
        }

        return specification;
    }
}
