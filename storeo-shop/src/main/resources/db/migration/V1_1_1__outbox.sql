CREATE TABLE storeo_outbox
(
    id                 UUID         NOT NULL,
    aggregatetype      VARCHAR(255) NOT NULL,
    aggregateid        VARCHAR(255) NOT NULL,
    type               VARCHAR(255) NOT NULL,
    timestamp          TIMESTAMP WITHOUT TIME ZONE,
    payload            TEXT,
    tracingspancontext VARCHAR(256),
    CONSTRAINT pk_storeo_outbox PRIMARY KEY (id)
);
