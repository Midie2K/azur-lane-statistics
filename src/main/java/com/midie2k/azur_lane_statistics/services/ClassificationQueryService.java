package com.midie2k.azur_lane_statistics.services;

import com.midie2k.azur_lane_statistics.data.entities.Classification;
import com.midie2k.azur_lane_statistics.data.entities.Classification_;
import com.midie2k.azur_lane_statistics.repository.ClassificationRepository;
import com.midie2k.azur_lane_statistics.services.dto.ClassificationDTO;
import com.midie2k.azur_lane_statistics.services.filtration.entities.ClassificationCriteria;
import com.midie2k.azur_lane_statistics.services.mapper.ClassificationMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClassificationQueryService extends QueryService<Classification> {
    private final Logger log = LoggerFactory.getLogger(ClassificationQueryService.class);
    private final ClassificationRepository classificationRepository;
    private final ClassificationMapper classificationMapper;

    public ClassificationQueryService(ClassificationRepository classificationRepository, ClassificationMapper classificationMapper) {
        this.classificationRepository = classificationRepository;
        this.classificationMapper = classificationMapper;
    }

    @Transactional(readOnly = true, isolation = Isolation.READ_UNCOMMITTED)
    public List<ClassificationDTO> getAll(ClassificationCriteria criteria){
        log.debug("Request to get all ship classification list");
        Specification<Classification> specification = createSpecification(criteria);
        return classificationMapper.toDTO(classificationRepository.findAll(specification));
    }

    @Transactional(readOnly = true, isolation = Isolation.READ_UNCOMMITTED)
    public ClassificationDTO getById(Long id){
        log.debug("Request to get ship classification by id : {}", id);
        return classificationMapper.toDTO(classificationRepository.getById(id));
    }

    private Specification<Classification> createSpecification(ClassificationCriteria criteria) {
        Specification<Classification> specification = Specification.where(null);

        if (criteria.getId() != null) {
            specification = specification.and(buildRangeSpecification(criteria.getId(), Classification_.id));
        }
        if (criteria.getIndex() != null) {
            specification = specification.and(buildStringSpecification(criteria.getIndex(), Classification_.index));
        }
        if (criteria.getName() != null) {
        specification = specification.and(buildStringSpecification(criteria.getName(), Classification_.name));
    }

        return specification;
    }
}
