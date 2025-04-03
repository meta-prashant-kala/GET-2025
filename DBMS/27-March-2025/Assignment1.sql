-- Create a function to calculate number of orders in a month. Month and year will be input parameter to function.
DELIMITER $$
CREATE FUNCTION storeFront.CalcNumOfProdInMonth(Month INT, Year INT)
RETURNS INT 
DETERMINISTIC
BEGIN
	DECLARE orderCount INT;
    (SELECT COUNT(OrderID) INTO orderCount from orders 
    WHERE Month=EXTRACT(MONTH FROM OrderDate) 
    AND YEAR=EXTRACT(YEAR FROM OrderDate));
    RETURN orderCount;
END $$
DELIMITER ;

SELECT storeFront.CalcNumOfProdInMonth(11,2024) AS NumberOfMonths;

-- Create a function to return month in a year having maximum orders. Year will be input parameter.
DELIMITER $$
CREATE FUNCTION storeFront.getMaxOrderInYear(inputYear INT)
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE maxOrderMonth INT;
    SELECT  MONTH(OrderDate) AS OrderMonth  INTO maxOrderMonth
	FROM orders WHERE YEAR(OrderDate)=inputYear
    GROUP BY OrderMonth
    ORDER BY COUNT(OrderId) DESC 
    LIMIT 1;
    RETURN maxOrderMonth;
END $$
DELIMITER ;
USE storeFront;
SELECT * FROM orders;

SELECT storeFront.getMaxOrderInYear(2024) AS MaxOrders;
