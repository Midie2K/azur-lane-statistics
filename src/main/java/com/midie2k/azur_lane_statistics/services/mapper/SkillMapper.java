package com.midie2k.azur_lane_statistics.services.mapper;

import com.midie2k.azur_lane_statistics.data.entities.ShipClass;
import com.midie2k.azur_lane_statistics.data.entities.Skill;
import com.midie2k.azur_lane_statistics.services.dto.ShipClassDTO;
import com.midie2k.azur_lane_statistics.services.dto.SkillDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ShipMapper.class})
public interface SkillMapper {

    @Mapping(source = "ship.id", target = "shipId")
    SkillDTO toDTO(Skill fraction);

    List<SkillDTO> toDTO(List<Skill> fractionList);

    @Mapping(source = "shipId", target = "ship.id")
    Skill toEntity(SkillDTO dto);

    List<Skill> toEntity(List<SkillDTO> dtoList);
}
