package com.daudo.storeo.shop.adapter.event.image;

import com.daudo.storeo.shop.adapter.persistence.entities.ImageEntity;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
class ImageRepository implements PanacheRepository<ImageEntity> {

    public Uni<String> deleteById(String id) {
        return delete("where id = ?2", id).map(uid -> id);
    }

}
