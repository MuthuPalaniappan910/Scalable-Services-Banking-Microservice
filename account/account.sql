use account;

CREATE TABLE account
(
    Account_Id          bigint auto_increment PRIMARY KEY,
    Account_Number bigint NOT NULL,
    Customer_Id bigint NOT NULL,
    Product_Id bigint NOT NULL
);

Insert into account values (1,100000100100, 1, 1);
Insert into account values (2,100000100101, 2, 1);
Insert into account values (3,100000100103, 1, 2);
Insert into account values (4,100000100104, 1, 4);
Insert into account values (5,100000100105, 2, 4);
Insert into account values (6,100000100106, 3, 4);
Insert into account values (7,100000100107, 4, 3);
Insert into account values (8,100000100108, 4, 5);
