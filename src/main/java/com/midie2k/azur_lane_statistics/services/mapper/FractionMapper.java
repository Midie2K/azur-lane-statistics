package com.midie2k.azur_lane_statistics.services.mapper;

import com.midie2k.azur_lane_statistics.data.entities.Fraction;
import com.midie2k.azur_lane_statistics.services.dto.FractionDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FractionMapper {

    FractionDTO toDTO(Fraction fraction);

    List<FractionDTO> toDTO(List<Fraction> fractionList);

    Fraction toEntity(FractionDTO dto);

    List<Fraction> toEntity(List<FractionDTO> dtoList);
}
