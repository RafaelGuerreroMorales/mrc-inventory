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
@Table(name = "cat_group_garments")
@Entity
@Data
public class GarmentGroupEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identity_group_garment")
    short identityGroupGarment;

    @Column(name = "name_group_garment")
    String groupGarmentName;

    @Column(name = "description")
    String description;
}
