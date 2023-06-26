package com.micro.spv.inventory.repositories;

import java.util.List;

import org.springframework.stereotype.Repository; 

import com.micro.spv.inventory.entities.GarmentComplementaryGroupEntity;
import com.micro.spv.inventory.entities.GarmentGroupDetailEntity;
import com.micro.spv.inventory.entities.GarmentGroupEntity;
import com.micro.spv.inventory.entities.GarmentGroupPriceEntity;

@Repository
public class GarmentGroupRepository extends BaseRepository {
    
    public List<GarmentGroupEntity> findAllGarmentGroupBy(List<Short> identityGroup){
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(GarmentGroupEntity.class);
        var rootQuery = criteriaQuery.from(GarmentGroupEntity.class);

        var predicate = rootQuery.get("identityGroupGarment").in(identityGroup);

        criteriaQuery.where(predicate);
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

    public List<GarmentGroupPriceEntity> findGarmentGroupPrice(short idservice){
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(GarmentGroupPriceEntity.class);
        var rootQuery = criteriaQuery.from(GarmentGroupPriceEntity.class);
        
        var predicate = criteriaBuilder.equal(rootQuery.get("identityService"), idservice);

        criteriaQuery.where(predicate);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
