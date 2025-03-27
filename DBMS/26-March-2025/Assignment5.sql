USE storeFront;

-- Create a view displaying the order information 
-- (Id, Title, Price, Shopper’s name, Email, Orderdate, Status) 
-- with latest ordered items should be displayed first for last 60 days.

CREATE VIEW OrderInformation AS

SELECT jt4.OrderID, jt4.ProductName, jt4.ProductPrice, jt5.UserName, jt5.Email, jt5.OrderDate, jt5.OrderStatus
	FROM (SELECT jt1.OrderID, p.ProductName, p.ProductPrice from product p 
    JOIN (SELECT o.OrderID , oi.ProductID FROM orders o 
    JOIN orderItem oi ON o.OrderID=oi.OrderID) jt1
    ON p.ProductID=jt1.ProductID) jt4
    JOIN (SELECT u.UserName, u.Email, jt2.OrderID, jt2.OrderDate, jt2.OrderStatus 
    FROM users u JOIN  
    (SELECT o.UserID, o.OrderID , oi.ProductID, o.OrderDate, o.OrderStatus
	FROM orders o JOIN 
    orderItem oi ON o.OrderID=oi.OrderID) jt2
    ON u.UserID=jt2.UserID) jt5 ON jt4.OrderID=jt5.OrderID
    WHERE jt5.OrderDate > NOW() - INTERVAL 90 DAY;

-- Use the above view to display the Products(Items) which are in ‘shipped’ state.
SELECT OrderID, ProductName, OrderStatus FROM OrderInformation WHERE OrderStatus='Shipped';


-- Use the above view to display the top 5 most selling products.
SELECT ProductName, COUNT(ProductName) AS ProductCount 
	FROM OrderInformation GROUP BY ProductName;

    
