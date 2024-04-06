-- create tables --
create table public.client (
    id bigint primary key,
    name varchar(200) not null check (length(name) > 3)
);

create table planet (
    id varchar(20) primary key check (id ~ '^[A-Z0-9]+$'),
    name varchar(500) not null check (length(name) > 1)
);

create table ticket (
    id bigint primary key,
    created_at timestamp not null,
    client_id bigint not null,
    from_planet_id varchar(20) not null,
    to_planet_id varchar(20) not null
);

-- connect tables --
alter table ticket
    add constraint fk_ticket_client
        foreign key (client_id) references public.client (id),
    add constraint fk_ticket_from_planet
        foreign key (from_planet_id) references planet (id),
    add constraint fk_ticket_to_planet
        foreign key (to_planet_id) references planet (id);

-- create sequences --
create sequence client_seq start with 1;
create sequence ticket_seq start with 1;

-- set sequences --
alter table public.client alter column id set default nextval('client_seq');
alter table ticket alter column id set default nextval('ticket_seq');

