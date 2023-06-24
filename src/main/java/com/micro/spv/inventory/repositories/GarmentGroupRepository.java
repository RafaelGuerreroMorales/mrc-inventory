package com.micro.spv.inventory.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.micro.spv.inventory.entities.GarmentComplementaryGroupEntity;
import com.micro.spv.inventory.entities.GarmentGroupDetailEntity;
import com.micro.spv.inventory.entities.GarmentGroupEntity;

@Repository
public class GarmentGroupRepository extends BaseRepository {
    
    public List<GarmentGroupEntity> findAllGarmentGroup(){
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(GarmentGroupEntity.class);
        var rootQuery = criteriaQuery.from(GarmentGroupEntity.class);

        criteriaQuery.select(rootQuery);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public List<GarmentComplementaryGroupEntity> findComplementaryGroupByIdentityGroup(short identityGroup){
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(GarmentComplementaryGroupEntity.class);
        var rootQuery = criteriaQuery.from(GarmentComplementaryGroupEntity.class);

        var predicate = criteriaBuilder.equal(rootQuery.get("identityGroupGarment"), identityGroup);

        criteriaQuery.where(predicate);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public List<GarmentGroupDetailEntity> findGarmentGroupDatailByIdentityGroup(short identityGroup){
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(GarmentGroupDetailEntity.class);
        var rootQuery = criteriaQuery.from(GarmentGroupDetailEntity.class);

        var predicate = criteriaBuilder.equal(rootQuery.get("identityGarmentGroup"), identityGroup);

        criteriaQuery.where(predicate);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
