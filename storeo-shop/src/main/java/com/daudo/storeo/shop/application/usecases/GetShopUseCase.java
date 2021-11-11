package com.daudo.storeo.shop.application.usecases;

import com.daudo.storeo.shop.domain.shop.domains.Shop;
import io.smallrye.mutiny.Uni;


public interface GetShopUseCase {
    Uni<Shop> getShop(String id);
}
