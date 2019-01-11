BEGIN;

INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (1, 1, 1);
INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (1, 1, 2);
INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (1, 1, 3);
INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (1, 1, 4);

INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (2, 1, 1);
INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (2, 1, 2);
INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (2, 1, 3);
INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (2, 1, 4);

INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (3, 1, 1);
INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (3, 1, 2);
INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (3, 1, 3);
INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (3, 1, 4);

INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (4, 2, 5);
INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (4, 2, 6);
INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (4, 2, 7);
INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (4, 2, 8);

INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (5, 2, 5);
INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (5, 2, 6);
INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (5, 2, 7);
INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (5, 2, 8);

INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (6, 2, 5);
INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (6, 2, 6);
INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (6, 2, 7);
INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (6, 2, 8);

INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (7, 3, 9);
INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (7, 3, 10);
INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (7, 3, 11);
INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (7, 3, 12);

INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (8, 3, 9);
INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (8, 3, 10);
INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (8, 3, 11);
INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (8, 3, 12);

INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (9, 3, 9);
INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (9, 3, 10);
INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (9, 3, 11);
INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (9, 3, 12);

INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (10, 4, 13);
INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (10, 4, 14);
INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (10, 4, 15);
INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (10, 4, 16);

INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (11, 4, 13);
INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (11, 4, 14);
INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (11, 4, 15);
INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (11, 4, 16);

INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (12, 4, 13);
INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (12, 4, 14);
INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (12, 4, 15);
INSERT INTO food_orders (event_attendees_id, menu_id, menu_item_id)
VALUES (12, 4, 16);

UPDATE events
SET address_id = 1
WHERE event_id = 1
;

UPDATE events
SET address_id = 2
WHERE event_id = 2
;

UPDATE events
SET address_id = 3
WHERE event_id = 3
;

UPDATE events
SET address_id = 4
WHERE event_id = 4
;

UPDATE event_attendees
SET username = 'CaptainKirk'
WHERE email = 'jkirk@starfleet.com'
;

UPDATE event_attendees
SET username = 'VulcanMan69'
WHERE email = 'spock@vulcan.com'
;

UPDATE event_attendees
SET username = 'VadaKilla33'
WHERE email = 'lskywalker@rebellion.com'
;

UPDATE event_attendees
SET username = 'SithMasta'
WHERE email = 'Iheartvader@sith.com'
;

COMMIT;