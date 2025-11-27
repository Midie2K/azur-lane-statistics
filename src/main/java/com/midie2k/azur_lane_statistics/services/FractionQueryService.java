package com.midie2k.azur_lane_statistics.services;

import com.midie2k.azur_lane_statistics.data.entities.Classification;
import com.midie2k.azur_lane_statistics.data.entities.Classification_;
import com.midie2k.azur_lane_statistics.data.entities.Fraction;
import com.midie2k.azur_lane_statistics.data.entities.Fraction_;
import com.midie2k.azur_lane_statistics.repository.FractionRepository;
import com.midie2k.azur_lane_statistics.services.dto.ClassificationDTO;
import com.midie2k.azur_lane_statistics.services.dto.FractionDTO;
import com.midie2k.azur_lane_statistics.services.filtration.entities.ClassificationCriteria;
import com.midie2k.azur_lane_statistics.services.filtration.entities.FractionCriteria;
import com.midie2k.azur_lane_statistics.services.mapper.FractionMapper;
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
public class FractionQueryService extends QueryService<Fraction> {
    private final Logger log = LoggerFactory.getLogger(FractionQueryService.class);
    private final FractionRepository fractionRepository;
    private final FractionMapper fractionMapper;


    public FractionQueryService(FractionRepository fractionRepository, FractionMapper fractionMapper) {
        this.fractionRepository = fractionRepository;
        this.fractionMapper = fractionMapper;
    }

    @Transactional(readOnly = true, isolation = Isolation.READ_UNCOMMITTED)
    public List<FractionDTO> getAll(FractionCriteria criteria){
        log.debug("Request to get all ship fraction list");
        Specification<Fraction> specification = createSpecification(criteria);
        return fractionMapper.toDTO(fractionRepository.findAll(specification));
    }

    @Transactional(readOnly = true, isolation = Isolation.READ_UNCOMMITTED)
    public Page<FractionDTO> getAllPage(FractionCriteria criteria, Pageable page){
        log.debug("Request to get all ship paged fraction list with criteria: {}", criteria);
        Specification<Fraction> specification = createSpecification(criteria);
        return fractionRepository.findAll(specification, page).map(fractionMapper::toDTO);
    }

    @Transactional(readOnly = true, isolation = Isolation.READ_UNCOMMITTED)
    public FractionDTO getById(Long id){
        log.debug("Request to get ship fraction by id : {}", id);
        return fractionMapper.toDTO(fractionRepository.getById(id));
    }



    private Specification<Fraction> createSpecification(FractionCriteria criteria) {
        Specification<Fraction> specification = Specification.where(null);

        if (criteria.getId() != null) {
            specification = specification.and(buildRangeSpecification(criteria.getId(), Fraction_.id));
        }
        if (criteria.getIndex() != null) {
            specification = specification.and(buildStringSpecification(criteria.getIndex(), Fraction_.index));
        }
        if (criteria.getName() != null) {
            specification = specification.and(buildStringSpecification(criteria.getName(), Fraction_.name));
        }

        return specification;
    }
}
