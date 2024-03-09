create table user_role (
    user_id uuid constraint fk_user_role_user references "user" (id),
    role varchar
);