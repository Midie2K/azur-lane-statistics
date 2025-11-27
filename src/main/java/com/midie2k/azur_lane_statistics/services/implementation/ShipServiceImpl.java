package com.midie2k.azur_lane_statistics.services.implementation;

import com.midie2k.azur_lane_statistics.data.entities.Ship;
import com.midie2k.azur_lane_statistics.data.enumerate.ErrorList;
import com.midie2k.azur_lane_statistics.repository.ShipRepository;
import com.midie2k.azur_lane_statistics.services.ShipService;
import com.midie2k.azur_lane_statistics.services.dto.ShipDTO;
import com.midie2k.azur_lane_statistics.services.errors.ObjectException;
import com.midie2k.azur_lane_statistics.services.mapper.ShipMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ShipServiceImpl implements ShipService {
    
    private final Logger log = LoggerFactory.getLogger(ShipServiceImpl.class);
    private final ShipRepository shipRepository;
    private final ShipMapper shipMapper;

    public ShipServiceImpl(ShipRepository shipRepository, ShipMapper shipMapper) {
        this.shipRepository = shipRepository;
        this.shipMapper = shipMapper;
    }


    @Override
    public ShipDTO save(ShipDTO dto) {
        log.debug("Request to save ship: {}", dto);
        if(dto.getName() == null || dto.getName().isBlank()){
            throw new ObjectException("Missing ship name", ErrorList.NAME_MISSING);
        }
        Ship ship = shipRepository.save(shipMapper.toEntity(dto));
        return shipMapper.toDTO(ship);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete ship by id : {}", id);
        Ship ship = shipRepository.getReferenceById(id);
        if(ship.getId() == null){
            throw new ObjectException("Ship not found with id : " + id, ErrorList.CLASS_NOT_FOUND);
        }
        shipRepository.deleteById(id);
    }
}
