-- User schema creation
CREATE TABLE user_table
(
    id              UUID CONSTRAINT user_pkey PRIMARY KEY,
    firstname       VARCHAR,
    lastname        VARCHAR,
    sex             VARCHAR,
    dob             TIMESTAMP,
    email           VARCHAR,
    avatar          VARCHAR,
    created_at      TIMESTAMP,
    created_by      VARCHAR,
    updated_at      TIMESTAMP,
    updated_by      VARCHAR,
    version         TIMESTAMP
);

CREATE TABLE address
(
    id              UUID CONSTRAINT address_pkey PRIMARY KEY,
    street          VARCHAR,
    house_number    VARCHAR,
    zip_code        VARCHAR,
    city            VARCHAR,
    land            VARCHAR,
    user_id         UUID,
    created_at      TIMESTAMP,
    created_by      VARCHAR,
    updated_at      TIMESTAMP,
    updated_by      VARCHAR,
    version         TIMESTAMP,
    CONSTRAINT fk_address_user FOREIGN KEY (user_id) REFERENCES user_table(id)
);