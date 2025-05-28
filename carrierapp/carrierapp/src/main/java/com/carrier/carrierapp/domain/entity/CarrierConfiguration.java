package com.carrier.carrierapp.domain.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "carrier_configurations")
public class CarrierConfiguration extends  BaseEntity {
    @Column(nullable = false)
    private int carrierMaxDesi;

    @Column(nullable = false)
    private int carrierMinDesi;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal carrierCost;

    public CarrierConfiguration() {
    }

    // Carrier ilişkisi
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carrier_id", nullable = false)
    @JsonBackReference
    private Carrier carrier;

    public int getCarrierMaxDesi() {
        return carrierMaxDesi;
    }

    public void setCarrierMaxDesi(int carrierMaxDesi) {
        this.carrierMaxDesi = carrierMaxDesi;
    }

    public int getCarrierMinDesi() {
        return carrierMinDesi;
    }

    public void setCarrierMinDesi(int carrierMinDesi) {
        this.carrierMinDesi = carrierMinDesi;
    }

    public BigDecimal getCarrierCost() {
        return carrierCost;
    }

    public void setCarrierCost(BigDecimal carrierCost) {
        this.carrierCost = carrierCost;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }
}
