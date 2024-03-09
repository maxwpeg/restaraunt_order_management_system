create table user (
    id uuid not null constraint pk_user primary key,
    password text,
    login text,
    active boolean
);