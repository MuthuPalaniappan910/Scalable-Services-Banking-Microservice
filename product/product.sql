use product;

CREATE TABLE account
(
    Category_Id          bigint auto_increment PRIMARY KEY,
    Category VARCHAR(100) NULL
);

CREATE TABLE product
(
    Product_Id          bigint auto_increment PRIMARY KEY,
    Product VARCHAR(100) NULL,
    Category_Id bigint NOT NULL,
    FOREIGN KEY (Category_Id)
        REFERENCES account(Category_Id)
);


Insert into account values (1,'Savings');
Insert into account values (2,'Credit');
Insert into account values (3,'Loan');

Insert into product values(1,'SA1',1);
Insert into product values(2,'SA2',1);
Insert into product values(3,'CR1',2);
Insert into product values(4,'L1',3);
Insert into product values(5,'L2',3);
Insert into product values(6,'CR2',2);