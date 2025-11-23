package com.midie2k.azur_lane_statistics.web.api;

import com.midie2k.azur_lane_statistics.data.enumerate.ErrorList;
import com.midie2k.azur_lane_statistics.services.ClassificationQueryService;
import com.midie2k.azur_lane_statistics.services.ClassificationService;
import com.midie2k.azur_lane_statistics.services.dto.ClassificationDTO;
import com.midie2k.azur_lane_statistics.services.errors.ObjectException;
import com.midie2k.azur_lane_statistics.services.filtration.entities.ClassificationCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class ClassificationResource {
    private final Logger log = LoggerFactory.getLogger(ShipClassResource.class);

    private final ClassificationService classificationService;
    private final ClassificationQueryService classificationQueryService;

    public ClassificationResource(ClassificationService classificationService, ClassificationQueryService classificationQueryService) {
        this.classificationService = classificationService;
        this.classificationQueryService = classificationQueryService;
    }

    @PostMapping("/classification")
    public ResponseEntity<ClassificationDTO> create(@RequestBody ClassificationDTO dto) {
        log.debug("Request to create classification: {}", dto);
        if (dto.getId() != null) {
            throw new ObjectException("New classification cannot already have an ID", ErrorList.ID_IS_GIVEN);
        }
        ClassificationDTO saved = classificationService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/classification")
    public ResponseEntity<ClassificationDTO> update(@RequestBody ClassificationDTO dto) {
        log.debug("Request to update classification: {}", dto);
        if (dto.getId() == null) {
            throw new ObjectException("Cannot update classification without ID", ErrorList.ID_IS_MISSING);
        }
        ClassificationDTO updated = classificationService.save(dto);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/classification")
    public ResponseEntity<Page<ClassificationDTO>> getAll(ClassificationCriteria criteria, Pageable page){
        log.debug("Request to get all classifications by criteria: {}", criteria);
        Page<ClassificationDTO> classificationDTOS = classificationQueryService.getAllPage(criteria, page);
        return ResponseEntity.ok(classificationDTOS);
    }

    @GetMapping("/classification/{id}")
    public ResponseEntity<ClassificationDTO> getById(@PathVariable Long id){
        log.debug("Request to get classification by id : {}", id);
        ClassificationDTO classificationDTO = classificationQueryService.getById(id);
        return ResponseEntity.ok(classificationDTO);
    }

    @DeleteMapping("/classification/{id}")
    public void delete(@PathVariable Long id){
        log.debug("Request to delete classification by id : {}", id);
        classificationService.delete(id);
    }
}
