package com.daudo.storeo.shop.application.ports;

import com.daudo.storeo.shop.domain.shop.domains.Shop;
import com.daudo.storeo.shop.domain.shop.domains.ShopDetail;
import io.smallrye.mutiny.Uni;

public interface UpdateShopDetailPort {
    Uni<Shop> updateShopDetail(String id, ShopDetail detail);
}
