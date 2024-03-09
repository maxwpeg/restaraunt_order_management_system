--liquibase formatted sql
--changeset Maksim Komarov:1
create table user_role (
    user_id uuid constraint fk_user_role_user references "user" (id),
    role varchar
);
