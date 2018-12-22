-- Exercise Tables
-- Run as the master user (exercise user has no CREATE privilege)

USE exercise;

CREATE TABLE user (
    user_id bigint AUTO_INCREMENT,
    email varchar(40),
    username varchar(12),
    password varchar(20),
    PRIMARY KEY(user_id)
);
-- Potential improvement to roles would be a 2-way XREF so role names aren't duplicated across users.
CREATE TABLE userrole (
    role_id bigint AUTO_INCREMENT,
    user_id bigint NOT NULL,
    rolename varchar(20),
    PRIMARY KEY(role_id)
);
ALTER TABLE userrole ADD FOREIGN KEY (user_id) references user(user_id);

CREATE TABLE userhobby (
    id bigint AUTO_INCREMENT,
    user_id bigint NOT NULL,
    hobby varchar(20) NOT NULL,
    createdBy varchar(40) NOT NULL,
    createdOn DateTime NOT NULL,
    PRIMARY KEY(id)
);
ALTER TABLE userhobby ADD FOREIGN KEY (user_id) references user(user_id);

CREATE TABLE userphone (
    id bigint AUTO_INCREMENT,
    user_id bigint NOT NULL,
    type varchar(10) NOT NULL, #enum (OFFICE, HOME, MOBILE)
    phoneNumber varchar(10) NOT NULL,
    createdBy varchar(40) NOT NULL,
    createdOn DateTime NOT NULL,
    PRIMARY KEY(id)
);
ALTER TABLE userphone ADD FOREIGN KEY (user_id) references user(user_id);

SHOW TABLES;
