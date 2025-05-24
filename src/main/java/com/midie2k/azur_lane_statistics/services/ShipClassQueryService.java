package com.midie2k.azur_lane_statistics.services;

import com.midie2k.azur_lane_statistics.data.entities.ShipClass;
import com.midie2k.azur_lane_statistics.repository.ShipClassRepository;
import com.midie2k.azur_lane_statistics.services.dto.ShipClassDTO;
import com.midie2k.azur_lane_statistics.services.implementation.ShipClassServiceImpl;
import com.midie2k.azur_lane_statistics.services.mapper.ShipClassMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShipClassQueryService {

    private final Logger log = LoggerFactory.getLogger(ShipClassQueryService.class);
    private final ShipClassRepository shipClassRepository;
    private final ShipClassMapper shipClassMapper;

    public ShipClassQueryService(ShipClassRepository shipClassRepository, ShipClassMapper shipClassMapper) {
        this.shipClassRepository = shipClassRepository;
        this.shipClassMapper = shipClassMapper;
    }

    @Transactional(readOnly = true, isolation = Isolation.READ_UNCOMMITTED)
    public List<ShipClassDTO> getAll(){
        log.debug("Request to get all ship list");
        return shipClassMapper.toDTO(shipClassRepository.findAll());
    }

    @Transactional(readOnly = true, isolation = Isolation.READ_UNCOMMITTED)
    public ShipClassDTO getById(Long id){
        log.debug("Request to get ship class by id : {}", id);
        return shipClassMapper.toDTO(shipClassRepository.getById(id));
    }
}
