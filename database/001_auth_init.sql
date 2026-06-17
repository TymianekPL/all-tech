create table if not exists userEntry
(
    id          int primary key auto_increment,
    username    varchar(128) not null,
    displayName varchar(128) null,
    createdAt   timestamp    not null default current_timestamp
);

create table if not exists authMethodClassifications
(
    id   int primary key,
    name varchar(64) not null
);
insert ignore into authMethodClassifications (id, name)
values (0, 'knowledge');
insert ignore into authMethodClassifications (id, name)
values (1, 'possession');
create table if not exists authMethodFactor
(
    id   int primary key,
    name varchar(64) not null
);
insert ignore into authMethodFactor (id, name)
values (0, 'primary');
insert ignore into authMethodFactor (id, name)
values (1, 'secondary');
insert ignore into authMethodFactor (id, name)
values (2, 'both');
insert ignore into authMethodFactor (id, name)
values (3, 'passthrough');
insert ignore into authMethodFactor (id, name)
values (4, 'supplemental');

create table if not exists authMethodType
(
    id               int primary key,
    name             varchar(64) not null,
    classificationId int         not null,
    canPrimary       boolean     not null default false,
    canSecondary     boolean     not null default false,
    canPassthrough   boolean     not null default false,
    canSupplemental  boolean     not null default false
);
insert ignore into authMethodType (id, name, classificationId, canPrimary, canSecondary, canPassthrough)
values (0, 'password', 0, true, true, false);
insert ignore into authMethodType (id, name, classificationId, canPrimary, canSecondary, canPassthrough)
values (1, 'pin', 0, true, true, false);
insert ignore into authMethodType (id, name, classificationId, canPrimary, canSecondary, canPassthrough)
values (2, 'ssh', 1, true, true, true);
insert ignore into authMethodType (id, name, classificationId, canPrimary, canSecondary, canPassthrough)
values (3, 'totp', 1, false, true, false);

create table if not exists authMethod
(
    id         int primary key auto_increment,
    name       varchar(72) not null,
    methodId   int         not null,
    credential text        not null,
    factorId   int         not null,
    userId     int         not null,
    createdAt  timestamp   not null default current_timestamp,
    updatedAt  timestamp            default null on update current_timestamp,
    lastUsedAt timestamp   null,
    enabled    boolean     not null default true
);

alter table userEntry
    add unique key uUserEntryUsername (username);
alter table authMethodClassifications
    add unique key uAuthMethodClassificationsName (name);
alter table authMethodType
    add unique key uAuthMethodTypeName (name);
alter table authMethodFactor
    add unique key uAuthMethodFactorName (name);

alter table authMethodType
    add constraint fkAuthMethodTypeClassification foreign key (classificationId) references authMethodClassifications (id);
alter table authMethod
    add constraint fkAuthMethodUser foreign key (userId) references userEntry (id) on delete cascade;
alter table authMethod
    add constraint fkAuthMethodMethod foreign key (methodId) references authMethodType (id) on delete restrict;
alter table authMethod
    add constraint fkAuthMethodFactor foreign key (factorId) references authMethodFactor (id) on delete restrict;

alter table authMethod
    add key idx_authMethodUserId (userId);
alter table authMethod
    add key idx_authMethodMethodId (methodId);
alter table authMethod
    add key idx_authMethodFactorId (factorId);

alter table authMethod
    add unique key uqAuthMethodUserMethod (userId, methodId, name);
alter table authMethod
    add key idxAuthMethodUserEnabled (userId, enabled);
