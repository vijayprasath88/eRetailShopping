---- Registration Script in Java------------
select * from Customer_Login where Customer_Email=?

-------Login Scripts in Java------------
insert into Customer_Login values(?,?,?,?)
Select * from Customer_Login where Customer_Email =? and Password=?


-----Category script in Java----
select * from Category


--ProductDetailsbasedonCategoryscript in Java----
select * From Product_Details where Category_Id = ?

--- Stored Procedure call to insert Product Ids
call SP_StoreProductInfo(?, ?, ?)

--Stored Procedure to get Total payment of products
call SP_GetTotalPayment(?)

--SQL script to retrieve customer payment
select * from Customer_Payment where Customer_Id = ?

--Calling Stored Procedure to insert Credit Card information
call SP_Insert_Payment_Info(?,?,?,?,?,?)

--- SQL Scripts to choose order scripts and update Order Confirmed Details
select * from Order_Placed where Customer_Id = ?

UPDATE Order_Placed SET Order_Confirmed = 'Y' WHERE Customer_Id = ?

