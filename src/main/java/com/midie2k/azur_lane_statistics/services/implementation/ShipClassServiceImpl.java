package com.midie2k.azur_lane_statistics.services.implementation;

import com.midie2k.azur_lane_statistics.data.entities.ShipClass;
import com.midie2k.azur_lane_statistics.data.enumerate.ErrorList;
import com.midie2k.azur_lane_statistics.repository.ShipClassRepository;
import com.midie2k.azur_lane_statistics.services.ShipClassService;
import com.midie2k.azur_lane_statistics.services.dto.ShipClassDTO;
import com.midie2k.azur_lane_statistics.services.errors.ObjectException;
import com.midie2k.azur_lane_statistics.services.mapper.ShipClassMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipClassServiceImpl implements ShipClassService {

    private final Logger log = LoggerFactory.getLogger(ShipClassServiceImpl.class);
    private final ShipClassRepository shipClassRepository;
    private final ShipClassMapper shipClassMapper;

    public ShipClassServiceImpl(ShipClassRepository shipClassRepository, ShipClassMapper shipClassMapper) {
        this.shipClassRepository = shipClassRepository;
        this.shipClassMapper = shipClassMapper;
    }

    @Override
    public ShipClassDTO save(ShipClassDTO dto) {
        log.debug("Request to save : {}", dto);
        ShipClass shipClass = shipClassRepository.save(shipClassMapper.toEntity(dto));
        return shipClassMapper.toDTO(shipClass);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete by id : {}", id);
        ShipClass shipClass = shipClassRepository.getReferenceById(id);
        if(shipClass.getId() == null){
            throw new ObjectException("ShipClass not found with id : " + id, ErrorList.CLASS_NOT_FOUND);
        }
        shipClassRepository.deleteById(id);
    }
}
