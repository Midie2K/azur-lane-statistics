package com.midie2k.azur_lane_statistics.web.api;

import com.midie2k.azur_lane_statistics.data.enumerate.ErrorList;
import com.midie2k.azur_lane_statistics.services.ShipClassQueryService;
import com.midie2k.azur_lane_statistics.services.ShipClassService;
import com.midie2k.azur_lane_statistics.services.dto.ShipClassDTO;
import com.midie2k.azur_lane_statistics.services.errors.ObjectException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ShipClassResource {

    private final Logger log = LoggerFactory.getLogger(ShipClassResource.class);

    private final ShipClassService shipClassService;
    private final ShipClassQueryService shipClassQueryService;

    public ShipClassResource(ShipClassService shipClassService, ShipClassQueryService shipClassQueryService) {
        this.shipClassService = shipClassService;
        this.shipClassQueryService = shipClassQueryService;
    }

    @PostMapping("/ship-class")
    public ResponseEntity<ShipClassDTO> create(@RequestBody ShipClassDTO dto) {
        log.debug("Request to create ShipClass: {}", dto);
        if (dto.getId() != null) {
            throw new ObjectException("New ShipClass cannot already have an ID", ErrorList.ID_IS_GIVEN);
        }
        ShipClassDTO saved = shipClassService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/ship-class")
    public ResponseEntity<ShipClassDTO> update(@RequestBody ShipClassDTO dto) {
        log.debug("Request to update ShipClass: {}", dto);
        if (dto.getId() == null) {
            throw new ObjectException("Cannot update ShipClass without ID", ErrorList.ID_IS_MISSING);
        }
        ShipClassDTO updated = shipClassService.save(dto);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/ship-class")
    public ResponseEntity<List<ShipClassDTO>> getAll(){
        log.debug("Request to get all ship classes");
        List<ShipClassDTO> shipClassDTOS = shipClassQueryService.getAll();
        return ResponseEntity.ok(shipClassDTOS);
    }

    @GetMapping("/ship-class/{id}")
    public ResponseEntity<ShipClassDTO> getById(@PathVariable Long id){
        log.debug("Request to get ship class by id : {}", id);
        ShipClassDTO shipClassDTO = shipClassQueryService.getById(id);
        return ResponseEntity.ok(shipClassDTO);
    }

    @DeleteMapping("/ship-class/{id}")
    public void delete(@PathVariable Long id){
        log.debug("Request to delete ship class by id : {}", id);
        shipClassService.delete(id);
    }
}
