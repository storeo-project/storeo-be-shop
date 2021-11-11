package com.daudo.storeo.shop.domain.shop.domains;


import com.daudo.storeo.lib.web.exceptions.BusinessException;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ShopNotFoundException extends BusinessException {
    public ShopNotFoundException(String id) {
        super(String.format("Shop not found (%s)", id));
    }
}
