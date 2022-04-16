CREATE TABLE `User` (
	`UserId` int NOT NULL AUTO_INCREMENT,
	`FirstName` varchar(200) NOT NULL,
	`LastName` varchar(200) NOT NULL,
	`Gender` varchar(50) NOT NULL,
	`Email` varchar(200) NOT NULL UNIQUE,
	`Password` varchar(200) NOT NULL,
	`Mobile` int(10) NOT NULL,
	`ProfileImg` blob,
	`Role` varchar(20) NOT NULL,
	PRIMARY KEY (`UserId`)
);

CREATE TABLE `Vendor` (
	`UserId` int NOT NULL,
	`ShopId` int NOT NULL AUTO_INCREMENT,
	`ShopName` varchar(500) NOT NULL UNIQUE,
	`ShopCategory` char(200) NOT NULL,
	PRIMARY KEY (`ShopId`)
);

CREATE TABLE `DeliveryPerson` (
	`UserId` int NOT NULL,
	`DeliveryCount` int NOT NULL,
	`OrderId` int NOT NULL,
	`DeliveryStatus` int NOT NULL
);

CREATE TABLE `Address` (
	`UserId` int NOT NULL,
	`AddressId` int NOT NULL AUTO_INCREMENT,
	`AddressLine1` varchar(200) NOT NULL,
	`AddressLine2` varchar(200) NOT NULL,
	`City` varchar(200) NOT NULL,
	`State` varchar(200) NOT NULL,
	`Country` varchar(200) NOT NULL,
	`PinCode` int NOT NULL,
	PRIMARY KEY (`AddressId`)
);

CREATE TABLE `Wallet` (
	`UserId` int NOT NULL,
	`WalletNo` int NOT NULL UNIQUE,
	`WalletBalance` double NOT NULL,
	PRIMARY KEY (`WalletNo`)
);

CREATE TABLE `Roles` (
	`RoleId` int(10) NOT NULL,
	`Role` varchar(20) NOT NULL,
	PRIMARY KEY (`Role`)
);

CREATE TABLE `OrderDetails` (
	`UserId` int NOT NULL,
	`OrderId` int NOT NULL AUTO_INCREMENT,
	`AddressId` int NOT NULL,
	`OrderDetails` varchar(255) NOT NULL,
	`OrderStatus` varchar(255) NOT NULL,
	`OrderedDate` DATE NOT NULL,
	`ShippedDate` DATE NOT NULL,
	`OrderTrackingNumber` int NOT NULL AUTO_INCREMENT DEFAULT '1000',
	`OrderQuantity` int NOT NULL DEFAULT '1',
	`OrderAmount` int NOT NULL,
	`ProductId` int NOT NULL,
	`PaymentId` int NOT NULL,
	PRIMARY KEY (`OrderId`)
);

CREATE TABLE `Product` (
	`ProductId` int NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (`ProductId`)
);

CREATE TABLE `Cart` (
	`CartId` int NOT NULL AUTO_INCREMENT,
	`UserId` bigint NOT NULL,
	`ProductId` int NOT NULL,
	`Qty` int NOT NULL,
	`CartTotalPrice` int NOT NULL,
	PRIMARY KEY (`CartId`)
);

CREATE TABLE `OrderItems` (
	`OrderId` int NOT NULL,
	`ProductId` int NOT NULL,
	`Qty` int NOT NULL
);

CREATE TABLE `Payment` (
	`PaymentId` int NOT NULL AUTO_INCREMENT,
	`PaymentDate` DATE NOT NULL,
	`PaymentStatus` varchar(255) NOT NULL,
	PRIMARY KEY (`PaymentId`)
);

ALTER TABLE `User` ADD CONSTRAINT `User_fk0` FOREIGN KEY (`Role`) REFERENCES `Roles`(`Role`);

ALTER TABLE `Vendor` ADD CONSTRAINT `Vendor_fk0` FOREIGN KEY (`UserId`) REFERENCES `User`(`UserId`);

ALTER TABLE `DeliveryPerson` ADD CONSTRAINT `DeliveryPerson_fk0` FOREIGN KEY (`UserId`) REFERENCES `User`(`UserId`);

ALTER TABLE `DeliveryPerson` ADD CONSTRAINT `DeliveryPerson_fk1` FOREIGN KEY (`OrderId`) REFERENCES `OrderDetails`(`OrderId`);

ALTER TABLE `Address` ADD CONSTRAINT `Address_fk0` FOREIGN KEY (`UserId`) REFERENCES `User`(`UserId`);

ALTER TABLE `Wallet` ADD CONSTRAINT `Wallet_fk0` FOREIGN KEY (`UserId`) REFERENCES `User`(`UserId`);

ALTER TABLE `OrderDetails` ADD CONSTRAINT `OrderDetails_fk0` FOREIGN KEY (`UserId`) REFERENCES `User`(`UserId`);

ALTER TABLE `OrderDetails` ADD CONSTRAINT `OrderDetails_fk1` FOREIGN KEY (`AddressId`) REFERENCES `Address`(`AddressId`);

ALTER TABLE `OrderDetails` ADD CONSTRAINT `OrderDetails_fk2` FOREIGN KEY (`ProductId`) REFERENCES `Product`(`ProductId`);

ALTER TABLE `OrderDetails` ADD CONSTRAINT `OrderDetails_fk3` FOREIGN KEY (`PaymentId`) REFERENCES `Payment`(`PaymentId`);

ALTER TABLE `Cart` ADD CONSTRAINT `Cart_fk0` FOREIGN KEY (`UserId`) REFERENCES `User`(`UserId`);

ALTER TABLE `Cart` ADD CONSTRAINT `Cart_fk1` FOREIGN KEY (`ProductId`) REFERENCES `Product`(`ProductId`);

ALTER TABLE `OrderItems` ADD CONSTRAINT `OrderItems_fk0` FOREIGN KEY (`OrderId`) REFERENCES `OrderDetails`(`OrderId`);

ALTER TABLE `OrderItems` ADD CONSTRAINT `OrderItems_fk1` FOREIGN KEY (`ProductId`) REFERENCES `Product`(`ProductId`);












