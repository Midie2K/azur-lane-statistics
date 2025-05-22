package com.midie2k.azur_lane_statistics.data.entities;

import com.midie2k.azur_lane_statistics.data.enumerate.Armor;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fraction_id", insertable = false, updatable = false)
    private Long fractionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classification_id")
    private Classification classification;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classification_id", insertable = false, updatable = false)
    private Long classificationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ship_class_id")
    private ShipClass shipClass;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ship_class_id", insertable = false, updatable = false)
    private Long shipClassId;

    @Column(name = "armored")
    @Enumerated(value = EnumType.STRING)
    private Armor armor;

    @Column(name = "build_time")
    private String buildTime;

    public Ship() {
    }

    public Ship(Long id, String name, Fraction fraction, Long fractionId,
                Classification classification, Long classificationId,
                ShipClass shipClass, Long shipClassId, Armor armor, String buildTime) {
        this.id = id;
        this.name = name;
        this.fraction = fraction;
        this.fractionId = fractionId;
        this.classification = classification;
        this.classificationId = classificationId;
        this.shipClass = shipClass;
        this.shipClassId = shipClassId;
        this.armor = armor;
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

    public String getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(String buildTime) {
        this.buildTime = buildTime;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship = (Ship) o;
        return Objects.equals(id, ship.id) && Objects.equals(name, ship.name) && Objects.equals(fraction, ship.fraction) && Objects.equals(fractionId, ship.fractionId) && Objects.equals(classification, ship.classification) && Objects.equals(classificationId, ship.classificationId) && Objects.equals(shipClass, ship.shipClass) && Objects.equals(shipClassId, ship.shipClassId) && armor == ship.armor && Objects.equals(buildTime, ship.buildTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, fraction, fractionId, classification, classificationId, shipClass, shipClassId, armor, buildTime);
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
                ", armor=" + armor +
                ", buildTime='" + buildTime + '\'' +
                '}';
    }
}
