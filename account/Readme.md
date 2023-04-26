This application is to view/create account for product and customer. 

API's:

***GET API(s)***

To View Accounts: http://localhost:8687/account/account

To view account for a given accountNumber: http://localhost:8687/account/account/100000100103

To view accounts for a given customerId: http://localhost:8687/account/customer/1

To view accounts for a given productId: http://localhost:8687/account/product/1

***POST API***


To create account: http://localhost:8687/account/account 

<sub> 
{
    "accountNumber": 100000100110,
    "customerId": 6,
    "productId": 1
}
</sub> 
