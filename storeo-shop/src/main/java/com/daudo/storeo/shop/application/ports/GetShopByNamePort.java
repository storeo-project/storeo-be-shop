package com.daudo.storeo.shop.application.ports;

import com.daudo.storeo.shop.domain.shop.domains.Shop;
import io.smallrye.mutiny.Uni;

public interface GetShopByNamePort {
    Uni<Shop> getShopByName(String name);
}
