--liquibase formatted sql
--changeset Maksim Komarov:1
create table "order" (
    id uuid not null constraint pk_order primary key,
    start_time time,
    client_name text
);