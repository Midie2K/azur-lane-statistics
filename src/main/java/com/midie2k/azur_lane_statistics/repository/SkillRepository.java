package com.midie2k.azur_lane_statistics.repository;

import com.midie2k.azur_lane_statistics.data.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long>, JpaSpecificationExecutor<Skill> {

    @Query("""
            SELECT s FROM Skill s
            WHERE s.ship.id = :id
            """)
    List<Skill> findBySkipId(Long id);
}
