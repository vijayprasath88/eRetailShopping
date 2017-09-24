USE [RetailDatabase]
GO

/****** Object:  StoredProcedure [dbo].[SP_GetTotalPayment]    Script Date: 29-11-2016 00:42:49 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO




CREATE procedure [dbo].[SP_GetTotalPayment] 
@Customer_Id int
AS
SET NOCOUNT ON
Begin

SELECT SUM(Order_Amount) AS Total_Payment FROM Order_Placed
WHERE Customer_Id = @Customer_Id 
AND   Order_Confirmed = 'N'

end

SET NOCOUNT OFF

GO


