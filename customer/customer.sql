use customer;

CREATE TABLE customer
(
    Customer_Id          bigint auto_increment PRIMARY KEY,
    Customer_Name VARCHAR(100) NOT NULL,
    Age bigint NOT NULL,
    City VARCHAR(100) NOT NULL,
    Profile_Created_On TIMESTAMP NULL,
    Deleted VARCHAR(100) NULL,
    Modified_Time TIMESTAMP NULL
);
