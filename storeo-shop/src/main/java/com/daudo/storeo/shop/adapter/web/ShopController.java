package com.daudo.storeo.shop.adapter.web;

import com.daudo.storeo.lib.web.response.ListData;
import com.daudo.storeo.lib.web.response.SuccessResponse;
import com.daudo.storeo.shop.domain.shop.domains.Shop;
import com.daudo.storeo.shop.domain.shop.domains.ShopDetail;
import com.daudo.storeo.shop.application.usecases.*;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ShopController implements ShopResource {

    @Inject
    CreateShopUseCase createShopUseCase;

    @Inject
    UpdateShopDetailUseCase updateShopDetailUseCase;

    @Inject
    DeleteShopUseCase deleteShopUseCase;

    @Inject
    GetShopUseCase getShopUseCase;

    @Inject
    GetShopListUseCase getShopListUseCase;

    @Override
    public Uni<SuccessResponse<Shop>> createShop(Shop shop) {
        return createShopUseCase.createShop(shop).map(SuccessResponse::from);
    }

    @Override
    public Uni<SuccessResponse<Shop>> updateShopDetail(String id, ShopDetail detail) {
        return updateShopDetailUseCase.updateShopDetail(id, detail).map(SuccessResponse::from);
    }

    @Override
    public Uni<SuccessResponse<String>> deleteShop(String id) {
        return deleteShopUseCase.deleteShop(id).map(SuccessResponse::from);
    }

    @Override
    public Uni<SuccessResponse<Shop>> getShop(String id) {
        return getShopUseCase.getShop(id).map(SuccessResponse::from);
    }

    @Override
    public Uni<SuccessResponse<ListData<Shop>>> getShopList(int page, int size) {
        return getShopListUseCase.getShopList(page, size).map(SuccessResponse::from);
    }

}
