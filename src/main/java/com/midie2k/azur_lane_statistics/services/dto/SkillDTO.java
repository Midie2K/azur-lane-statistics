package com.midie2k.azur_lane_statistics.services.dto;

import com.midie2k.azur_lane_statistics.data.enumerate.SkillType;

import java.util.Objects;

public class SkillDTO {
    private Long id;

    private SkillType skillType;

    private String name;

    private String description;

    private Long shipId;

    public SkillDTO() {
    }

    public SkillDTO(Long id, SkillType skillType, String name, String description, Long shipId) {
        this.id = id;
        this.skillType = skillType;
        this.name = name;
        this.description = description;
        this.shipId = shipId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SkillType getSkillType() {
        return skillType;
    }

    public void setSkillType(SkillType skillType) {
        this.skillType = skillType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getShipId() {
        return shipId;
    }

    public void setShipId(Long shipId) {
        this.shipId = shipId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SkillDTO skillDTO = (SkillDTO) o;
        return Objects.equals(id, skillDTO.id) && skillType == skillDTO.skillType && Objects.equals(name, skillDTO.name) && Objects.equals(description, skillDTO.description) && Objects.equals(shipId, skillDTO.shipId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, skillType, name, description, shipId);
    }

    @Override
    public String toString() {
        return "SkillDTO{" +
                "id=" + id +
                ", skillType=" + skillType +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", shipId=" + shipId +
                '}';
    }
}
