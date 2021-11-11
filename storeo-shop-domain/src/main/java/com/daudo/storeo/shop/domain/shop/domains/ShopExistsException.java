package com.daudo.storeo.shop.domain.shop.domains;

import com.daudo.storeo.lib.web.exceptions.BusinessException;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ShopExistsException extends BusinessException {
    public ShopExistsException(String name) {
        super(String.format("Shop is already exists (%s)", name));
    }
}
