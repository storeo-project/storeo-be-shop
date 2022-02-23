package com.daudo.storeo.shop.domain.shop.domains;

import com.daudo.storeo.common.image.domains.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shop {
    private String id;
    private String name;
    private String description;
    private Image image;
    private Boolean deleted;
    private Date createdAt;
    private Date updatedAt;
}
