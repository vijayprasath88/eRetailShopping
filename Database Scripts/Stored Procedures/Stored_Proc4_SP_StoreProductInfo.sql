USE [RetailDatabase]
GO

/****** Object:  StoredProcedure [dbo].[SP_StoreProductInfo]    Script Date: 29-11-2016 00:44:47 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO




CREATE PROCEDURE [dbo].[SP_StoreProductInfo]
@CustomerID int,
@ProductIDs varchar(max),
@ProductQuantities varchar(max)
AS
Begin

SET @ProductIDs = REPLACE(REPLACE(@ProductIds,'[',''),']','');
SELECT @ProductQuantities AS PRODUCT_BEFORE
SET @ProductQuantities = REPLACE(REPLACE(@ProductQuantities,'[',''),']','');

 
 Create table #productids(
 ProductID varchar(max), 
 QuantityID varchar(max))
 
	insert into #productids values (@ProductIDs,@ProductQuantities);

with #tmp(ProductID,QuantityID,ProductID_s,QuantityID_s) as (
select  LEFT(ProductID, CHARINDEX(',',ProductID+',')-1),
		LEFT(QuantityID, CHARINDEX(',',QuantityID+',')-1),
		STUFF(ProductID, 1, CHARINDEX(',',ProductID+','), ''),
		STUFF(QuantityID, 1, CHARINDEX(',',QuantityID+','), '')
from	#productids
union all
select  LEFT(ProductID_s, CHARINDEX(',',ProductID_s+',')-1),
		LEFT(QuantityID_s, CHARINDEX(',',QuantityID_s+',')-1),
		STUFF(ProductID_s, 1, CHARINDEX(',',ProductID_s+','), ''),
		STUFF(QuantityID_s, 1, CHARINDEX(',',QuantityID_s+','), '')
from   #tmp
where ProductID_s > '' and QuantityID_s>''
)
select ProductID,QuantityID
into #temptest
from #tmp
order by ProductID

	IF Exists(Select 1 From Order_Placed Where Customer_Id=1 and Order_Confirmed='N') 
		BEGIN
			DELETE Order_Placed Where Customer_ID=@CustomerID and Order_Confirmed='N'
		END
	/*SET @SqlCommand='Select Product_id, into #temptest From Product_Details Where Product_Id in ('+@ProductIDs+')'
	Exec(@SqlCommand)*/

	Declare @Mypid int,
			@Myqid int

	Declare My_Cursor cursor For
		SELECT ProductID,QuantityID FROM #temptest
		Open My_Cursor
		FETCH Next From My_Cursor into @Mypid,@Myqid
		WHILE @@FETCH_STATUS = 0
		BEGIN
			exec dbo.SP_Order_Placed @CustomerID,@Mypid,@Myqid
			FETCH Next From My_Cursor into @Mypid,@Myqid
		END
		Close My_Cursor
		Deallocate My_Cursor
END


GO


