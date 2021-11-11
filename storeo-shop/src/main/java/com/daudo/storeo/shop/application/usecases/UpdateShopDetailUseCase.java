package com.daudo.storeo.shop.application.usecases;

import com.daudo.storeo.shop.domain.shop.domains.Shop;
import com.daudo.storeo.shop.domain.shop.domains.ShopDetail;
import io.smallrye.mutiny.Uni;


public interface UpdateShopDetailUseCase {
    Uni<Shop> updateShopDetail(String id, ShopDetail detail);
}
