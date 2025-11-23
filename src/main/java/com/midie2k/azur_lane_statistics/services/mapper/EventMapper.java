package com.midie2k.azur_lane_statistics.services.mapper;

import com.midie2k.azur_lane_statistics.data.entities.Event;
import com.midie2k.azur_lane_statistics.services.dto.EventDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {
    EventDTO toDTO(Event event);

    List<EventDTO> toDTO(List<Event> eventList);

    Event toEntity(EventDTO dto);

    List<Event> toEntity(List<EventDTO> dtoList);
}
