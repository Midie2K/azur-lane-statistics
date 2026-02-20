package com.midie2k.azur_lane_statistics.web.api;

import com.midie2k.azur_lane_statistics.data.enumerate.ErrorList;
import com.midie2k.azur_lane_statistics.services.ShipQueryService;
import com.midie2k.azur_lane_statistics.services.ShipService;
import com.midie2k.azur_lane_statistics.services.dto.ShipDTO;
import com.midie2k.azur_lane_statistics.services.errors.ObjectException;
import com.midie2k.azur_lane_statistics.services.filtration.entities.ShipCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ShipResource {
    private final Logger log = LoggerFactory.getLogger(ShipResource.class);

    private final ShipQueryService shipQueryService;
    private final ShipService shipService;

    public ShipResource(ShipQueryService shipQueryService, ShipService shipService) {
        this.shipQueryService = shipQueryService;
        this.shipService = shipService;
    }


    @PostMapping("/ship")
    public ResponseEntity<ShipDTO> create(@RequestBody ShipDTO dto) {
        log.debug("Request to create ship: {}", dto);
        if (dto.getId() != null) {
            throw new ObjectException("New ship cannot already have an ID", ErrorList.ID_IS_GIVEN);
        }
        ShipDTO saved = shipService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/ship")
    public ResponseEntity<ShipDTO> update(@RequestBody ShipDTO dto) {
        log.debug("Request to update ship: {}", dto);
        if (dto.getId() == null) {
            throw new ObjectException("Cannot update ship without ID", ErrorList.ID_IS_MISSING);
        }
        ShipDTO updated = shipService.save(dto);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/ship")
    public ResponseEntity<Page<ShipDTO>> getAll(ShipCriteria criteria, Pageable page){
        log.debug("Request to get all ships by criteria: {}", criteria);
        Page<ShipDTO> shipDTOS = shipQueryService.getAllPage(criteria, page);
        return ResponseEntity.ok(shipDTOS);
    }

    @GetMapping("/ship/{id}")
    public ResponseEntity<ShipDTO> getById(@PathVariable Long id){
        log.debug("Request to get ship by id : {}", id);
        ShipDTO shipDTO = shipQueryService.getById(id);
        return ResponseEntity.ok(shipDTO);
    }

    @DeleteMapping("/ship/{id}")
    public void delete(@PathVariable Long id){
        log.debug("Request to delete ship by id : {}", id);
        shipService.delete(id);
    }
}
