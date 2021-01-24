create table s_count (
  id                bigserial,
  push              int not null,
  primary key (id)
);

insert into s_count (push)
values (0);