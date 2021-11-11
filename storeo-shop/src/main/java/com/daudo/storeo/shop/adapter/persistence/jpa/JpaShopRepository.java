package com.daudo.storeo.shop.adapter.persistence.jpa;

import com.daudo.storeo.shop.adapter.persistence.entities.ShopEntity;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import java.util.Date;

@ApplicationScoped
public class JpaShopRepository implements PanacheRepository<ShopEntity> {

    public Uni<ShopEntity> create(ShopEntity shopEntity) {
        shopEntity.setId(null);
        shopEntity.setCreatedAt(new Date());
        shopEntity.setUpdatedAt(new Date());
        return persistAndFlush(shopEntity);
    }

    public Uni<ShopEntity> findByName(String name) {
        return find("name = ?1 and deleted = ?2", name, false).firstResult();
    }

    public Uni<ShopEntity> findById(String id) {
        return find("id", id).firstResult();
    }

    public Uni<String> deleteById(String id) {
        return update("deleted = true, updatedAt = ?1 where id = ?2", new Date(), id)
            .map(uid -> id);
    }

    public Uni<ShopEntity> updateDetail(String id, String name, String description) {
        return find("id", id).firstResult().flatMap(shopEntity -> {
            shopEntity.setName(name);
            shopEntity.setDescription(description);
            shopEntity.setUpdatedAt(new Date());
            return persistAndFlush(shopEntity);
        });
    }
}
