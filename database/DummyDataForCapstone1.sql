BEGIN;

INSERT INTO app_user (user_name, password, role, salt, first_name, last_name, email, food_restrictions)
VALUES ('CaptainKirk', 'Enterprise1', 'capstone_appuser', 'qwerty', 'James', 'Kirk', 'jkirk@starfleet.com', 'Allerigc to Trebbles');
INSERT INTO app_user (user_name, password, role, salt, first_name, last_name, email, food_restrictions)
VALUES ('VulcanMan69', 'Logical1', 'capstone_appuser', 'qwertyu', 'Schn Tgai', 'Spock', 'spock@vulcan.com', 'Food Allergies are illogical');
INSERT INTO app_user (user_name, password, role, salt, first_name, last_name, email, food_restrictions)
VALUES ('VadaKilla33', 'LastJedi2', 'capstone_appuser', 'qwertydu', 'Luke', 'Skywalker', 'lskywalker@rebellion.com', 'None');
INSERT INTO app_user (user_name, password, role, salt, first_name, last_name, email, food_restrictions)
VALUES ('SithMasta', 'SithLord69', 'capstone_appuser', 'qwesrtydu', 'Kylo', 'Ren', 'Iheartvader@sith.com', 'None');

INSERT INTO events (event_name, host_username, event_date, event_time)
VALUES ('Kirk Retirement', 'CaptainKirk', '2018-01-12', '06:00');
INSERT INTO events (event_name, host_username, event_date, event_time)
VALUES ('Logical Gathering', 'VulcanMan69', '2018-02-12', '06:00');
INSERT INTO events (event_name, host_username, event_date, event_time)
VALUES ('Funeral for Luke', 'VadaKilla33', '2018-01-16', '06:00');
INSERT INTO events (event_name, host_username, event_date, event_time)
VALUES ('Stormtrooper Kegger', 'SithMasta', '2018-03-17', '06:00');

INSERT INTO address (street_address, city, state, zip)
VALUES ('123 StarFleet Drive', 'San Francisco', 'California', 57463);
INSERT INTO address (street_address, city, state, zip)
VALUES ('123 MindMeld Drive', 'Vulcan City', 'Logical', 94837);
INSERT INTO address (street_address, city, state, zip)
VALUES ('123 Jedi Way', 'Hut on hill', 'Ireland', 13456);
INSERT INTO address (street_address, city, state, zip)
VALUES ('345 Sith Rules Way', 'El Camino', 'Star Base', 57463);

COMMIT;