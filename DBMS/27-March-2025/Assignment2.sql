-- Create a Stored procedure to retrieve average sales of each product in a month. Month and year will be input parameter to function.
DELIMITER //
CREATE PROCEDURE USP_avgMonthSale (inputMonth INT, inputYear INT)
       BEGIN
         SELECT p.ProductID, AVG(p.ProductPrice*jt.OrderItemQuantity) AS AverageSale
			FROM product p JOIN
			(SELECT oi.OrderItemID, oi.ProductID,
			(SELECT OrderDate FROM orders o WHERE oi.OrderID=o.OrderID) AS OrderDate, 
			oi.OrderItemQuantity
			FROM orderItem oi) jt ON p.ProductID=jt.ProductID
			WHERE MONTH(jt.OrderDate)=inputMonth AND YEAR(jt.OrderDate)=inputYear
			GROUP BY p.ProductID;
       END//
DELIMITER ;

CALL storeFront.USP_avgMonthSale(11,2024);

-- Create a stored procedure to retrieve table having order detail with status for a given period. 
-- Start date and end date will be input parameter. 
-- Put validation on input dates like start date is less than end date. 
-- If start date is greater than end date take first date of month as start date.
DELIMITER //
CREATE PROCEDURE storeFront.USP_OrderDetails(startDate DATE, endDate DATE)
	BEGIN
		IF startDate>endDate THEN 
			SET startDate = endDate - INTERVAL (DAY(endDate) - 1) DAY;
		END IF;
		SELECT OrderID, OrderDate, OrderStatus FROM orders
        WHERE OrderDate >= startDate
        AND OrderDate <= endDate ;
    END//
DELIMITER ;
-- if date 2024-03-23 and 2024-01-03 , then date will be set on 2024-03-01 
DROP PROCEDURE storeFront.USP_OrderDetails;
SHOW FUNCTION STATUS;

CALL storeFront.USP_OrderDetails('2024-11-29','2024-11-27');

    
    