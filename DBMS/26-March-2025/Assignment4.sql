USE storeFront;

CREATE TABLE state(
	id INT PRIMARY KEY,
    name VARCHAR(30)
);
CREATE TABLE district(
	id INT PRIMARY KEY,
	name VARCHAR(30), 
    stateId INT,
    FOREIGN KEY (stateId) REFERENCES state(id)
);
CREATE TABLE zipcode(
	id INT PRIMARY KEY,
	code INT,
    stateId INT,
    districtId INT,
    FOREIGN KEY (stateId) REFERENCES state(id),
    FOREIGN KEY (districtId) REFERENCES district(id)
);

DROP TABLE state;
DROP TABLE district;
DROP TABLE zipcode;


LOAD DATA INFILE "C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/states.csv"
	INTO TABLE state
    FIELDS TERMINATED BY ','
    LINES TERMINATED BY '\r\n'
    IGNORE 1 LINES;
    
LOAD DATA INFILE "C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/districts.csv"
	INTO TABLE district
    FIELDS TERMINATED BY ','
    LINES TERMINATED BY '\r\n'
    IGNORE 1 LINES;
    
LOAD DATA INFILE "C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/zipcodes.csv"
	INTO TABLE zipcode
    FIELDS TERMINATED BY ','
    LINES TERMINATED BY '\r\n'
    IGNORE 1 LINES;
    
-- Assignment 4
SELECT code AS Zipcode, (SELECT name FROM district WHERE id=districtId) AS City,
	(SELECT name FROM state WHERE id=stateId) AS State
    FROM zipcode WHERE code=302021 ;
    