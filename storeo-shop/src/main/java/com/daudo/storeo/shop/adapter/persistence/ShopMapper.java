package com.daudo.storeo.shop.adapter.persistence;

import com.daudo.storeo.shop.domain.shop.domains.Shop;
import com.daudo.storeo.shop.adapter.persistence.entities.ShopEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "cdi", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ShopMapper {

    Shop toDomain(ShopEntity shopEntity);

    ShopEntity toEntity(Shop shop);
}
