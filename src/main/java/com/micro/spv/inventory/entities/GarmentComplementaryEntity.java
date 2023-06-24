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
@Table(name = "cat_complementary_garments")
@Entity
@Data
public class GarmentComplementaryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identity_complementary_garments")
    short IdentityComplementaryGarment;

    @Column(name = "identity_category")
    short identityCategory;

    @Column(name = "name_complementary")
    String complementaryName;

    @Column(name = "description")
    String description;

    @Column(name = "price")
    float price;
}
