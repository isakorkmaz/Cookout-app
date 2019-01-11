BEGIN;

INSERT INTO menu_item (menu_id, name, description, food_category_id)
VALUES (1, 'Burger', 'Hamburger with or without toppings', 1);
INSERT INTO menu_item (menu_id, name, description, food_category_id)
VALUES (1, 'Potato Salad', 'My famous recripe', 2);
INSERT INTO menu_item (menu_id, name, description, food_category_id)
VALUES (1, 'brownies', 'my special recipee', 3);
INSERT INTO menu_item (menu_id, name, description, food_category_id)
VALUES (1, 'Romulan Ale', 'Its blue', 4);

INSERT INTO menu_item (menu_id, name, description, food_category_id)
VALUES (2, 'HotDog', 'Hotdog with or without toppings', 1);
INSERT INTO menu_item (menu_id, name, description, food_category_id)
VALUES (2, 'Pasta Salad', 'My famous recipe', 2);
INSERT INTO menu_item (menu_id, name, description, food_category_id)
VALUES (2, 'cookies', 'store bought', 3);
INSERT INTO menu_item (menu_id, name, description, food_category_id)
VALUES (2, 'XMas Ale', 'Its good', 4);

INSERT INTO menu_item (menu_id, name, description, food_category_id)
VALUES (3, 'Chicken', 'Grilled lemon, pepper chicken', 1);
INSERT INTO menu_item (menu_id, name, description, food_category_id)
VALUES (3, 'salad', 'Everything from the garden', 2);
INSERT INTO menu_item (menu_id, name, description, food_category_id)
VALUES (3, 'ice cream', 'I scream, you scream', 3);
INSERT INTO menu_item (menu_id, name, description, food_category_id)
VALUES (3, 'Whiskey', 'From Kentucky', 4);

INSERT INTO menu_item (menu_id, name, description, food_category_id)
VALUES (4, 'Bantha Steaks', 'Fresh from Tantooin', 1);
INSERT INTO menu_item (menu_id, name, description, food_category_id)
VALUES (4, 'Chips', 'Potato or Dorito', 2);
INSERT INTO menu_item (menu_id, name, description, food_category_id)
VALUES (4, 'candy bars', 'variety available', 3);
INSERT INTO menu_item (menu_id, name, description, food_category_id)
VALUES (4, 'KEGS', 'All the beers', 4);

COMMIT;