-- Switch to EmployeeDB
USE EmployeeDB;
GO

-- Create the Table as EMP_Data in SQL Server using SQL DDL Commands
CREATE TABLE EMP_Data (
    EMP_No INT,
    EMP_Name VARCHAR(100),
    EMP_Exp INT,
    EMP_Department VARCHAR(100),
    EMP_Salary INT
);

-- Insert data into the EMP_Data Table using SQL DML Commands 
INSERT INTO EMP_Data VALUES (1001, 'Alice Johnson', 2, 'IT', 70000);
INSERT INTO EMP_Data VALUES (1002, 'Bob Smith', 5, 'Analytics', 65000);
INSERT INTO EMP_Data VALUES (1003, 'Carol Martinez', 4, 'Human Resources', 72000);
INSERT INTO EMP_Data VALUES (1004, 'David Lee', 1, 'IT', 68000);
INSERT INTO EMP_Data VALUES (1005, 'Emma Davis', 6, 'Marketing', 60000);
INSERT INTO EMP_Data VALUES (1006, 'Frank Wilson', 7, 'QA', 63000);
INSERT INTO EMP_Data VALUES (1007, 'Grace Brown', 12, 'IT', 75000);
INSERT INTO EMP_Data VALUES (1008, 'Henry Miller', 10, 'Finance', 70000);
INSERT INTO EMP_Data VALUES (1009, 'Isabella Clark', 3, 'PMO', 80000);
INSERT INTO EMP_Data VALUES (1010, 'Jack Thompson', 12, 'IT', 85000);

-- Verify the Data
SELECT * FROM EMP_Data;

-- Write a query to get EMP details, who are working on same department
SELECT * 
FROM EMP_Data
WHERE EMP_Department IN (
    SELECT EMP_Department
    FROM EMP_Data
    GROUP BY EMP_Department
    HAVING COUNT(*) > 1
);