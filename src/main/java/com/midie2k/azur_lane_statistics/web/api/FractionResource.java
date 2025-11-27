package com.midie2k.azur_lane_statistics.web.api;


import com.midie2k.azur_lane_statistics.data.enumerate.ErrorList;
import com.midie2k.azur_lane_statistics.services.ClassificationQueryService;
import com.midie2k.azur_lane_statistics.services.ClassificationService;
import com.midie2k.azur_lane_statistics.services.FractionQueryService;
import com.midie2k.azur_lane_statistics.services.FractionService;
import com.midie2k.azur_lane_statistics.services.dto.ClassificationDTO;
import com.midie2k.azur_lane_statistics.services.dto.FractionDTO;
import com.midie2k.azur_lane_statistics.services.errors.ObjectException;
import com.midie2k.azur_lane_statistics.services.filtration.entities.ClassificationCriteria;
import com.midie2k.azur_lane_statistics.services.filtration.entities.FractionCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class FractionResource {
    private final Logger log = LoggerFactory.getLogger(ShipClassResource.class);

    private final FractionQueryService fractionQueryService;
    private final FractionService fractionService;

    public FractionResource(FractionQueryService fractionQueryService, FractionService fractionService) {
        this.fractionQueryService = fractionQueryService;
        this.fractionService = fractionService;
    }


    @PostMapping("/fraction")
    public ResponseEntity<FractionDTO> create(@RequestBody FractionDTO dto) {
        log.debug("Request to create fraction: {}", dto);
        if (dto.getId() != null) {
            throw new ObjectException("New fraction cannot already have an ID", ErrorList.ID_IS_GIVEN);
        }
        FractionDTO saved = fractionService.save(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/fraction")
    public ResponseEntity<FractionDTO> update(@RequestBody FractionDTO dto) {
        log.debug("Request to update fraction: {}", dto);
        if (dto.getId() == null) {
            throw new ObjectException("Cannot update fraction without ID", ErrorList.ID_IS_MISSING);
        }
        FractionDTO updated = fractionService.save(dto);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/fraction")
    public ResponseEntity<Page<FractionDTO>> getAll(FractionCriteria criteria, Pageable page){
        log.debug("Request to get all fraction by criteria: {}", criteria);
        Page<FractionDTO> classificationDTOS = fractionQueryService.getAllPage(criteria, page);
        return ResponseEntity.ok(classificationDTOS);
    }

    @GetMapping("/fraction/{id}")
    public ResponseEntity<FractionDTO> getById(@PathVariable Long id){
        log.debug("Request to get fraction by id : {}", id);
        FractionDTO classificationDTO = fractionQueryService.getById(id);
        return ResponseEntity.ok(classificationDTO);
    }

    @DeleteMapping("/fraction/{id}")
    public void delete(@PathVariable Long id){
        log.debug("Request to delete fraction by id : {}", id);
        fractionService.delete(id);
    }

}
