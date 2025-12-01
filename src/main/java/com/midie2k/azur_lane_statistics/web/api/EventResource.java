package com.midie2k.azur_lane_statistics.web.api;

import com.midie2k.azur_lane_statistics.data.enumerate.ErrorList;
import com.midie2k.azur_lane_statistics.services.EventQueryService;
import com.midie2k.azur_lane_statistics.services.EventService;
import com.midie2k.azur_lane_statistics.services.dto.EventDTO;
import com.midie2k.azur_lane_statistics.services.errors.ObjectException;
import com.midie2k.azur_lane_statistics.services.filtration.entities.EventCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EventResource {
    private final Logger log = LoggerFactory.getLogger(EventResource.class);
    private final EventService eventService;
    private final EventQueryService queryService;


    public EventResource(EventService eventService, EventQueryService queryService) {
        this.eventService = eventService;
        this.queryService = queryService;
    }

    @PostMapping("event")
    ResponseEntity<EventDTO> save(@RequestBody EventDTO eventDTO){
        log.debug("Request to save event entity :{}", eventDTO);
        if(eventDTO.getId() != null){
            throw new ObjectException("Saving entity with id", ErrorList.ID_IS_GIVEN);
        }
        EventDTO response = eventService.save(eventDTO);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("event")
    ResponseEntity<EventDTO> update(@RequestBody EventDTO eventDTO){
        log.debug("Request to update event entity :{}", eventDTO);
        if(eventDTO.getId() == null){
            throw new ObjectException("Missing id", ErrorList.ID_IS_MISSING);
        }
        EventDTO response = eventService.save(eventDTO);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("event")
    ResponseEntity<Page<EventDTO>> getAllPage(EventCriteria criteria, Pageable page){
        log.debug("Request to get page by criteria: {}", criteria);
        Page<EventDTO> result = queryService.findAllPage(criteria, page);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("event/all")
    ResponseEntity<List<EventDTO>> getAll(EventCriteria criteria){
        log.debug("Request to get page by criteria: {}", criteria);
        List<EventDTO> result = queryService.findAll(criteria);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("event/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") Long id){
        log.debug("Request to delete by id: {}", id);
        eventService.delete(id);
        return ResponseEntity.ok().build();
    }

}
