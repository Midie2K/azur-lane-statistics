package com.midie2k.azur_lane_statistics.services.dto;

import com.midie2k.azur_lane_statistics.data.enumerate.Armor;

import java.util.Objects;

/**
 * DTO for entity {@link com.midie2k.azur_lane_statistics.data.entities.Ship}
 */
public class ShipDTO {

    private Long id;
    private String name;

    private Long fractionId;
    private String fractionIndex;
    private String fractionName;

    private Long classificationId;
    private String classificationIndex;
    private String classificationName;

    private Long shipClassId;
    private String shipClassIndex;
    private String shipClassName;

    private Armor armor;

    private Long eventId;
    private String eventName;

    private String buildTime;

    public ShipDTO() {
    }

    public ShipDTO(Long id, String name, Long fractionId, String fractionIndex, String fractionName, Long classificationId, String classificationIndex, String classificationName, Long shipClassId, String shipClassIndex, String shipClassName, Armor armor, Long eventId, String eventName, String buildTime) {
        this.id = id;
        this.name = name;
        this.fractionId = fractionId;
        this.fractionIndex = fractionIndex;
        this.fractionName = fractionName;
        this.classificationId = classificationId;
        this.classificationIndex = classificationIndex;
        this.classificationName = classificationName;
        this.shipClassId = shipClassId;
        this.shipClassIndex = shipClassIndex;
        this.shipClassName = shipClassName;
        this.armor = armor;
        this.eventId = eventId;
        this.eventName = eventName;
        this.buildTime = buildTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFractionId() {
        return fractionId;
    }

    public void setFractionId(Long fractionId) {
        this.fractionId = fractionId;
    }

    public String getFractionIndex() {
        return fractionIndex;
    }

    public void setFractionIndex(String fractionIndex) {
        this.fractionIndex = fractionIndex;
    }

    public String getFractionName() {
        return fractionName;
    }

    public void setFractionName(String fractionName) {
        this.fractionName = fractionName;
    }

    public Long getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(Long classificationId) {
        this.classificationId = classificationId;
    }

    public String getClassificationIndex() {
        return classificationIndex;
    }

    public void setClassificationIndex(String classificationIndex) {
        this.classificationIndex = classificationIndex;
    }

    public String getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName;
    }

    public Long getShipClassId() {
        return shipClassId;
    }

    public void setShipClassId(Long shipClassId) {
        this.shipClassId = shipClassId;
    }

    public String getShipClassIndex() {
        return shipClassIndex;
    }

    public void setShipClassIndex(String shipClassIndex) {
        this.shipClassIndex = shipClassIndex;
    }

    public String getShipClassName() {
        return shipClassName;
    }

    public void setShipClassName(String shipClassName) {
        this.shipClassName = shipClassName;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public String getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(String buildTime) {
        this.buildTime = buildTime;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ShipDTO shipDTO = (ShipDTO) o;
        return Objects.equals(id, shipDTO.id) && Objects.equals(name, shipDTO.name) && Objects.equals(fractionId, shipDTO.fractionId) && Objects.equals(fractionIndex, shipDTO.fractionIndex) && Objects.equals(fractionName, shipDTO.fractionName) && Objects.equals(classificationId, shipDTO.classificationId) && Objects.equals(classificationIndex, shipDTO.classificationIndex) && Objects.equals(classificationName, shipDTO.classificationName) && Objects.equals(shipClassId, shipDTO.shipClassId) && Objects.equals(shipClassIndex, shipDTO.shipClassIndex) && Objects.equals(shipClassName, shipDTO.shipClassName) && armor == shipDTO.armor && Objects.equals(eventId, shipDTO.eventId) && Objects.equals(eventName, shipDTO.eventName) && Objects.equals(buildTime, shipDTO.buildTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, fractionId, fractionIndex, fractionName, classificationId, classificationIndex, classificationName, shipClassId, shipClassIndex, shipClassName, armor, eventId, eventName, buildTime);
    }

    @Override
    public String toString() {
        return "ShipDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fractionId=" + fractionId +
                ", fractionIndex='" + fractionIndex + '\'' +
                ", fractionName='" + fractionName + '\'' +
                ", classificationId=" + classificationId +
                ", classificationIndex='" + classificationIndex + '\'' +
                ", classificationName='" + classificationName + '\'' +
                ", shipClassId=" + shipClassId +
                ", shipClassIndex='" + shipClassIndex + '\'' +
                ", shipClassName='" + shipClassName + '\'' +
                ", armor=" + armor +
                ", eventId=" + eventId +
                ", eventName='" + eventName + '\'' +
                ", buildTime='" + buildTime + '\'' +
                '}';
    }
}
