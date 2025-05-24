package com.midie2k.azur_lane_statistics.services.mapper;

import com.midie2k.azur_lane_statistics.data.entities.ShipClass;
import com.midie2k.azur_lane_statistics.services.dto.ShipClassDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShipClassMapper {

    ShipClassDTO toDTO(ShipClass fraction);

    List<ShipClassDTO> toDTO(List<ShipClass> fractionList);

    ShipClass toEntity(ShipClassDTO dto);

    List<ShipClass> toEntity(List<ShipClassDTO> dtoList);
}
