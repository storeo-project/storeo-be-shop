package com.daudo.storeo.shop.domain.shop.events;

import com.daudo.storeo.lib.domain.DomainEvent;
import com.daudo.storeo.shop.domain.shop.domains.Shop;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class ShopDetailUpdatedEvent implements DomainEvent {

    private Shop shop;

    @Override
    @JsonIgnore
    public String getId() {
        return shop.getId();
    }

}
