create table counter (
  id                bigserial,
  quantity     int not null,
  primary key (id)
);

insert into counter (quantity)
values (0);