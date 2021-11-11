package com.daudo.storeo.shop.application.services;

import com.daudo.storeo.lib.web.response.ListData;
import com.daudo.storeo.shop.domain.shop.domains.Shop;
import com.daudo.storeo.shop.domain.shop.domains.ShopDetail;
import com.daudo.storeo.shop.domain.shop.domains.ShopExistsException;
import com.daudo.storeo.shop.domain.shop.domains.ShopNotFoundException;
import com.daudo.storeo.shop.application.ports.*;
import com.daudo.storeo.shop.application.usecases.*;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ShopService implements CreateShopUseCase, DeleteShopUseCase,
    UpdateShopDetailUseCase, GetShopUseCase, GetShopListUseCase {

    @Inject
    CreateShopPort createShopPort;

    @Inject
    DeleteShopPort deleteShopPort;

    @Inject
    UpdateShopDetailPort updateShopDetailPort;

    @Inject
    GetShopPort getShopPort;

    @Inject
    GetShopListPort getShopListPort;

    @Inject
    GetShopByNamePort getShopByNamePort;

    @Override
    public Uni<Shop> createShop(Shop shop) {
        return getShopByNamePort.getShopByName(shop.getName())
            .onItem().ifNotNull().call(() -> Uni.createFrom().failure(new ShopExistsException(shop.getName())))
            .onItem().ifNull().switchTo(createShopPort.createShop(shop));
    }

    @Override
    public Uni<String> deleteShop(String id) {
        return getShopPort.getShop(id)
            .onItem().ifNotNull().transformToUni(shop -> deleteShopPort.deleteShop(shop.getId()))
            .onItem().ifNull().failWith(new ShopNotFoundException(id));
    }

    @Override
    public Uni<Shop> updateShopDetail(String id, ShopDetail detail) {
        return getShopByNamePort.getShopByName(detail.getName())
            .onItem().ifNotNull().call(existShop ->
                !existShop.getId().equals(id) ? Uni.createFrom().failure(new ShopExistsException(detail.getName())) :
                    getShopPort.getShop(id)
                        .onItem().ifNotNull().transformToUni(shop -> updateShopDetailPort.updateShopDetail(id, detail))
                        .onItem().ifNull().failWith(new ShopNotFoundException(id))
            )
            .onItem().ifNull().switchTo(
                getShopPort.getShop(id)
                    .onItem().ifNotNull().transformToUni(shop -> updateShopDetailPort.updateShopDetail(id, detail))
                    .onItem().ifNull().failWith(new ShopNotFoundException(id))
            );

    }

    @Override
    public Uni<ListData<Shop>> getShopList(int size, int page) {
        return getShopListPort.getShopList(size, page);
    }

    @Override
    public Uni<Shop> getShop(String id) {
        return getShopPort.getShop(id);
    }

}
