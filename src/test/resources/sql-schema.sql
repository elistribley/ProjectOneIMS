DROP TABLE IF EXISTS OrderItems;
DROP TABLE IF EXISTS Items;
DROP TABLE IF EXISTS Orders;
DROP TABLE IF EXISTS Customers;






CREATE TABLE Customers (
    `id` INT(10) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    `address` VARCHAR(40) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Orders(
    `order_id` INT(10) NOT NULL AUTO_INCREMENT,
    `id_customer` INT(10) NOT NULL,
    FOREIGN KEY (id_customer) REFERENCES Customers(id),
    PRIMARY KEY (order_id)
);

CREATE TABLE Items(
    `item_id` INT(10) NOT NULL AUTO_INCREMENT,
    `item_name` char(50) NOT NULL,
    `item_price` DOUBLE NOT NULL,
    PRIMARY KEY (item_id)
    
);

CREATE TABLE  OrderItems(
    `id_order_items` INT(10) NOT NULL AUTO_INCREMENT,
    `id_order` INT(10) NOT NULL,
    `item_id` INT(10) NOT NULL,
	FOREIGN KEY (order_id) REFERENCES Orders(order_id),
	FOREIGN KEY (item_id) REFERENCES Items(item_id),
    PRIMARY KEY (id_order_items)
);