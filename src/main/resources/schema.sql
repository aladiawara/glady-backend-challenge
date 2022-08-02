drop table if exists compagny CASCADE;
drop table if exists deposit CASCADE;
drop table if exists _users CASCADE;
create table compagny (
      id bigint auto_increment not null,
      balance double not null,
      compagny_name varchar(255),
      siret varchar(255),
      social_reason varchar(255),
      primary key (id)
);
create table _users (
    id bigint auto_increment not null,
    address varchar(255),
    date_of_birth date,
    firstname varchar(255),
    lastname varchar(255),
    position varchar(255),
    compagny_id bigint,
    primary key (id)
);
create table deposit (
     id bigint auto_increment not null,
     amount double not null,
     end_date timestamp,
     start_date timestamp,
     type varchar(10),
     user_id bigint,
     primary key (id)
);
create table transactions (
     id bigint auto_increment not null,
     amount double not null,
     transaction_date timestamp,
     transaction_type varchar(10),
     user_id bigint,
     primary key (id)
);
alter table _users
       add constraint FK3hhb9h0uk3q19v3o1xtnk4oh6
    foreign key (compagny_id)
    references compagny;
alter table deposit
    add constraint FK70e6syr06960crumysjm6la78
        foreign key (user_id)
            references _users;
alter table transactions
    add constraint FKTransactions_users_id
        foreign key (user_id)
            references _users;