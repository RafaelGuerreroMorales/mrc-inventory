package com.micro.spv.inventory.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.micro.spv.inventory.entities.GarmentCategoryEntity;
import com.micro.spv.inventory.entities.GarmentComplementaryEntity;
import com.micro.spv.inventory.entities.GarmentEntity;
import com.micro.spv.inventory.entities.GarmentPriceEntity;

@Repository
public class GarmentRepository extends BaseRepository {
    
    public List<GarmentEntity> findAllGarments(){
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(GarmentEntity.class);
        var rootQuery = criteriaQuery.from(GarmentEntity.class);

        criteriaQuery.select(rootQuery);

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public List<GarmentEntity> findGarmentByIds(short... idGarment){
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(GarmentEntity.class);
        var rootQuery = criteriaQuery.from(GarmentEntity.class);

        String stringIdGarment = "";
        for(short item: idGarment)
            stringIdGarment += String.format("," + item);
        
        stringIdGarment.replaceFirst(stringIdGarment, ",");
        var predicate = rootQuery.get("identityGarment").in(stringIdGarment);

        criteriaQuery.where(predicate);
        return entityManager.createQuery(criteriaQuery).getResultList();

    }

    public GarmentCategoryEntity findGarmentCategoryByIdentity(short identityCategory){
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(GarmentCategoryEntity.class);
        var rootQuery = criteriaQuery.from(GarmentCategoryEntity.class);

        var predicate = criteriaBuilder.equal(rootQuery.get("identity_category"), identityCategory);

        criteriaQuery.where(predicate);
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    public List<GarmentComplementaryEntity> findGarmentComplementaryByIdCategory(short idCategory){
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(GarmentComplementaryEntity.class);
        var rootQuery = criteriaQuery.from(GarmentComplementaryEntity.class);

        var predicate = criteriaBuilder.equal(rootQuery.get("identityCategory"), idCategory);

        criteriaQuery.where(predicate);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public List<GarmentPriceEntity> findGarmentPriceByIdentityService(short identityService){
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(GarmentPriceEntity.class);
        var rootQuery = criteriaQuery.from(GarmentPriceEntity.class);

        var predicate = criteriaBuilder.equal(rootQuery.get("identityService"), identityService);

        criteriaQuery.where(predicate);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
