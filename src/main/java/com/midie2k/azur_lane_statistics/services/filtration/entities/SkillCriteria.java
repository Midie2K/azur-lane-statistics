package com.midie2k.azur_lane_statistics.services.filtration.entities;

import com.midie2k.azur_lane_statistics.data.entities.Skill;

public class SkillCriteria implements Criteria<Skill>{

    private Long shipId;


    public Long getShipId() {
        return shipId;
    }

    public void setShipId(Long skipId) {
        this.shipId = skipId;
    }

    @Override
    public Criteria<Skill> copy() {
        SkillCriteria copy = new SkillCriteria();
        copy.shipId = this.shipId;
        return copy;
    }
}
