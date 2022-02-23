
CREATE TABLE storeo_image
(
    id          VARCHAR(255) NOT NULL,
    name        VARCHAR(255),
    description VARCHAR(255),
    type        INTEGER,
    created_at  TIMESTAMP WITHOUT TIME ZONE,
    updated_at  TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_storeo_image PRIMARY KEY (id)
);

CREATE TABLE storeo_shop
(
    id          VARCHAR(255) NOT NULL,
    name        VARCHAR(255),
    description VARCHAR(255),
    image_id    VARCHAR(255),
    deleted     BOOLEAN,
    created_at  TIMESTAMP WITHOUT TIME ZONE,
    updated_at  TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_storeo_shop PRIMARY KEY (id)
);

ALTER TABLE storeo_shop
    ADD CONSTRAINT FK_STOREO_SHOP_ON_IMAGE FOREIGN KEY (image_id) REFERENCES storeo_image (id);