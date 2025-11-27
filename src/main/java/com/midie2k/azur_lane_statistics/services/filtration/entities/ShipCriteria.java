package com.midie2k.azur_lane_statistics.services.filtration.entities;

import com.midie2k.azur_lane_statistics.data.entities.Ship;
import com.midie2k.azur_lane_statistics.services.filtration.filters.BigDecimalFilter;
import com.midie2k.azur_lane_statistics.services.filtration.filters.LongFilter;
import com.midie2k.azur_lane_statistics.services.filtration.filters.StringFilter;

import java.util.Objects;

public class ShipCriteria implements Criteria<Ship>{
    private LongFilter id;
    private StringFilter name;

    private Long fractionId;
    private String fractionIndex;
    private String fractionName;

    private Long classificationId;
    private String classificationIndex;
    private String classificationName;

    private Long shipClassId;
    private String shipClassName;

    private BigDecimalFilter hp;
    private BigDecimalFilter fp;
    private BigDecimalFilter trp;
    private BigDecimalFilter avi;
    private BigDecimalFilter aa;
    private BigDecimalFilter rld;
    private BigDecimalFilter evi;
    private BigDecimalFilter spd;
    private BigDecimalFilter acc;
    private BigDecimalFilter lck;
    private BigDecimalFilter asw;
    private String armor;

    private Long eventId;
    private String eventName;

    private String rarity;
    private Long buildTime;


    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getName() {
        return name;
    }

    public void setName(StringFilter name) {
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

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public BigDecimalFilter getHp() {
        return hp;
    }

    public void setHp(BigDecimalFilter hp) {
        this.hp = hp;
    }

    public BigDecimalFilter getFp() {
        return fp;
    }

    public void setFp(BigDecimalFilter fp) {
        this.fp = fp;
    }

    public BigDecimalFilter getTrp() {
        return trp;
    }

    public void setTrp(BigDecimalFilter trp) {
        this.trp = trp;
    }

    public BigDecimalFilter getAvi() {
        return avi;
    }

    public void setAvi(BigDecimalFilter avi) {
        this.avi = avi;
    }

    public BigDecimalFilter getAa() {
        return aa;
    }

    public void setAa(BigDecimalFilter aa) {
        this.aa = aa;
    }

    public BigDecimalFilter getRld() {
        return rld;
    }

    public void setRld(BigDecimalFilter rld) {
        this.rld = rld;
    }

    public BigDecimalFilter getEvi() {
        return evi;
    }

    public void setEvi(BigDecimalFilter evi) {
        this.evi = evi;
    }

    public BigDecimalFilter getSpd() {
        return spd;
    }

    public void setSpd(BigDecimalFilter spd) {
        this.spd = spd;
    }

    public BigDecimalFilter getAcc() {
        return acc;
    }

    public void setAcc(BigDecimalFilter acc) {
        this.acc = acc;
    }

    public BigDecimalFilter getLck() {
        return lck;
    }

    public void setLck(BigDecimalFilter lck) {
        this.lck = lck;
    }

    public BigDecimalFilter getAsw() {
        return asw;
    }

    public void setAsw(BigDecimalFilter asw) {
        this.asw = asw;
    }

    public String getArmor() {
        return armor;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }


    public void setBuildTime(Long buildTime) {
        this.buildTime = buildTime;
    }

    @Override
    public Criteria<Ship> copy() {
        ShipCriteria copy = new ShipCriteria();

        copy.id = this.id == null ? null : this.id.copy();
        copy.name = this.name == null ? null : this.name.copy();

        copy.fractionId = this.fractionId == null ? null : this.fractionId;
        copy.fractionIndex = this.fractionIndex == null ? null : this.fractionIndex;
        copy.fractionName = this.fractionName == null ? null : this.fractionName;

        copy.classificationId = this.classificationId == null ? null : this.classificationId;
        copy.classificationIndex = this.classificationIndex == null ? null : this.classificationIndex;
        copy.classificationName = this.classificationName == null ? null : this.classificationName;

        copy.shipClassId = this.shipClassId == null ? null : this.shipClassId;
        copy.shipClassName = this.shipClassName == null ? null : this.shipClassName;

        copy.hp = this.hp == null ? null : this.hp.copy();
        copy.fp = this.fp == null ? null : this.fp.copy();
        copy.trp = this.trp == null ? null : this.trp.copy();
        copy.avi = this.avi == null ? null : this.avi.copy();
        copy.aa = this.aa == null ? null : this.aa.copy();
        copy.rld = this.rld == null ? null : this.rld.copy();
        copy.evi = this.evi == null ? null : this.evi.copy();
        copy.spd = this.spd == null ? null : this.spd.copy();
        copy.acc = this.acc == null ? null : this.acc.copy();
        copy.lck = this.lck == null ? null : this.lck.copy();
        copy.asw = this.asw == null ? null : this.asw.copy();

        copy.armor = this.armor == null ? null : this.armor;

        copy.eventId = this.eventId == null ? null : this.eventId;
        copy.eventName = this.eventName == null ? null : this.eventName;

        copy.rarity = this.rarity == null ? null : this.rarity;
        copy.buildTime = this.buildTime == null ? null : this.buildTime;

        return copy;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ShipCriteria that = (ShipCriteria) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(fractionId, that.fractionId) && Objects.equals(fractionIndex, that.fractionIndex) && Objects.equals(fractionName, that.fractionName) && Objects.equals(classificationId, that.classificationId) && Objects.equals(classificationIndex, that.classificationIndex) && Objects.equals(classificationName, that.classificationName) && Objects.equals(shipClassId, that.shipClassId) && Objects.equals(shipClassName, that.shipClassName) && Objects.equals(hp, that.hp) && Objects.equals(fp, that.fp) && Objects.equals(trp, that.trp) && Objects.equals(avi, that.avi) && Objects.equals(aa, that.aa) && Objects.equals(rld, that.rld) && Objects.equals(evi, that.evi) && Objects.equals(spd, that.spd) && Objects.equals(acc, that.acc) && Objects.equals(lck, that.lck) && Objects.equals(asw, that.asw) && Objects.equals(armor, that.armor) && Objects.equals(eventId, that.eventId) && Objects.equals(eventName, that.eventName) && Objects.equals(rarity, that.rarity) && Objects.equals(buildTime, that.buildTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, fractionId, fractionIndex, fractionName, classificationId, classificationIndex, classificationName, shipClassId, shipClassName, hp, fp, trp, avi, aa, rld, evi, spd, acc, lck, asw, armor, eventId, eventName, rarity, buildTime);
    }

    @Override
    public String toString() {
        return "ShipCriteria{" +
                "id=" + id +
                ", name=" + name +
                ", fractionId=" + fractionId +
                ", fractionIndex=" + fractionIndex +
                ", fractionName=" + fractionName +
                ", classificationId=" + classificationId +
                ", classificationIndex=" + classificationIndex +
                ", classificationName=" + classificationName +
                ", shipClassId=" + shipClassId +
                ", shipClassName=" + shipClassName +
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
                ", eventName=" + eventName +
                ", rarity=" + rarity +
                ", buildTime=" + buildTime +
                '}';
    }
}
