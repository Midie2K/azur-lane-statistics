package com.midie2k.azur_lane_statistics.services.implementation;

import com.midie2k.azur_lane_statistics.data.entities.Classification;
import com.midie2k.azur_lane_statistics.data.entities.ShipClass;
import com.midie2k.azur_lane_statistics.data.enumerate.ErrorList;
import com.midie2k.azur_lane_statistics.repository.ClassificationRepository;
import com.midie2k.azur_lane_statistics.services.ClassificationService;
import com.midie2k.azur_lane_statistics.services.dto.ClassificationDTO;
import com.midie2k.azur_lane_statistics.services.errors.ObjectException;
import com.midie2k.azur_lane_statistics.services.mapper.ClassificationMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ClassificationServiceImpl implements ClassificationService {
    private final Logger log = LoggerFactory.getLogger(ClassificationServiceImpl.class);
    private final ClassificationRepository classificationRepository;
    private final ClassificationMapper classificationMapper;

    public ClassificationServiceImpl(ClassificationRepository classificationRepository, ClassificationMapper classificationMapper) {
        this.classificationRepository = classificationRepository;
        this.classificationMapper = classificationMapper;
    }

    @Override
    public ClassificationDTO save(ClassificationDTO dto) {
        log.debug("Request to save classification: {}", dto);
        if(dto.getName() == null || dto.getName().isBlank()){
            throw new ObjectException("Missing classification name", ErrorList.NAME_MISSING);
        }
        if(dto.getIndex() == null || dto.getIndex().isBlank()){
            throw new ObjectException("Missing classification index", ErrorList.INDEX_MISSING);
        }
        Classification classification = classificationRepository.save(classificationMapper.toEntity(dto));
        return classificationMapper.toDTO(classification);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete classification by id : {}", id);
        Classification classification = classificationRepository.getReferenceById(id);
        if(classification.getId() == null){
            throw new ObjectException("Classification not found with id : " + id, ErrorList.CLASS_NOT_FOUND);
        }
        classificationRepository.deleteById(id);
    }
}
