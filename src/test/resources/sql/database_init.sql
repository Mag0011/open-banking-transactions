CREATE TABLE transactions.transactions (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `account_number` bigint DEFAULT NULL,
  `amount` decimal(19,2) DEFAULT NULL,
  `currency` varchar(5) DEFAULT NULL,
  `date` date NOT NULL,
  `merchant_logo` varchar(255) DEFAULT NULL,
  `merchant_name` varchar(100) DEFAULT NULL,
  `type` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
);
INSERT INTO transactions (`id`,`account_number`,`amount`,`currency`,`date`,`merchant_logo`,`merchant_name`,`type`) VALUES (1,123456789,150000.00,'USD','2024-11-24','logo1','Merch 1','Deposit');
INSERT INTO transactions (`id`,`account_number`,`amount`,`currency`,`date`,`merchant_logo`,`merchant_name`,`type`) VALUES (2,123456789,100000.00,'USD','2024-11-24','logo1','Merch 1','Withdrawal');