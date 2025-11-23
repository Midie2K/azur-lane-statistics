package com.midie2k.azur_lane_statistics.services;

import com.midie2k.azur_lane_statistics.data.entities.Event;
import com.midie2k.azur_lane_statistics.data.entities.Event_;
import com.midie2k.azur_lane_statistics.repository.EventRepository;
import com.midie2k.azur_lane_statistics.services.dto.EventDTO;
import com.midie2k.azur_lane_statistics.services.filtration.entities.EventCriteria;
import com.midie2k.azur_lane_statistics.services.mapper.EventMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventQueryService extends QueryService<Event> {

    private final Logger log = LoggerFactory.getLogger(EventQueryService.class);
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    public EventQueryService(EventRepository eventRepository, EventMapper eventMapper) {
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
    }

    public List<EventDTO> findAll(EventCriteria criteria){
        log.debug("Find all events by criteria : {}", criteria);
        Specification<Event> specification = createSpecification(criteria);
        return eventMapper.toDTO(eventRepository.findAll(specification));
    }

    public Page<EventDTO> findAllPage(EventCriteria criteria, Pageable pageable) {
        log.debug("Find all events by criteria: {}", criteria);
        Specification<Event> specification = createSpecification(criteria);
        return eventRepository.findAll(specification, pageable)
                .map(eventMapper::toDTO);
    }



    private Specification<Event> createSpecification(EventCriteria criteria) {
        Specification<Event> specification = Specification.where(null);

        if (criteria.getId() != null) {
            specification = specification.and(buildRangeSpecification(criteria.getId(), Event_.id));
        }
        if (criteria.getName() != null) {
            specification = specification.and(buildStringSpecification(criteria.getName(), Event_.name));
        }

        return specification;
    }
}
