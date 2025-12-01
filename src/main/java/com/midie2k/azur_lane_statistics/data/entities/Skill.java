package com.midie2k.azur_lane_statistics.data.entities;

import com.midie2k.azur_lane_statistics.data.enumerate.SkillType;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private SkillType skillType;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ship_id")
    private Ship ship;

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

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return Objects.equals(id, skill.id) && skillType == skill.skillType && Objects.equals(name, skill.name) && Objects.equals(description, skill.description) && Objects.equals(ship, skill.ship);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, skillType, name, description, ship);
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", skillType=" + skillType +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ship=" + ship +
                '}';
    }
}
