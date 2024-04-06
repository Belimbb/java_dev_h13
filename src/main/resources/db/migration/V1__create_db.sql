-- create tables --
create table public.client (
    id bigint primary key,
    name varchar(200) null check (length(name) > 3)
);

create table planet (
    id varchar(20) primary key check (id ~ '^[A-Z0-9]+$'),
    name varchar(500) null check (length(name) > 1)
);

create table ticket (
    id bigint primary key,
    created_at timestamp,
    client_id bigint,
    from_planet_id varchar(200) -- Дополнен тип данных
);

-- connect tables --
alter table ticket
    add constraint client_fk
        foreign key(client_id) references client(id),
    add constraint planet_fk
        foreign key(from_planet_id) references planet(id);

-- create sequences --
create sequence client_seq start 1;
create sequence ticket_seq start 1;

-- set sequences --
alter table client alter column id set default nextval('client_seq');
alter table ticket alter column id set default nextval('ticket_seq');
