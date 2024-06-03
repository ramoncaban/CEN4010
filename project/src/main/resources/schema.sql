CREATE SEQUENCE IF NOT EXISTS profiles_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1;

CREATE TABLE IF NOT EXISTS "profiles" (
    "id" bigint DEFAULT nextval('profiles_id_seq') NOT NULL,
    "username" text NOT NULL,
    "password" text NOT NULL,
    "name" text NOT NULL,
    "emailaddress" text NOT NULL,
    "homeaddress" text NOT NULL,
    CONSTRAINT "profiles_pkey" PRIMARY KEY ("id")
);