package com.midie2k.azur_lane_statistics.services;

import com.midie2k.azur_lane_statistics.data.entities.*;
import com.midie2k.azur_lane_statistics.data.enumerate.Armor;
import com.midie2k.azur_lane_statistics.data.enumerate.Rarity;
import com.midie2k.azur_lane_statistics.repository.ShipRepository;
import com.midie2k.azur_lane_statistics.services.dto.ShipDTO;
import com.midie2k.azur_lane_statistics.services.filtration.entities.ShipCriteria;
import com.midie2k.azur_lane_statistics.services.mapper.ShipMapper;
import jakarta.persistence.criteria.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShipQueryService extends QueryService<Ship> {

    private final Logger log = LoggerFactory.getLogger(ShipQueryService.class);
    private final ShipRepository shipRepository;
    private final ShipMapper shipMapper;

    public ShipQueryService(ShipRepository shipRepository, ShipMapper shipMapper) {
        this.shipRepository = shipRepository;
        this.shipMapper = shipMapper;
    }


    @Transactional(readOnly = true, isolation = Isolation.READ_UNCOMMITTED)
    public List<ShipDTO> getAll(ShipCriteria classCriteria){
        log.debug("Request to get all ship list");
        Specification<Ship> specification = createSpecification(classCriteria);
        return shipMapper.toDTO(shipRepository.findAll(specification));
    }

    @Transactional(readOnly = true, isolation = Isolation.READ_UNCOMMITTED)
    public Page<ShipDTO> getAllPage(ShipCriteria classCriteria, Pageable pageable){
        log.debug("Request to get all ship list");
        Specification<Ship> specification = createSpecification(classCriteria);
        return shipRepository.findAll(specification, pageable).map(shipMapper::toDTO);
    }

    @Transactional(readOnly = true, isolation = Isolation.READ_UNCOMMITTED)
    public ShipDTO getById(Long id){
        log.debug("Request to get ship by id : {}", id);
        return shipMapper.toDTO(shipRepository.getById(id));
    }


    private Specification<Ship> createSpecification(ShipCriteria criteria) {
        Specification<Ship> specification = Specification.where(null);

        if (criteria != null) {

            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Ship_.id));
            }
            if (criteria.getName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getName(), Ship_.name));
            }

            if (criteria.getFractionId() != null) {
                specification = specification.and(
                        buildRangeSpecification(criteria.getFractionId(),
                                root -> root.join(Ship_.fraction).get(Fraction_.id))
                );
            }

            if (criteria.getFractionIndex() != null) {
                specification = specification.and(
                        buildStringSpecification(criteria.getFractionIndex(),
                                root -> root.join(Ship_.fraction).get(Fraction_.index))
                );
            }

            if (criteria.getFractionName() != null) {
                specification = specification.and(
                        buildStringSpecification(criteria.getFractionName(),
                                root -> root.join(Ship_.fraction).get(Fraction_.name))
                );
            }

            if (criteria.getClassificationId() != null) {
                specification = specification.and(
                        buildRangeSpecification(criteria.getClassificationId(),
                                root -> root.join(Ship_.classification).get(Classification_.id))
                );
            }
            if (criteria.getClassificationIndex() != null) {
                specification = specification.and(
                        buildStringSpecification(criteria.getClassificationIndex(),
                                root -> root.join(Ship_.classification).get(Classification_.index))
                );
            }
            if (criteria.getClassificationName() != null) {
                specification = specification.and(
                        buildStringSpecification(criteria.getClassificationName(),
                                root -> root.join(Ship_.classification).get(Classification_.name))
                );
            }

            if (criteria.getShipClassId() != null) {
                specification = specification.and(
                        buildRangeSpecification(criteria.getShipClassId(),
                                root -> root.join(Ship_.shipClass).get(ShipClass_.id))
                );
            }
            if (criteria.getShipClassName() != null) {
                specification = specification.and(
                        buildStringSpecification(criteria.getShipClassName(),
                                root -> root.join(Ship_.shipClass).get(ShipClass_.name))
                );
            }

            if (criteria.getHp() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getHp(), Ship_.hp));
            }
            if (criteria.getFp() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getFp(), Ship_.fp));
            }
            if (criteria.getTrp() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getTrp(), Ship_.trp));
            }
            if (criteria.getAvi() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getAvi(), Ship_.avi));
            }
            if (criteria.getAa() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getAa(), Ship_.aa));
            }
            if (criteria.getRld() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getRld(), Ship_.rld));
            }
            if (criteria.getEvi() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getEvi(), Ship_.evi));
            }
            if (criteria.getSpd() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getSpd(), Ship_.spd));
            }
            if (criteria.getAcc() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getAcc(), Ship_.acc));
            }
            if (criteria.getLck() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getLck(), Ship_.lck));
            }
            if (criteria.getAsw() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getAsw(), Ship_.asw));
            }

            if (criteria.getArmor() != null) {
                specification = specification.and(
                    (root, query, cb) -> cb.equal(root.get(Ship_.armor), criteria.getArmor()));
            }

            if (criteria.getRarity() != null) {
                specification = specification.and(
                        (root, query, cb) -> cb.equal(root.get(Ship_.rarity), criteria.getRarity()));
            }

            if (criteria.getHasTime() != null && !criteria.getHasTime()){
                specification = specification.and(
                        (root, query, cb) -> cb.greaterThan(root.get(Ship_.buildTime), 0L));
            }
        }

        return specification;
    }

}
