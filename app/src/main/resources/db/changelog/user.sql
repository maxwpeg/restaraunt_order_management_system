--liquibase formatted sql
--changeset Maksim Komarov:1
create table "user" (
    id uuid not null constraint pk_user primary key,
    password text,
    login text,
    active boolean
);