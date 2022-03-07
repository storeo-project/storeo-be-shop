package com.daudo.storeo.shop.adapter.event.image;

import com.daudo.storeo.common.image.events.ImageCreatedEvent;
import com.daudo.storeo.common.image.events.ImageDeletedEvent;
import com.daudo.storeo.lib.consumer.DomainHandler;
import com.daudo.storeo.shop.adapter.persistence.entities.ImageEntity;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class ImageEventHandler {

    @Inject
    ImageRepository imageRepository;

    @Inject
    ImageMapper imageMapper;

    @DomainHandler
    @Transactional
    public Uni<ImageEntity> createImage(ImageCreatedEvent event) {
        var imageEntity = imageMapper.toEntity(event.getImage());
        return imageRepository.persistAndFlush(imageEntity);
    }

    @DomainHandler
    @Transactional
    public Uni<String> deleteImage(ImageDeletedEvent event) {
        return imageRepository.deleteById(event.getId());
    }

}
