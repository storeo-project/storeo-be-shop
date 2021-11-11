package com.daudo.storeo.shop.domain.shop.events;

import com.daudo.storeo.lib.domain.DomainEvent;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class ShopDeletedEvent implements DomainEvent {

    private String id;

    @Override
    public String getId() {
        return id;
    }
}
