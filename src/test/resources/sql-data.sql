INSERT INTO `Customers` (`first_name`, `surname`, `address`) VALUES ('jordan', 'harrison', '64 Zoo Lane');
INSERT INTO `Orders` (`id_customer`) VALUES (1);
INSERT INTO `Items` (`item_name`, `item_price`) VALUES ('Book', 8.99);
INSERT INTO `OrderItems` (`id_order`, `item_id`) VALUES (1, 1);
