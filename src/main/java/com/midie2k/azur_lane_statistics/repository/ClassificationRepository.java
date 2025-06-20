package com.midie2k.azur_lane_statistics.repository;

import com.midie2k.azur_lane_statistics.data.entities.Classification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassificationRepository extends JpaRepository<Classification, Long>, JpaSpecificationExecutor<Classification> {

    Classification getById(Long id);
}
