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
@Table(name = "cat_garments")
@Entity
@Data
public class GarmentEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "identity_garment")
    short identityGarment;

    @Column(name = "identity_category_garment")
    short identityCategoryGarment;

    @Column(name = "name_garment")
    String garmentName;

    @Column(name = "description")
    String description;

}
