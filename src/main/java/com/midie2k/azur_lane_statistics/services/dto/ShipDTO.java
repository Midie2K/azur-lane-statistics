package com.midie2k.azur_lane_statistics.services.dto;

import com.midie2k.azur_lane_statistics.data.enumerate.Armor;
import com.midie2k.azur_lane_statistics.data.enumerate.Rarity;

import java.math.BigDecimal;
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
    private String shipClassName;

    private BigDecimal hp;
    private BigDecimal fp;
    private BigDecimal trp;
    private BigDecimal avi;
    private BigDecimal aa;
    private BigDecimal rld;
    private BigDecimal evi;
    private BigDecimal spd;
    private BigDecimal acc;
    private BigDecimal lck;
    private BigDecimal asw;
    private Armor armor;

    private Long eventId;
    private String eventName;

    private Rarity rarity;
    private Long buildTime;

    private String avatar;

    public ShipDTO() {
    }

    public ShipDTO(Long id, String name, Long fractionId, String fractionIndex, String fractionName, Long classificationId, String classificationIndex, String classificationName, Long shipClassId, String shipClassName, BigDecimal hp, BigDecimal fp, BigDecimal trp, BigDecimal avi, BigDecimal aa, BigDecimal rld, BigDecimal evi, BigDecimal spd, BigDecimal acc, BigDecimal lck, BigDecimal asw, Armor armor, Long eventId, String eventName, Rarity rarity, Long buildTime, String avatar) {
        this.id = id;
        this.name = name;
        this.fractionId = fractionId;
        this.fractionIndex = fractionIndex;
        this.fractionName = fractionName;
        this.classificationId = classificationId;
        this.classificationIndex = classificationIndex;
        this.classificationName = classificationName;
        this.shipClassId = shipClassId;
        this.shipClassName = shipClassName;
        this.hp = hp;
        this.fp = fp;
        this.trp = trp;
        this.avi = avi;
        this.aa = aa;
        this.rld = rld;
        this.evi = evi;
        this.spd = spd;
        this.acc = acc;
        this.lck = lck;
        this.asw = asw;
        this.armor = armor;
        this.eventId = eventId;
        this.eventName = eventName;
        this.rarity = rarity;
        this.buildTime = buildTime;
        this.avatar = avatar;
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

    public Long getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(Long buildTime) {
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

    public BigDecimal getHp() {
        return hp;
    }

    public void setHp(BigDecimal hp) {
        this.hp = hp;
    }

    public BigDecimal getFp() {
        return fp;
    }

    public void setFp(BigDecimal fp) {
        this.fp = fp;
    }

    public BigDecimal getTrp() {
        return trp;
    }

    public void setTrp(BigDecimal trp) {
        this.trp = trp;
    }

    public BigDecimal getAvi() {
        return avi;
    }

    public void setAvi(BigDecimal avi) {
        this.avi = avi;
    }

    public BigDecimal getAa() {
        return aa;
    }

    public void setAa(BigDecimal aa) {
        this.aa = aa;
    }

    public BigDecimal getRld() {
        return rld;
    }

    public void setRld(BigDecimal rld) {
        this.rld = rld;
    }

    public BigDecimal getEvi() {
        return evi;
    }

    public void setEvi(BigDecimal evi) {
        this.evi = evi;
    }

    public BigDecimal getSpd() {
        return spd;
    }

    public void setSpd(BigDecimal spd) {
        this.spd = spd;
    }

    public BigDecimal getAcc() {
        return acc;
    }

    public void setAcc(BigDecimal acc) {
        this.acc = acc;
    }

    public BigDecimal getLck() {
        return lck;
    }

    public void setLck(BigDecimal lck) {
        this.lck = lck;
    }

    public BigDecimal getAsw() {
        return asw;
    }

    public void setAsw(BigDecimal asw) {
        this.asw = asw;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ShipDTO shipDTO = (ShipDTO) o;
        return Objects.equals(id, shipDTO.id) && Objects.equals(name, shipDTO.name) && Objects.equals(fractionId, shipDTO.fractionId) && Objects.equals(fractionIndex, shipDTO.fractionIndex) && Objects.equals(fractionName, shipDTO.fractionName) && Objects.equals(classificationId, shipDTO.classificationId) && Objects.equals(classificationIndex, shipDTO.classificationIndex) && Objects.equals(classificationName, shipDTO.classificationName) && Objects.equals(shipClassId, shipDTO.shipClassId) && Objects.equals(shipClassName, shipDTO.shipClassName) && Objects.equals(hp, shipDTO.hp) && Objects.equals(fp, shipDTO.fp) && Objects.equals(trp, shipDTO.trp) && Objects.equals(avi, shipDTO.avi) && Objects.equals(aa, shipDTO.aa) && Objects.equals(rld, shipDTO.rld) && Objects.equals(evi, shipDTO.evi) && Objects.equals(spd, shipDTO.spd) && Objects.equals(acc, shipDTO.acc) && Objects.equals(lck, shipDTO.lck) && Objects.equals(asw, shipDTO.asw) && armor == shipDTO.armor && Objects.equals(eventId, shipDTO.eventId) && Objects.equals(eventName, shipDTO.eventName) && rarity == shipDTO.rarity && Objects.equals(buildTime, shipDTO.buildTime) && Objects.equals(avatar, shipDTO.avatar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, fractionId, fractionIndex, fractionName, classificationId, classificationIndex, classificationName, shipClassId, shipClassName, hp, fp, trp, avi, aa, rld, evi, spd, acc, lck, asw, armor, eventId, eventName, rarity, buildTime, avatar);
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
                ", shipClassName='" + shipClassName + '\'' +
                ", hp=" + hp +
                ", fp=" + fp +
                ", trp=" + trp +
                ", avi=" + avi +
                ", aa=" + aa +
                ", rld=" + rld +
                ", evi=" + evi +
                ", spd=" + spd +
                ", acc=" + acc +
                ", lck=" + lck +
                ", asw=" + asw +
                ", armor=" + armor +
                ", eventId=" + eventId +
                ", eventName='" + eventName + '\'' +
                ", rarity=" + rarity +
                ", buildTime=" + buildTime +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
