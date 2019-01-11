BEGIN;

INSERT INTO event_attendees (email, first_name, last_name, event_id)
VALUES ('spock@vulcan.com', 'Schn', 'Spock', 1);
INSERT INTO event_attendees (email, first_name, last_name, event_id)
VALUES ('lskywalker@rebellion.com', 'Luke', 'Skywalker', 1);
INSERT INTO event_attendees (email, first_name, last_name, event_id)
VALUES ('Iheartvader@sith.com', 'Kylo', 'Ren', 1);

INSERT INTO event_attendees (email, first_name, last_name, event_id)
VALUES ('jkirk@starfleet.com', 'James', 'Kirk', 2);
INSERT INTO event_attendees (email, first_name, last_name, event_id)
VALUES ('lskywalker@rebellion.com', 'Luke', 'Skywalker', 2);
INSERT INTO event_attendees (email, first_name, last_name, event_id)
VALUES ('Iheartvader@sith.com', 'Kylo', 'Ren', 2);

INSERT INTO event_attendees (email, first_name, last_name, event_id)
VALUES ('spock@vulcan.com', 'Schn', 'Spock', 3);
INSERT INTO event_attendees (email, first_name, last_name, event_id)
VALUES ('jkirk@starfleet.com', 'James', 'Kirk', 3);
INSERT INTO event_attendees (email, first_name, last_name, event_id)
VALUES ('Iheartvader@sith.com', 'Kylo', 'Ren', 3);

INSERT INTO event_attendees (email, first_name, last_name, event_id)
VALUES ('spock@vulcan.com', 'Schn', 'Spock', 4);
INSERT INTO event_attendees (email, first_name, last_name, event_id)
VALUES ('jkirk@starfleet.com', 'James', 'Kirk', 4);
INSERT INTO event_attendees (email, first_name, last_name, event_id)
VALUES ('lskywalker@rebellion.com',  'Luke', 'Skywalker', 4);

COMMIT;