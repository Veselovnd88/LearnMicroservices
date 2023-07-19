CREATE
    EXTENSION IF NOT EXISTS "uuid-ossp";

GO

create table fraud_check_history
(
    id           UUID      NOT NULL DEFAULT gen_random_uuid(),
    customer_id  int       NOT NULL,
    is_fraudster boolean   NOT NULL,
    created_at   TIMESTAMP NOT NULL DEFAULT now(),
    CONSTRAINT customer_pk PRIMARY KEY (id)
)
    GO
