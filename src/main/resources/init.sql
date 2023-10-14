create table users(
    id  BIGSERIAL PRIMARY KEY,
    firstname character varying(128) NOT NULL,
    lastname character varying(128),
    email character varying(128) NOT NULL UNIQUE,
    hashpassword character varying(128) NOT NULL
);