CREATE TABLE association_value_entry (
  id int8 not null,
  association_key varchar(255) not null,
  association_value varchar(255),
  saga_id varchar(255) not null,
  saga_type varchar(255),
  PRIMARY KEY (id)
);

GO

CREATE TABLE domain_event_entry (
  global_index int8 not null,
  event_identifier varchar(255) not null,
  meta_data oid,
  payload oid not null,
  payload_revision varchar(255),
  payload_type varchar(255) not null,
  time_stamp varchar(255) not null,
  aggregate_identifier varchar(255) not null,
  sequence_number int8 not null,
  type varchar(255),
  PRIMARY KEY (global_index)
);

GO

CREATE TABLE saga_entry (
  saga_id varchar(255) not null,
  revision varchar(255),
  saga_type varchar(255),
  serialized_saga oid,
  PRIMARY KEY (saga_id)
);

GO

CREATE TABLE snapshot_event_entry (
  aggregate_identifier varchar(255) not null,
  sequence_number int8 not null,
  type varchar(255) not null,
  event_identifier varchar(255) not null,
  meta_data oid,
  payload oid not null,
  payload_revision varchar(255),
  payload_type varchar(255) not null,
  time_stamp varchar(255) not null,
  PRIMARY KEY (aggregate_identifier, sequence_number, type)
);

GO

CREATE TABLE token_entry (
  processor_name varchar(255) not null,
  segment int4 not null,
  owner varchar(255),
  timestamp varchar(255) not null,
  token oid,
  token_type varchar(255),
  PRIMARY KEY (processor_name, segment)
);

GO


create index IDXk45eqnxkgd8hpdn6xixn8sgft on association_value_entry (saga_type, association_key, association_value);

GO

create index IDXgv5k1v2mh6frxuy5c0hgbau94 on association_value_entry (saga_id, saga_type);

GO

alter table if exists domain_event_entry
add constraint UK8s1f994p4la2ipb13me2xqm1w unique (aggregate_identifier, sequence_number);

GO

alter table if exists domain_event_entry
add constraint UK_fwe6lsa8bfo6hyas6ud3m8c7x unique (event_identifier);

GO

alter table if exists snapshot_event_entry
add constraint UK_e1uucjseo68gopmnd0vgdl44h unique (event_identifier);

GO