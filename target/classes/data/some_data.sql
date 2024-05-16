USE productdelivery;

INSERT INTO shop (country, city, adress) VALUES
	('Ukraine', 'Ternopil', 'Vilna, 8'),
    ('Ukraine', 'Kiyv', 'Rebelpathova, 11'),
    ('Ukraine', 'Lviv', 'Chornovola, 1');

INSERT INTO product (shop_id, manufacturer, name, category, price, arrived, expired, is_available) VALUES
	(1, 'Polyana', 'Pasta Vishukana 400g', 'flour', 40.00, '2022-10-10', NULL, 1),
    (1, 'Halichyna', 'Yoghurt Palyanitsa 180g', 'milk', 23.50, '2022-10-10', NULL, 1),
	(1, 'Veres', 'Perec chilly 250g', 'canned', 60.00, '2022-10-10', NULL, 1),
	(1, 'Nestle', 'Nesquick 200g', 'breakfast', 45.75, '2022-10-10', NULL, 1),
	(1, 'RIP&TEAR', 'DEMONS MEAT', 'MEAT.', 666.13, '2022-10-10', NULL, 0);

INSERT INTO customer (name, surname, phone, adress) VALUES
	('Ihor', 'Vuyko', '096*****13', 'Stefanenka, 3'),
	('Stepan', 'Lis', '067*****01', 'Dorijna, 6'),
	('John', 'Silver', '044*****56', 'Polishkova, 16'),
	('Valeria', 'Shypit', '068*****98', 'Nichnogo Dozoru, 9'),
	('Judy', 'Jecksons', '044*****44', 'EEEEE, E');

INSERT INTO delivery (customer_id, ordered_time, arrival, urgency_price, transport_id) VALUES
	(1, '2022-11-10 13:44:52', '15:00:00', NULL, 1),
	(2, '2022-11-10 13:53:06', '15:05:00', NULL, 2),
	(3, '2022-11-10 14:04:18', '15:07:00', NULL, 1),
	(4, '2022-11-10 14:31:40', '16:00:00', NULL, 3),
	(5, '2022-11-10 14:36:08', '15:00:00', 120.00, 4);

INSERT INTO delivery_products (product_id, delivery_id, quantity, weight, price) VALUES
	('4', '1', '1', '0.200', '45.75'),
    ('3', '2', '2', '0.500', '120.00'),
    ('1', '3', '1', '0.400', '40.00'),
    ('2', '4', '4', '0.720', '94.00');