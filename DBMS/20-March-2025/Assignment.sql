CREATE DATABASE storeFront;
USE storeFront;

CREATE TABLE category(
	categoryID INT PRIMARY KEY,
    categoryDesc VARCHAR(50),
    categoryName VARCHAR(10)
);

CREATE TABLE product(
	productID INT PRIMARY KEY,
    categoryID INT ,
    productName VARCHAR(10),
    productDesc VARCHAR(50),
    productPrice INT,
    productStock INT,
    FOREIGN KEY (categoryID) REFERENCES category(categoryID)
);

CREATE TABLE image(
	imageID INT PRIMARY KEY,
    productID INT,
	imageUrl VARCHAR(100),
    FOREIGN KEY (productID) REFERENCES product(productID)
);

CREATE TABLE orders(
	orderID INT PRIMARY KEY,
    orderDate date,
    deleiverDate date,
    orderStatus varchar(10)
);

CREATE TABLE orderItem(
	orderItemID INT PRIMARY KEY,
    orderId INT,
    orderItemName VARCHAR(10),
    orderItemQuantity INT,
    orderItemStatus VARCHAR(10),
    productID INT,
    FOREIGN KEY (productID) REFERENCES product(productID)
);

CREATE TABLE users(
	userRoleID INT PRIMARY KEY,
	userRoleType VARCHAR(50)
);

CREATE TABLE shopper(
	shopperID INT PRIMARY KEY,
    roleID INT,
    shopperName VARCHAR(20),
    password VARCHAR(20),
    email VARCHAR(20),
    phoneNumber INT(10),
    gender CHAR(1),
    FOREIGN KEY (roleID) REFERENCES users(userRoleID)
);

