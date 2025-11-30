package com.midie2k.azur_lane_statistics.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.midie2k.azur_lane_statistics.data.enumerate.Armor;
import com.midie2k.azur_lane_statistics.data.enumerate.Rarity;
import jakarta.persistence.*;
import org.springframework.data.web.JsonPath;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "ships")
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fraction_id")
    private Fraction fraction;

    @Column(name = "fraction_id", insertable = false, updatable = false)
    private Long fractionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classification_id")
    private Classification classification;

    @Column(name = "classification_id", insertable = false, updatable = false)
    private Long classificationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ship_class_id")
    private ShipClass shipClass;

    @Column(name = "ship_class_id", insertable = false, updatable = false)
    private Long shipClassId;

    @Column(name = "hp")
    private BigDecimal hp;

    @Column(name = "fp")
    private BigDecimal fp;

    @Column(name = "trp")
    private BigDecimal trp;

    @Column(name = "avi")
    private BigDecimal avi;

    @Column(name = "aa")
    private BigDecimal aa;

    @Column(name = "rld")
    private BigDecimal rld;

    @Column(name = "evi")
    private BigDecimal evi;

    @Column(name = "spd")
    private BigDecimal spd;

    @Column(name = "acc")
    private BigDecimal acc;

    @Column(name = "lck")
    private BigDecimal lck;

    @Column(name = "asw")
    private BigDecimal asw;

    @Column(name = "armored")
    @Enumerated(value = EnumType.STRING)
    private Armor armor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    private Event event;

    @Column(name = "event_id", insertable = false, updatable = false)
    private Long event_id;

    @Column(name = "rarity")
    @Enumerated(value = EnumType.STRING)
    private Rarity rarity;

    @Column(name = "build_time")
    private Long buildTime;

    @Column(name = "avatar")
    private String avatar;

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

    public Fraction getFraction() {
        return fraction;
    }

    public void setFraction(Fraction fraction) {
        this.fraction = fraction;
    }

    public Long getFractionId() {
        return fractionId;
    }

    public void setFractionId(Long fractionId) {
        this.fractionId = fractionId;
    }

    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    public Long getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(Long classificationId) {
        this.classificationId = classificationId;
    }

    public ShipClass getShipClass() {
        return shipClass;
    }

    public void setShipClass(ShipClass shipClass) {
        this.shipClass = shipClass;
    }

    public Long getShipClassId() {
        return shipClassId;
    }

    public void setShipClassId(Long shipClassId) {
        this.shipClassId = shipClassId;
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

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Long event_id) {
        this.event_id = event_id;
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
        Ship ship = (Ship) o;
        return Objects.equals(id, ship.id) && Objects.equals(name, ship.name) && Objects.equals(fraction, ship.fraction) && Objects.equals(fractionId, ship.fractionId) && Objects.equals(classification, ship.classification) && Objects.equals(classificationId, ship.classificationId) && Objects.equals(shipClass, ship.shipClass) && Objects.equals(shipClassId, ship.shipClassId) && Objects.equals(hp, ship.hp) && Objects.equals(fp, ship.fp) && Objects.equals(trp, ship.trp) && Objects.equals(avi, ship.avi) && Objects.equals(aa, ship.aa) && Objects.equals(rld, ship.rld) && Objects.equals(evi, ship.evi) && Objects.equals(spd, ship.spd) && Objects.equals(acc, ship.acc) && Objects.equals(lck, ship.lck) && Objects.equals(asw, ship.asw) && armor == ship.armor && Objects.equals(event, ship.event) && Objects.equals(event_id, ship.event_id) && rarity == ship.rarity && Objects.equals(buildTime, ship.buildTime) && Objects.equals(avatar, ship.avatar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, fraction, fractionId, classification, classificationId, shipClass, shipClassId, hp, fp, trp, avi, aa, rld, evi, spd, acc, lck, asw, armor, event, event_id, rarity, buildTime, avatar);
    }

    @Override
    public String toString() {
        return "Ship{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fraction=" + fraction +
                ", fractionId=" + fractionId +
                ", classification=" + classification +
                ", classificationId=" + classificationId +
                ", shipClass=" + shipClass +
                ", shipClassId=" + shipClassId +
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
                ", event=" + event +
                ", event_id=" + event_id +
                ", rarity=" + rarity +
                ", buildTime=" + buildTime +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
