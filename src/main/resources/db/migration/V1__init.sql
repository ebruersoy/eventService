create sequence seq_event increment by 1 minvalue 1;

create table event(
  id bigint primary key not null ,
  employee_uuid uuid not null ,
  topic varchar not null,
  employee_json jsonb not null ,
  event_date date DEFAULT now()
)
WITH (
OIDS=FALSE
) ;
