package com.micro.spv.inventory.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cat_group_garment_prices")
@Entity
@Data
public class GarmentGroupPriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identity_garment_group")
    short identityGarmentGroup;

    @Column(name = "identity_service")
    short identityService;

    @Column(name = "price")
    float price;

    @Column(name = "description")
    String description;
    
}
