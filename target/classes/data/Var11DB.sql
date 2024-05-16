--  Золочевський Миколай ІР-23

--  ЗАВДАННЯ 1
DELIMITER //
CREATE TRIGGER surname_limiter
BEFORE INSERT ON table1
FOR EACH ROW
BEGIN
    DECLARE last_two VARCHAR(2);
    SET last_two = RIGHT(NEW.surname, 2);

    IF last_two = 'ін' OR last_two = 'іна' THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Прізвище не може закінчуватися на ''ін'' чи ''іна''';
    END IF;
END//
DELIMITER ;


--  ЗАВДАННЯ 2
DELIMITER //
CREATE PROCEDURE create_table_copies(IN num INT)
BEGIN
    DECLARE i INT DEFAULT 1;
    DECLARE copy_name VARCHAR(255);

    WHILE i <= num DO
        SET copy_name = CONCAT('table1(', i, ')');

        SET @sql = CONCAT('CREATE TABLE ', copy_name, ' LIKE table1');
        PREPARE statement FROM @sql;
        EXECUTE statement;
        DEALLOCATE PREPARE statement;

        SET @sql = CONCAT('INSERT INTO ', copy_name, ' SELECT * FROM table1');
        PREPARE statement FROM @sql;
        EXECUTE statement;
        DEALLOCATE PREPARE statement;

        SET i = i + 1;
    END WHILE;
END //
DELIMITER ;


--  ЗАВДАННЯ 3
SELECT model, speed, hd, price
FROM PC
WHERE price < 600
ORDER BY speed ASC;


-- ЗАВДАННЯ 4
SELECT maker, type, speed, hd
FROM LAPTOP
WHERE hd >= 10


-- ЗАВДАННЯ 5
SELECT COUNT(DISTINCT maker) AS maker_count
FROM PC;