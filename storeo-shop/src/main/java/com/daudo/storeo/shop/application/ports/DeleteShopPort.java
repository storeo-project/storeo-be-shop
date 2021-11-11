package com.daudo.storeo.shop.application.ports;

import io.smallrye.mutiny.Uni;

public interface DeleteShopPort {
    Uni<String> deleteShop(String id);
}
