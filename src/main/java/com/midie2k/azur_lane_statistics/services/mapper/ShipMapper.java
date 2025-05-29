package com.midie2k.azur_lane_statistics.services.mapper;

import com.midie2k.azur_lane_statistics.data.entities.Ship;
import com.midie2k.azur_lane_statistics.services.dto.ShipDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {FractionMapper.class, ClassificationMapper.class, ShipClassMapper.class})
public interface ShipMapper {

    @Mapping(source = "fraction.id", target = "fractionId")
    @Mapping(source = "fraction.name", target = "fractionName")
    @Mapping(source = "fraction.index", target = "fractionIndex")
    @Mapping(source = "classification.id", target = "classificationId")
    @Mapping(source = "classification.name", target = "classificationName")
    @Mapping(source = "classification.index", target = "classificationIndex")
    @Mapping(source = "shipClass.id", target = "shipClassId")
    @Mapping(source = "shipClass.name", target = "shipClassName")
    ShipDTO toDTO(Ship ship);

    List<ShipDTO> toDTO(List<Ship> ships);

    @Mapping(source = "fractionId", target = "fraction.id")
    @Mapping(source = "classificationId", target = "classification.id")
    @Mapping(source = "shipClassId", target = "shipClass.id")
    Ship toEntity(ShipDTO dto);

    List<Ship> toEntity(List<ShipDTO> dtoList);
}
