USE productdelivery;

DROP TABLE IF EXISTS transport;

CREATE TABLE transport (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NULL,
    delivery_id INT NOT NULL,
    PRIMARY KEY (`id`)
 );

INSERT INTO transport VALUES ('Delivery van', 1),('Scooter', 2),('SUV', 3),('Hatchback', 4);

DROP TRIGGER IF EXISTS CheckIfDeliveryExistsBeforeCreate;
DROP TRIGGER IF EXISTS CheckIfDeliveryExistsBeforeUpdate;
DROP TRIGGER IF EXISTS DeleteAllRecordsInDeliveryTableAfterTransportWasDeleted;

DELIMITER //
CREATE TRIGGER CheckIfDeliveryExistsBeforeCreate
    BEFORE INSERT
    ON transport
    FOR EACH ROW
BEGIN
    DECLARE delivery_id INT;
    DECLARE message TEXT;
    SELECT id INTO delivery_id FROM delivery WHERE id = new.delivery_id;
    SET message = concat('Cannot update a record: the delivery id ', new.delivery_id, ' is not found');
    IF delivery_id IS NULL THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = message;
END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER CheckIfDeliveryExistsBeforeUpdate
    BEFORE UPDATE
    ON transport
    FOR EACH ROW
BEGIN
    DECLARE delivery_id INT;
    DECLARE message TEXT;
    SELECT id INTO delivery_id FROM delivery WHERE id = new.delivery_id;
    SET message = concat('Cannot update a record: the delivery id ', new.delivery_id, ' is not found');
    IF delivery_id IS NULL THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = message;
END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER DeleteAllRecordsInTransportTableAfterDeliveryWasDeleted
    BEFORE DELETE
    ON delivery
    FOR EACH ROW
BEGIN
    DELETE FROM `transport` WHERE (delivery_id = old.id);
END //
DELIMITER ;
