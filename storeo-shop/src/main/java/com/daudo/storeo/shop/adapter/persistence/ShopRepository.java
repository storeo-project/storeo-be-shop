package com.daudo.storeo.shop.adapter.persistence;

import com.daudo.storeo.lib.publisher.PublishEvent;
import com.daudo.storeo.lib.web.response.ListData;
import com.daudo.storeo.shop.domain.shop.domains.Shop;
import com.daudo.storeo.shop.domain.shop.domains.ShopDetail;
import com.daudo.storeo.shop.domain.shop.events.ShopCreatedEvent;
import com.daudo.storeo.shop.domain.shop.events.ShopDeletedEvent;
import com.daudo.storeo.shop.domain.shop.events.ShopDetailUpdatedEvent;
import com.daudo.storeo.shop.adapter.persistence.jpa.JpaShopRepository;
import com.daudo.storeo.shop.application.ports.*;
import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.stream.Collectors;

@ApplicationScoped
public class ShopRepository implements CreateShopPort, DeleteShopPort, GetShopByNamePort,
    GetShopListPort, GetShopPort, UpdateShopDetailPort {

    @Inject
    ShopMapper shopMapper;

    @Inject
    JpaShopRepository jpaShopRepository;

    @PublishEvent(ShopCreatedEvent.class)
    @Override
    public Uni<Shop> createShop(Shop shop) {
        return jpaShopRepository.create(shopMapper.toEntity(shop))
            .map(shopMapper::toDomain);
    }

    @PublishEvent(ShopDeletedEvent.class)
    @Override
    public Uni<String> deleteShop(String id) {
        return jpaShopRepository.deleteById(id);
    }

    @Override
    public Uni<Shop> getShopByName(String name) {
        return jpaShopRepository.findByName(name).map(shopMapper::toDomain);
    }

    @Override
    public Uni<ListData<Shop>> getShopList(int page, int size) {
        return Panache.withTransaction(
            () -> Uni.combine()
                .all()
                .unis(
                    jpaShopRepository.count("deleted", false),
                    jpaShopRepository.find("deleted", Sort.by("updatedAt").descending(), false).page(Page.of(page, size)).list()
                )
                .asTuple()
                .map(
                    objects -> ListData.from(objects.getItem1(), objects.getItem2().stream()
                        .map(shopMapper::toDomain).collect(Collectors.toList()))
                )
        );
    }

    @Override
    public Uni<Shop> getShop(String id) {
        return jpaShopRepository.findById(id).map(shopMapper::toDomain);
    }

    @PublishEvent(ShopDetailUpdatedEvent.class)
    @Override
    public Uni<Shop> updateShopDetail(String id, ShopDetail detail) {
        return jpaShopRepository.updateDetail(id, detail.getName(), detail.getDescription())
            .map(shopMapper::toDomain);
    }
}
