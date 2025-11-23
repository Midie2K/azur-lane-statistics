package com.midie2k.azur_lane_statistics.services.implementation;

import com.midie2k.azur_lane_statistics.data.entities.Event;
import com.midie2k.azur_lane_statistics.repository.EventRepository;
import com.midie2k.azur_lane_statistics.services.EventService;
import com.midie2k.azur_lane_statistics.services.dto.EventDTO;
import com.midie2k.azur_lane_statistics.services.mapper.EventMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {
    private final Logger log = LoggerFactory.getLogger(EventServiceImpl.class);
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    public EventServiceImpl(EventRepository eventRepository, EventMapper eventMapper) {
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
    }

    @Override
    public EventDTO save(EventDTO dto) {
        log.debug("Save event by dto: {}", dto);
        Event event = eventRepository.save(eventMapper.toEntity(dto));
        return eventMapper.toDTO(event);
    }

    @Override
    public void delete(Long id) {
        log.debug("Delete event by id : {}", id);
        eventRepository.deleteById(id);
    }
}
