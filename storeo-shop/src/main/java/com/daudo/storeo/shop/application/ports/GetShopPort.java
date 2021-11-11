package com.daudo.storeo.shop.application.ports;

import com.daudo.storeo.shop.domain.shop.domains.Shop;
import io.smallrye.mutiny.Uni;

public interface GetShopPort {
    Uni<Shop> getShop(String id);
}
