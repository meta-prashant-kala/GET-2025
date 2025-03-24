CREATE DATABASE storeFront;
USE storeFront;

CREATE TABLE category(
	PrarentCategory INT,
	CategoryID INT PRIMARY KEY,
    CategoryDesc VARCHAR(50),
    CategoryName VARCHAR(10)
);

CREATE TABLE product(
	ProductID INT PRIMARY KEY,
    CategoryID INT ,
    ProductName VARCHAR(10),
    ProductDesc VARCHAR(50),
    ProductPrice INT,
    ProductStock INT,
    FOREIGN KEY (categoryID) REFERENCES category(categoryID)
);

CREATE TABLE image(
	ImageID INT PRIMARY KEY,
    ProductID INT,
    ImageData VARCHAR(50),
	imageUrl VARCHAR(100),
    FOREIGN KEY (ProductID) REFERENCES product(ProductID)
);

CREATE TABLE payment(
	PaymentID INT PRIMARY KEY,
    PaymentMode VARCHAR(10),
	PaymentTime DATE,
    PaymentAmount INT
);

CREATE TABLE orders(
	OrderID INT PRIMARY KEY,
    PaymentID INT,
    OrderDate DATE,
    DeleiverDate DATE,
    orderStatus VARCHAR(10),
    ShippingAddress VARCHAR(50),
    FOREIGN KEY (PaymentID) REFERENCES payment(PaymentID)
);

CREATE TABLE orderItem(
	OrderItemID INT PRIMARY KEY,
    OrderId INT,
	ProductID INT,
    OrderItemName VARCHAR(10),
    OrderItemQuantity INT,
    OrderItemStatus VARCHAR(10),
    FOREIGN KEY (ProductID) REFERENCES product(productID),
    FOREIGN KEY (OrderID) REFERENCES orders(OrderID)
);

CREATE TABLE users(
	UserID INT PRIMARY KEY,
    RoleID INT,
    ShopperName VARCHAR(20),
    Password VARCHAR(20),
    Email VARCHAR(20),
    PhoneNumber INT(10),
    Gender CHAR(1),
    FOREIGN KEY (roleID) REFERENCES users(userRoleID)
);

CREATE TABLE shippingAdrress(
	AddressID INT PRIMARY KEY,
    UserID INT,
    City VARCHAR(10),
    State VARCHAR(10),
	Pincode INT,
    Country VARCHAR(10),
    Address VARCHAR(50),
    FOREIGN KEY (UserID) REFERENCES users(UserID)
);



SHOW TABLES;
DROP TABLE product;
SHOW TABLES;
CREATE TABLE product(
	ProductID INT PRIMARY KEY,
    CategoryID INT ,
    ProductName VARCHAR(10),
    ProductDesc VARCHAR(50),
    ProductPrice INT,
    ProductStock INT,
    FOREIGN KEY (categoryID) REFERENCES category(categoryID)
);

SHOW TABLES;
