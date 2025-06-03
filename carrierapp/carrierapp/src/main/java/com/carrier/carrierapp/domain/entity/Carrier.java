package com.carrier.carrierapp.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Carrier extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String carrierName;

    private boolean carriersActive;

    private int carrierPlusDesiCost;




    @OneToMany(mappedBy = "carrier", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Order> orders = new HashSet<>();

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Set<CarrierConfiguration> getCarrierConfigurations() {
        return carrierConfigurations;
    }

    public void setCarrierConfigurations(Set<CarrierConfiguration> carrierConfigurations) {
        this.carrierConfigurations = carrierConfigurations;
    }

    @OneToMany(mappedBy = "carrier", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<CarrierConfiguration> carrierConfigurations = new HashSet<>();


    public String getCarrierName() {
        return carrierName;
    }

    public Carrier() {}

    public Carrier(String carrierName, int carrierPlusDesiCost, boolean carriersActive) {
        this.carrierName = carrierName;
        this.carrierPlusDesiCost = carrierPlusDesiCost;
        this.carriersActive = carriersActive;
    }


    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public boolean isCarriersActive() {
        return carriersActive;
    }

    public void setCarriersActive(boolean carriersActive) {
        this.carriersActive = carriersActive;
    }

    public int getCarrierPlusDesiCost() {
        return carrierPlusDesiCost;
    }

    public void setCarrierPlusDesiCost(int carrierPlusDesiCost) {
        this.carrierPlusDesiCost = carrierPlusDesiCost;
    }
}
