
CREATE TABLE storeo_currency
(
    id         VARCHAR(255) NOT NULL,
    code       VARCHAR(255),
    symbol     VARCHAR(255),
    shop_id    VARCHAR(255),
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_storeo_currency PRIMARY KEY (id)
);

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

CREATE TABLE storeo_order_status
(
    id         VARCHAR(255) NOT NULL,
    name       VARCHAR(255),
    color      VARCHAR(255),
    type       INTEGER,
    index      INTEGER,
    shop_id    VARCHAR(255),
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_storeo_order_status PRIMARY KEY (id)
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

CREATE TABLE storeo_user
(
    id         VARCHAR(255) NOT NULL,
    email      VARCHAR(255),
    name       VARCHAR(255),
    address    VARCHAR(255),
    phone      VARCHAR(255),
    avatar_id  VARCHAR(255),
    deleted    BOOLEAN,
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_storeo_user PRIMARY KEY (id)
);

ALTER TABLE storeo_currency
    ADD CONSTRAINT FK_STOREO_CURRENCY_ON_SHOP FOREIGN KEY (shop_id) REFERENCES storeo_shop (id);

ALTER TABLE storeo_order_status
    ADD CONSTRAINT FK_STOREO_ORDER_STATUS_ON_SHOP FOREIGN KEY (shop_id) REFERENCES storeo_shop (id);

ALTER TABLE storeo_shop
    ADD CONSTRAINT FK_STOREO_SHOP_ON_IMAGE FOREIGN KEY (image_id) REFERENCES storeo_image (id);

ALTER TABLE storeo_user
    ADD CONSTRAINT FK_STOREO_USER_ON_AVATAR FOREIGN KEY (avatar_id) REFERENCES storeo_image (id);
