create table order (
    id uuid not null constraint pk_order primary key,
    start_time time,
    client_name text
);