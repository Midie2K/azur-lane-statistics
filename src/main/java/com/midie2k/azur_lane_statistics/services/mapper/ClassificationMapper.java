package com.midie2k.azur_lane_statistics.services.mapper;

import com.midie2k.azur_lane_statistics.data.entities.Classification;
import com.midie2k.azur_lane_statistics.services.dto.ClassificationDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClassificationMapper {

    ClassificationDTO toDTO(Classification classification);

    List<ClassificationDTO> toDTO(List<Classification> classificationList);

    Classification toEntity(ClassificationDTO dto);

    List<Classification> toEntity(List<ClassificationDTO> dtoList);
}
