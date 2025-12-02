package com.midie2k.azur_lane_statistics.web.api;

import com.midie2k.azur_lane_statistics.data.enumerate.ErrorList;
import com.midie2k.azur_lane_statistics.services.SkillQueryService;
import com.midie2k.azur_lane_statistics.services.dto.SkillDTO;
import com.midie2k.azur_lane_statistics.services.errors.ObjectException;
import com.midie2k.azur_lane_statistics.services.filtration.entities.SkillCriteria;
import com.midie2k.azur_lane_statistics.services.SkillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SkillResource {
    private final Logger log = LoggerFactory.getLogger(SkillResource.class);
    private final SkillService skillService;
    private final SkillQueryService skillQueryService;

    public SkillResource(SkillService skillService, SkillQueryService skillQueryService) {
        this.skillService = skillService;
        this.skillQueryService = skillQueryService;
    }


    @PostMapping("skill")
    ResponseEntity<SkillDTO> save(@RequestBody SkillDTO skillDTO) {
        log.debug("Request to save skill entity :{}", skillDTO);
        if (skillDTO.getId() != null) {
            throw new ObjectException("Saving entity with id", ErrorList.ID_IS_GIVEN);
        }
        SkillDTO response = skillService.save(skillDTO);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("skill")
    ResponseEntity<SkillDTO> update(@RequestBody SkillDTO skillDTO) {
        log.debug("Request to update skill entity :{}", skillDTO);
        if (skillDTO.getId() == null) {
            throw new ObjectException("Missing id", ErrorList.ID_IS_MISSING);
        }
        SkillDTO response = skillService.save(skillDTO);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("skill")
    ResponseEntity<Page<SkillDTO>> getAllPage(SkillCriteria criteria, Pageable page) {
        log.debug("Request to get page by criteria: {}", criteria);
        Page<SkillDTO> result = skillQueryService.findAllPage(criteria, page);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("skill/all")
    ResponseEntity<List<SkillDTO>> getAll(SkillCriteria criteria) {
        log.debug("Request to get page by criteria: {}", criteria);
        List<SkillDTO> result = skillQueryService.findAll(criteria);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("skill/{id}")
    ResponseEntity<List<SkillDTO>> getBySkipId(@PathVariable("id") Long id) {
        log.debug("Request to get page by skip id: {}", id);
        List<SkillDTO> result = skillQueryService.getByShipId(id);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("skill/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        log.debug("Request to delete by id: {}", id);
        skillService.delete(id);
        return ResponseEntity.ok().build();
    }
}