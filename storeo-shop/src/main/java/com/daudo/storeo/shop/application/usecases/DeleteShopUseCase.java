package com.daudo.storeo.shop.application.usecases;

import io.smallrye.mutiny.Uni;

public interface DeleteShopUseCase {
    Uni<String> deleteShop(String id);
}
