package com.midie2k.azur_lane_statistics.repository;

import com.midie2k.azur_lane_statistics.data.entities.Fraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FractionRepository extends JpaRepository<Fraction, Long>, JpaSpecificationExecutor<Fraction> {
}
