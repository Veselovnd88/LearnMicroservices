CREATE
    EXTENSION IF NOT EXISTS "uuid-ossp";

create table customer
(
    id         UUID    NOT NULL DEFAULT gen_random_uuid(),
    first_name varchar NOT NULL,
    last_name  varchar NOT NULL,
    email      varchar NOT NULL,
    CONSTRAINT customer_pk PRIMARY KEY(id)
)

GO