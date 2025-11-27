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

import java.util.List;

@Service
public class ShipQueryService extends QueryService<Ship> {

    private final Logger log = LoggerFactory.getLogger(ShipClassQueryService.class);
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
                specification = specification.and((root, query, cb) -> {
                    Join<Ship, Fraction> join = root.join(Ship_.fraction, JoinType.LEFT);
                    return cb.equal(join.get(Fraction_.id), criteria.getFractionId());
                });
            }

            if (criteria.getFractionIndex() != null) {
                specification = specification.and((root, query, cb) -> {
                    Join<Ship, Fraction> join = root.join(Ship_.fraction, JoinType.LEFT);
                    return cb.like(join.get(Fraction_.index),"%" + criteria.getFractionId() + "%");
                });
            }

            if (criteria.getFractionName() != null) {
                specification = specification.and((root, query, cb) -> {
                    Join<Ship, Fraction> join = root.join(Ship_.fraction, JoinType.LEFT);
                    return cb.like(join.get(Fraction_.name),"%" + criteria.getFractionId() + "%");
                });
            }

            if (criteria.getClassificationId() != null) {
                specification = specification.and((root, query, cb) -> {
                    Join<Ship, Classification> join = root.join(Ship_.classification, JoinType.LEFT);
                    return cb.equal(join.get(Classification_.id),  criteria.getClassificationId());
                });
            }
            if (criteria.getClassificationIndex() != null) {
                specification = specification.and((root, query, cb) -> {
                    Join<Ship, Classification> join = root.join(Ship_.classification, JoinType.LEFT);
                    return cb.like(join.get(Classification_.index), "%" + criteria.getClassificationIndex() + "%");
                });
            }
            if (criteria.getClassificationName() != null) {
                specification = specification.and((root, query, cb) -> {
                    Join<Ship, Classification> join = root.join(Ship_.classification, JoinType.LEFT);
                    return cb.like(join.get(Classification_.name), "%" + criteria.getClassificationName() + "%");
                });
            }

            if (criteria.getShipClassId() != null) {
                specification = specification.and((root, query, cb) -> {
                    Join<Ship, ShipClass> join = root.join(Ship_.shipClass, JoinType.LEFT);
                    return cb.equal(join.get(ShipClass_.id), criteria.getShipClassId());
                });
            }
            if (criteria.getShipClassName() != null) {
                specification = specification.and((root, query, cb) -> {
                    Join<Ship, ShipClass> join = root.join(Ship_.shipClass, JoinType.LEFT);
                    return cb.like(join.get(ShipClass_.name), "%" + criteria.getShipClassName() + "%");
                });
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
                specification = specification.and((root, query, cb) -> {
                    try {
                        Armor armorEnum = Armor.valueOf(criteria.getArmor());
                        return cb.equal(root.get(Ship_.armor), armorEnum);
                    } catch (IllegalArgumentException e) {
                        return cb.disjunction();
                    }
                });
            }

            if (criteria.getRarity() != null) {
                specification = specification.and((root, query, cb) -> {
                    try {
                        Rarity rarityEnum = Rarity.valueOf(criteria.getRarity());
                        return cb.equal(root.get(Ship_.rarity), rarityEnum);
                    } catch (IllegalArgumentException e) {
                        return cb.disjunction();
                    }
                });
            }
        }

        return specification;
    }

}
