USE productdelivery;

DROP PROCEDURE IF EXISTS CreateSeveralTransports;

DELIMITER //
CREATE PROCEDURE CreateSeveralTransports(OUT transportNumber int)
BEGIN
    DECLARE i INT;
    SET i = 1;

    WHILE i <= 10 DO
        INSERT INTO transport (name) VALUES (CONCAT('NoNameTranport#', i));
        SET i = i + 1;
    END WHILE;
SET transportNumber = 10;
END //
DELIMITER;

DROP PROCEDURE IF EXISTS InsertIntoCustomer;

DELIMITER //
CREATE PROCEDURE InsertIntoCustomer(IN newCustomerName VARCHAR(40), IN newCustomerAdress VARCHAR(40))
BEGIN
    INSERT INTO customers(name, adress) VALUES(newCustomerName, newCustomerAdress);
END //
DELIMITER ;

DROP FUNCTION IF EXISTS GetAvgDeliveryPrice;

DELIMITER //
CREATE
	FUNCTION GetAvgDeliveryPrice()
    RETURNS float
    DETERMINISTIC
BEGIN
DECLARE average float default 0;
SELECT AVG(price) INTO average FROM delivery_products;
RETURN average;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS AvgDeliveryPrice;
DELIMITER //
CREATE
	PROCEDURE AvgDeliveryPrice()
BEGIN
	UPDATE delivery_products SET mark = 'SOMETHING DO' WHERE price = FLOOR(GetAvgDeliveryPrice());
END//
DELIMITER ;


DROP PROCEDURE IF EXISTS DbCursor;
DELIMITER //
CREATE
	PROCEDURE DbCursor()
BEGIN
 DECLARE done int DEFAULT false;
 DECLARE name varchar(50);
 DECLARE i int;
 DECLARE j int;
 DECLARE St_Cursor CURSOR
	FOR SELECT name from transport;
 DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = true;
 OPEN St_Cursor;
 myLoop: LOOP
	FETCH St_Cursor INTO name;
    IF done = true THEN LEAVE myLoop;
    END IF;
    SET @temp_table_query = CONCAT('CREATE TABLE ', name, NOW(), ' (
    id int PRIMARY KEY AUTO_INCREMENT');
    SET j = CEIL(RAND() *10);
    SET i = 0;
    WHILE i < j DO
		SET @temp_table_query = CONCAT(@temp_table_query, ' , ', 'transport', i, '` varchar(25) NULL');
        SET i = i + 1;
    END WHILE;
    SET @temp_table_query = CONCAT(@temp_table_query, ' );');
    PREPARE my_q FROM @temp_table_query;
    EXECUTE my_q;
    DEALLOCATE PREPARE my_q;
END LOOP;
CLOSE St_Cursor;
END//
DELIMITER ;