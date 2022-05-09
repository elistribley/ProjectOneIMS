
USE ims;
SET @@global.time_zone = '+00:00';
DROP TABLE IF EXISTS `Customers`;
DROP TABLE IF EXISTS `Orders`;
DROP TABLE IF EXISTS `OrderItems`;
DROP TABLE IF EXISTS `Items`;


CREATE TABLE IF NOT EXISTS `Customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) NOT NULL,
    `surname` VARCHAR(40) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `Order` (
    `order_id` INT(11) NOT NULL AUTO_INCREMENT,
    `date_for_order` DATETIME,
    `id_customer` INT(10),
    `id_orderdetails` INT(10),
    PRIMARY KEY (`order_id`),
    FOREIGN KEY (`id_orderdetails`) REFERENCES `OrderItems` (`id_item`),
    FOREIGN KEY (`id_customer`) REFERENCES `Customers` (`id`)
    );
    
    CREATE TABLE IF NOT EXISTS `Items` (
    `item_id` INT(11) NOT NULL,
    `item_name` VARCHAR(40) NOT NULL,
    `item_price` DECIMAL(5, 2) NOT NULL,
    PRIMARY KEY (`item_id`)
);


CREATE TABLE IF NOT EXISTS `OrderItems` (
    `id_order_items` INT(11) NOT NULL,
    `id_item` INT(10) NOT NULL,
    `item_quantity` INT(10) NOT NULL,
    PRIMARY KEY (`id_order_items`),
    FOREIGN KEY (`id_item`) REFERENCES `Items` (`item_id`)
);

