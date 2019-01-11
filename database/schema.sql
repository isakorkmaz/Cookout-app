-- *************************************************************************************************
-- This script creates all of the database objects (tables, sequences, etc) for the database
-- *************************************************************************************************
BEGIN;

DROP TABLE IF EXISTS app_user CASCADE;
DROP TABLE IF EXISTS events CASCADE;
DROP TABLE IF EXISTS event CASCADE;
DROP TABLE IF EXISTS event_attendees CASCADE;
DROP TABLE IF EXISTS address CASCADE;
DROP TABLE IF EXISTS food_menu CASCADE;
DROP TABLE IF EXISTS menu_item CASCADE;
DROP TABLE IF EXISTS food_orders CASCADE;
DROP TABLE IF EXISTS food_category CASCADE;
DROP SEQUENCE IF EXISTS seq_app_user_id;
DROP SEQUENCE IF EXISTS seq_food_category_id;
DROP SEQUENCE IF EXISTS seq_event_id;
DROP SEQUENCE IF EXISTS seq_menu_id;
DROP SEQUENCE IF EXISTS seq_address_id;
DROP SEQUENCE IF EXISTS seq_event_attendees_id;
DROP SEQUENCE IF EXISTS seq_menu_item_id;
DROP SEQUENCE IF EXISTS seq_food_orders_id;

CREATE SEQUENCE seq_app_user_id
START 1
INCREMENT 1;

CREATE TABLE app_user (
  id INTEGER DEFAULT NEXTVAL('seq_app_user_id') PRIMARY KEY,
  user_name varchar(32) NOT NULL UNIQUE,
  password varchar(32) NOT NULL,
  role varchar(32),
  salt varchar(255) NOT NULL,
  first_name varchar(64) NOT NULL,
  last_name varchar(64) NOT NULL,
  email varchar(64) NOT NULL,
  food_restrictions varchar(255) NULL
);

CREATE SEQUENCE seq_food_category_id;

CREATE TABLE food_category
(
food_category_id INTEGER DEFAULT NEXTVAL('seq_food_category_id') PRIMARY KEY,
category_name varchar(20) NOT NULL
);

CREATE SEQUENCE seq_event_id
START 1
INCREMENT 1;
CREATE SEQUENCE seq_menu_id
START 1
INCREMENT 1;

CREATE TABLE events
(
event_id INTEGER DEFAULT NEXTVAL('seq_event_id') PRIMARY KEY,
menu_id INTEGER DEFAULT NEXTVAL('seq_menu_id')  UNIQUE,
event_name varchar(20) NOT NULL,
host_username varchar(64) NOT NULL,
event_date date NOT NULL,
event_time varchar(10) NOT NULL
);

CREATE SEQUENCE seq_address_id
START 1
INCREMENT 1;

CREATE TABLE address
(
address_id INTEGER DEFAULT NEXTVAL('seq_address_id') PRIMARY KEY,
street_address varchar(50) NOT NULL,
city varchar(20) NOT NULL,
state varchar(20) NOT NULL,
zip integer NOT NULL
);

CREATE SEQUENCE seq_event_attendees_id
START 1
INCREMENT 1;

CREATE TABLE event_attendees
(
event_attendees_id INTEGER DEFAULT NEXTVAL('seq_event_attendees_id') PRIMARY KEY,
username varchar(64),
email varchar(64) NOT NULL,
first_name varchar(20) NOT NULL,
last_name varchar(20) NOT NULL,
event_id INTEGER         NOT NULL,
is_host boolean DEFAULT false,
is_confirmed boolean DEFAULT false,
CONSTRAINT fk_event_id FOREIGN KEY (event_id) REFERENCES events (event_id),
CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES app_user (user_name)
);

CREATE SEQUENCE seq_menu_item_id
START 1
INCREMENT 1;

CREATE TABLE menu_item
(
menu_item_id INTEGER DEFAULT NEXTVAL('seq_menu_item_id') PRIMARY KEY,
menu_id int NOT NULL,
name varchar(20) NOT NULL,
description varchar(64) NOT NULL,
food_category_id integer NOT NULL,
FOREIGN KEY (menu_id) REFERENCES events (menu_id),
FOREIGN KEY (food_category_id) REFERENCES food_category (food_category_id)
);

CREATE SEQUENCE seq_food_orders_id
START 1
INCREMENT 1;

CREATE TABLE food_orders
(
food_orders_id INTEGER DEFAULT NEXTVAL('seq_food_orders_id') PRIMARY KEY,
event_attendees_id integer NOT NULL,
menu_id integer NOT NULL,
menu_item_id integer NOT NULL,
CONSTRAINT fk_event_attendees_id FOREIGN KEY (event_attendees_id) REFERENCES event_attendees (event_attendees_id),
CONSTRAINT fk_menu_id FOREIGN KEY (menu_id) REFERENCES events (menu_id),
CONSTRAINT fk_menu_item_id FOREIGN KEY (menu_item_id) REFERENCES menu_item (menu_item_id)
);

ALTER TABLE events
ADD COLUMN address_id integer
;

ALTER TABLE events
ADD CONSTRAINT fk_address_id
FOREIGN KEY (address_id) 
REFERENCES address (address_id);

GRANT SELECT, INSERT, UPDATE, DELETE
ON events, event_attendees, address, menu_item, food_orders
TO  capstone_appuser
;

GRANT ALL
ON app_user, events, event_attendees, address, menu_item, food_orders
TO capstone_owner
;

INSERT INTO food_category (category_name) VALUES ('Entree');
INSERT INTO food_category (category_name) VALUES ('Side');
INSERT INTO food_category (category_name) VALUES ('Dessert');
INSERT INTO food_category (category_name) VALUES ('Beverage');

COMMIT;