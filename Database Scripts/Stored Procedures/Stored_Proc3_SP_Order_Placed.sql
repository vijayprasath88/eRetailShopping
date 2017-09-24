USE [RetailDatabase]
GO

/****** Object:  StoredProcedure [dbo].[SP_Order_Placed]    Script Date: 29-11-2016 00:44:22 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO



CREATE PROCEDURE [dbo].[SP_Order_Placed]
@CustomerID int,
@ProductID int,
@QuantityID INT
AS
Begin

Declare @Amount Money
SET @QuantityID=ISNULL(@QuantityID,0)

SET @Amount=(SELECT (P.Price*@QuantityID) 
			FROM Product_Details P
			WHERE P.Product_Id=@ProductID)

INSERT INTO Order_Placed VALUES(@CustomerID,@ProductID,GETDATE(),@Amount,'N')
End

GO


