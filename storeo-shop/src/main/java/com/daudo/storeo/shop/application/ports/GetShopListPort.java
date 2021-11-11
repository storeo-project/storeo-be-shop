package com.daudo.storeo.shop.application.ports;

import com.daudo.storeo.lib.web.response.ListData;
import com.daudo.storeo.shop.domain.shop.domains.Shop;
import io.smallrye.mutiny.Uni;

public interface GetShopListPort {
    Uni<ListData<Shop>> getShopList(int page, int size);
}
