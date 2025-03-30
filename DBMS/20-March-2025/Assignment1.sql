-- Create all tables of eCommerce Application: 
-- StoreFront covered in Session 1 Assignments. 
-- (Write all CREATE commands in a SQL file and run that SQL File).

CREATE DATABASE storeFront;
USE storeFront;

CREATE TABLE category(
	ParentCategoryID INT,
	CategoryID INT PRIMARY KEY,
	CategoryName VARCHAR(20),
    CategoryDesc VARCHAR(50)
);

CREATE TABLE product(
	ProductID INT PRIMARY KEY,
    CategoryID INT ,
    ProductName VARCHAR(20) NOT NULL,
    ProductDesc VARCHAR(50),
    ProductPrice INT NOT NULL,
    ProductStock INT,
    isActive BOOLEAN,
    CreatedAt DATE,
    FOREIGN KEY (CategoryID) REFERENCES category(CategoryID)
);

CREATE TABLE image(
	ImageID INT PRIMARY KEY,
    ProductID INT,
    ImageData VARCHAR(50),
	imageUrl VARCHAR(100),
    FOREIGN KEY (ProductID) REFERENCES product(ProductID)
);


CREATE TABLE users(
	UserID INT PRIMARY KEY,
    RoleID INT,
    UserName VARCHAR(20),
    Password VARCHAR(20),
    Email VARCHAR(30),
    PhoneNumber VARCHAR(10),
    Gender CHAR(1)
);

CREATE TABLE orders(
	OrderID INT PRIMARY KEY,
    UserID INT,
    OrderDate DATE,
    DeleiverDate DATE ,
    OrderStatus VARCHAR(20),
    ShippingAddress VARCHAR(50),
    FOREIGN KEY (UserID) REFERENCES users(UserID)
);

CREATE TABLE payment(
	PaymentID INT PRIMARY KEY,
    OrderID INT,
    PaymentMode VARCHAR(10),
	PaymentTime DATE,
    PaymentAmount INT,
    FOREIGN KEY (OrderID) REFERENCES orders(OrderID)
);

CREATE TABLE orderItem(
	OrderItemID INT PRIMARY KEY,
    OrderID INT,
	ProductID INT,
    OrderItemName VARCHAR(20),
    OrderItemQuantity INT,
    OrderItemStatus VARCHAR(20),
    OrderItemPrice INT,
    FOREIGN KEY (ProductID) REFERENCES product(productID),
    FOREIGN KEY (OrderID) REFERENCES orders(OrderID)
);

CREATE TABLE shippingAdrress(
	AddressID INT PRIMARY KEY,
    UserID INT,
    City VARCHAR(20) NOT NULL,
    State VARCHAR(20) NOT NULL,
	Pincode INT NOT NULL,
    Country VARCHAR(20) NOT NULL,
    Address VARCHAR(50) NOT NULL,
    FOREIGN KEY (UserID) REFERENCES users(UserID)
);

-- Write a command to display all the table names present in StoreFront.
SHOW TABLES;

-- Write a command to remove Product table of the StoreFront database.
DROP TABLE image;
DROP TABLE orderItem;
DROP TABLE product;

SHOW TABLES;

-- Create the Product table again
CREATE TABLE product(
	ProductID INT PRIMARY KEY,
    CategoryID INT ,
    ProductName VARCHAR(20),
    ProductDesc VARCHAR(50),
    ProductPrice INT,
    ProductStock INT,
    isActive BOOLEAN,
    CreatedAt DATE,
    FOREIGN KEY (categoryID) REFERENCES category(categoryID)
);

CREATE TABLE image(
	ImageID INT PRIMARY KEY,
    ProductID INT,
    ImageData VARCHAR(50),
	imageUrl VARCHAR(100),
    FOREIGN KEY (ProductID) REFERENCES product(ProductID)
);

CREATE TABLE orderItem(
	OrderItemID INT PRIMARY KEY,
    OrderID INT,
	ProductID INT,
    OrderItemName VARCHAR(20),
    OrderItemQuantity INT,
    OrderItemStatus VARCHAR(20),
	OrderItemPrice INT,
    FOREIGN KEY (ProductID) REFERENCES product(productID),
    FOREIGN KEY (OrderID) REFERENCES orders(OrderID)
);

SHOW TABLES;

