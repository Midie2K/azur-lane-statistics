package com.midie2k.azur_lane_statistics.services.implementation;

import com.midie2k.azur_lane_statistics.data.entities.Fraction;
import com.midie2k.azur_lane_statistics.repository.FractionRepository;
import com.midie2k.azur_lane_statistics.services.FractionService;
import com.midie2k.azur_lane_statistics.services.dto.FractionDTO;
import com.midie2k.azur_lane_statistics.services.mapper.FractionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FractionServiceImpl implements FractionService {
    private final Logger log = LoggerFactory.getLogger(FractionServiceImpl.class);
    private final FractionRepository fractionRepository;
    private final FractionMapper fractionMapper;

    public FractionServiceImpl(FractionRepository fractionRepository, FractionMapper fractionMapper) {
        this.fractionRepository = fractionRepository;
        this.fractionMapper = fractionMapper;
    }

    @Override
    public FractionDTO save(FractionDTO fractionDTO) {
        log.debug("Save entity by dto :{}", fractionDTO);
        Fraction fraction = fractionMapper.toEntity(fractionDTO);
        FractionDTO result = fractionMapper.toDTO(fractionRepository.save(fraction));
        return result;
    }

    @Override
    public void delete(Long id) {
        log.debug("Delete entity by id: {}", id);
        fractionRepository.deleteById(id);
    }
}
