--liquibase formatted sql
--changeset Maksim Komarov:1
create table meal (
    id uuid not null constraint pk_meal primary key,
    price int,
    name text,
    amount int,
    prep_time time
);

--changeset Maksim Komarov:2
insert into meal (id, price, name, amount, prep_time) values
('2085c74e-0b44-4404-8bd4-7cf285dfff92', 1500, 'caesar salad', 50, '00:30:00'),
('f57f5123-c071-4a5a-ae71-d7dbaac645ce', 600, 'apple fresh juice', 30, '00:07:00'),
('fa5966a5-4ff8-4bf7-bcdc-49c723e4fa29', 1200, 'pasta carbonara', 40, '00:25:00');