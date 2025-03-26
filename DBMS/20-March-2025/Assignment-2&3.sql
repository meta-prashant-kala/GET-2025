
-- Display Id, Title, Category Title, 
-- Price of the products which are Active and recently added products should be at top.
SELECT product.isActive, product.ProductID, product.ProductName, 
	category.CategoryName, product.ProductPrice 
    from product JOIN category ON 
	product.CategoryID=category.CategoryID 
    WHERE product.isActive=TRUE 
    ORDER BY product.CreatedAt DESC;
 
 -- Display the list of products which don't have any images.
 SELECT * FROM product WHERE productID NOT IN (SELECT ProductID from image);
 
 
 -- Display all Id, Title and Parent Category Title for all the Categories listed, 
 -- sorted by Parent Category Title and then Category Title. 
 -- (If Category is top category then Parent Category Title column should display 
 -- “Top Category” as value.)
 SELECT c.CategoryID, c.CategoryName,  IFNULL(p.CategoryName,'Top Category') 
	AS ParentCategory from category c 
    LEFT JOIN category p ON c.ParentCategoryID=p.CategoryID;
    
-- Display Id, Title, Parent Category Title of all the leaf Categories
-- (categories which are not parent of any other category)
 SELECT p.CategoryID, p.CategoryName, c.ParentCategoryID AS ParentCategory FROM category c
	RIGHT JOIN category p ON c.ParentCategoryID = p.CategoryID
    WHERE c.ParentCategoryID IS NULL;
    
-- Display Product Title, Price & Description which falls into particular category Title 
-- (i.e. “Mobile”)
SELECT p.ProductName, p.ProductPrice, p.ProductDesc, c.CategoryName AS ProductCategory FROM product p
	LEFT JOIN category c ON p.CategoryID=c.CategoryID
    WHERE c.CategoryName='Mobiles';
    
-- Display the list of Products whose Quantity on hand (Inventory) is under 50.    
SELECT * FROM product WHERE product.ProductStock<50;

-- Display Recent 50 (since we have 50 orders total so we are taking recent 30 orders)alter
-- Orders placed (Id, Order Date, Order Total).
SELECT o.OrderID, o.OrderDate, p.PaymentAmount from orders o
	LEFT JOIN payment p ON p.PaymentID=o.PaymentID
    ORDER BY o.OrderDate DESC
    LIMIT 30;

-- Display 10 most expensive Orders.
SELECT o.OrderID, o.OrderDate, p.PaymentAmount FROM orders o
	LEFT JOIN payment p ON p.PaymentID=o.PaymentID
    ORDER BY p.PaymentAmount DESC
    LIMIT 10;
   
   
-- Display list of shoppers which haven't ordered anything since last 
-- (Since we have data where orders are before 2 months so we'll interval of 3 month)
--  month.
SELECT u.UserID, u.UserName, o.OrderID, o.OrderDate FROM users u
	RIGHT JOIN orders o ON o.UserID=u.UserID
    WHERE NOT o.OrderDate>NOW()-INTERVAL 3 MONTH;
    
    
-- Display all the Orders which are placed more than 10 (Taking 75 Days) days old 
-- and one or more items from those orders are still not shipped.
SELECT OrderID, OrderStatus FROM orders 
	WHERE orderDate> NOW()-INTERVAL 75 DAY
	AND OrderStatus<>'Shipped';
    
-- Display list of shopper along with orders placed by them in last 15 days
-- (Since we have data where orders are before 2 months so we'll interval of 75 month)
SELECT u.UserID, u.UserName, o.OrderID, o.OrderDate FROM users u
	RIGHT JOIN orders o ON o.UserID=u.UserID
    WHERE o.OrderDate > NOW() - INTERVAL 75 DAY;
    
    
-- Display list of order items along with order placed date 
-- which fall between Rs 20 to Rs 50 price.
SELECT oi.OrderItemID, oi.OrderItemStatus, o.OrderDate , oi.OrderItemPrice 
	FROM orderItem oi LEFT JOIN orders o
    ON oi.OrderID=o.OrderID
	WHERE oi.OrderItemStatus='Shipped'
    AND oi.OrderItemPrice >= 500 
    AND oi.OrderItemPrice <= 5000;
    
    
