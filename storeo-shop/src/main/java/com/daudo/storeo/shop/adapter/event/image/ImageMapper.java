package com.daudo.storeo.shop.adapter.event.image;

import com.daudo.storeo.common.image.domains.Image;
import com.daudo.storeo.shop.adapter.persistence.entities.ImageEntity;
import com.daudo.storeo.shop.adapter.persistence.entities.ShopEntity;
import com.daudo.storeo.shop.domain.shop.domains.Shop;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "cdi", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ImageMapper {

    Image toDomain(ImageEntity imageEntity);

    ImageEntity toEntity(Image image);

}
