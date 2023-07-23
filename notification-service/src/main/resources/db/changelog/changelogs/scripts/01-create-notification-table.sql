CREATE
    EXTENSION IF NOT EXISTS "uuid-ossp";

GO

create table notification
(
    notification_id   UUID          NOT NULL DEFAULT gen_random_uuid(),
    to_customer_id    UUID          NOT NULL,
    to_customer_email varchar       NOT NULL,
    sender            varchar       NOT NULL,
    message           varchar(1000) NOT NULL,
    sent_at           timestamp              default now(),
    CONSTRAINT notification_pk PRIMARY KEY (notification_id)
)
    GO