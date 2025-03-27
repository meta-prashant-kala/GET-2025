USE storeFront;
CREATE TABLE prodAndCatJunction(
	ProductID int,
    CategoryID int,
    FOREIGN KEY (ProductID) REFERENCES product(ProductID),
    FOREIGN KEY (CategoryID) REFERENCES category(CategoryID),
    PRIMARY KEY (ProductID, CategoryID)
);

INSERT INTO prodAndCatJunction (ProductID, CategoryID)
VALUES
(101, 1), (101, 4), -- iPhone (Electronics and Mobiles)
(102, 1), (102, 5), -- Laptop (Electronics and Computers)
(103, 3), (103, 7), -- Blender (Home and Kitchen)
(108, 1), (108, 4), -- SmartTV (Electronics and Mobiles)
(121, 1), (121, 21), -- Headphone (Electronics and Accessories)
(127, 3), (127, 31), -- Lamp (Home and Lighting)
(128, 15), (128, 32), -- VRHeadset (Gaming and VR Gaming)
(129, 33), (129, 34), -- Guitar (Music and Guitars)
(133, 38), (133, 39), -- Coffee (Groceries and Beverages)
(134, 44), (134, 37), -- Paint (Art and Pets)
(135, 37), (135, 46), -- PetFood (Pets and Baby)
(140, 47), (140, 44), -- CraftKit (DIY and Art)
(141, 48), (141, 47), -- Treadmill (Fitness and DIY)
(142, 49), (142, 7),  -- CleaningMop (Cleaning and Kitchen)
(143, 12), (143, 44), -- GardeningTool (Garden and Art)
(144, 34), (144, 33), -- ElectricGuitar (Music and Guitars)
(145, 50), (145, 5),  -- Antivirus (Software and Computers)
(146, 7), (146, 3),   -- Mixer (Kitchen and Home)
(147, 3), (147, 6),   -- Desk (Home and Furniture)
(148, 9), (148, 2),   -- Skirt (Women and Clothing)
(149, 8), (149, 2),   -- Shorts (Men and Clothing)
(150, 21), (150, 5),  -- Keyboard (Accessories and Computers)
(103, 12), (103, 19), -- Blender (Garden and Health)
(105, 8), (105, 19),  -- Sneakers (Men and Health)
(107, 22), (107, 10), -- Toy Car (Toys and Kids)
(116, 27), (116, 48), -- Racket (Sports and Fitness)
(122, 29), (122, 27), -- CricketBat (Sports and Cricket)
(123, 30), (123, 27), -- SwimGoggles (Sports and Swimming)
(111, 22), (111, 15), -- Board Game (Toys and Gaming)
(112, 16), (112, 45), -- CarCover (Automotive and Tools)
(139, 16), (139, 18); -- BikeCover (Automotive and Bike Gear)

-- Display the list of products (Id, Title, Count of Categories) 
-- which fall in more than one Category.
SELECT ProductID, COUNT(CategoryID) AS CategoryCount 
	FROM prodAndCatJunction 
	GROUP BY ProductID
    HAVING CategoryCount > 1;
    
-- Display Count of products as per below price range:

    
-- Display the Categories along with number of products under each category.
SELECT CategoryID , COUNT(ProductID) AS ProductCount
	FROM prodAndCatJunction
	GROUP BY CategoryID;
    
    
INSERT INTO payment (PaymentID, PaymentMode, PaymentTime, PaymentAmount)
VALUES
(351, 'CreditCard', '2025-02-26', 70000);
    
INSERT INTO orders (OrderID, UserID, PaymentID, OrderDate, DeleiverDate, orderStatus, ShippingAddress)
VALUES
(451, 650, 351, '2025-02-26', '2025-02-27', 'Shipped', '123, ABC Street, Jaipur');


-- Display Shopper’s information along with number of orders 
-- he/she placed during last 30 days.
SELECT u.UserID, u.UserName, COUNT(o.OrderID) FROM users u
	JOIN orders o ON u.UserID=o.UserID
    WHERE o.OrderDate > NOW() - INTERVAL 90 DAY
    GROUP BY o.UserID;
    
-- Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.
SELECT u.UserID, u.UserName, jt.Revenue 
	FROM users u 
    JOIN (SELECT o.UserID, SUM(p.PaymentAmount) AS Revenue
	FROM orders o JOIN payment p ON o.PaymentID=p.PaymentID
    GROUP BY o.UserID) jt ON  jt.UserID=u.UserID
    ORDER BY jt.Revenue DESC
    LIMIT 10 ;
    
    
-- Display top 20 Products which are ordered most in last 60 days along with numbers
SELECT oi.ProductID, (SELECT ProductName FROM product WHERE productID=oi.ProductID) AS ProductName , 
	COUNT(oi.OrderItemID) AS ItemCount, MAX(o.OrderDate) AS OrderDate
	FROM orderItem oi JOIN orders o ON o.OrderID=oi.OrderID
    WHERE o.OrderDate>NOW() - INTERVAL 90 DAY
	GROUP BY oi.ProductID
    ORDER BY ItemCount DESC
    LIMIT 20;
    
-- Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.
SELECT EXTRACT(MONTH FROM o.orderDate) AS Month, SUM(p.PaymentAmount) AS Sales
	FROM orders o JOIN payment p ON o.PaymentID=p.PaymentID
    GROUP BY Month;

-- Mark the products as Inactive which are not ordered in last 90 days
UPDATE product p, (SELECT oi.OrderItemID, o.OrderDate, oi.ProductID FROM orderItem oi 
	JOIN orders o ON o.OrderID=oi.OrderID
    WHERE o.OrderDate < NOW() - INTERVAL 90 DAY) jt 
    SET isActive = FALSE
    WHERE jt.ProductID=p.ProductID;

SELECT * FROM product;
    

-- Given a category search keyword, display all the Products present in this category/categories. 
SELECT p.ProductID, p.ProductName, c.CategoryName FROM product p 
LEFT JOIN category c ON p.CategoryID=c.CategoryID
WHERE CategoryName='Electronics';

-- Display top 10 Items which were cancelled most.
SELECT oi.ProductID, COUNT(oi.OrderItemStatus) AS CancelCount from orderItem oi
	WHERE oi.OrderItemStatus='Cancelled'
    GROUP BY oi.ProductID
    LIMIT 10;
    

    
