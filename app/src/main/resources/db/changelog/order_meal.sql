--liquibase formatted sql
--changeset Maksim Komarov:1
create table order_meal (
    order_id uuid not null constraint fk_order_meal_order references "order" (id),
    meal_id uuid not null constraint fk_order_meal_meal references meal (id),
    constraint uq_order_meal_order_id_meal_id unique (order_id, meal_id)
)