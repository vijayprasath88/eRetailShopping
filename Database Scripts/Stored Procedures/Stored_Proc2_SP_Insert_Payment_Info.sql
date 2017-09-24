USE [RetailDatabase]
GO

/****** Object:  StoredProcedure [dbo].[SP_Insert_Payment_Info]    Script Date: 29-11-2016 00:43:56 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO




CREATE Procedure [dbo].[SP_Insert_Payment_Info](
@Customer_Id int,
@Account_Number varchar(50),
@CVV int,
@Name_On_Card Varchar(100),
@Month int,
@Year int)

AS
Begin
SET NOCOUNT ON
DECLARE @Flag int = 0;
IF EXISTS(SELECT 1 FROM Customer_Payment WHERE Customer_Id = @Customer_Id)
  BEGIN
  DELETE FROM Customer_Payment WHERE Customer_Id = @Customer_Id
  INSERT INTO Customer_Payment VALUES (@Customer_Id,@Account_Number,@CVV,@Name_On_Card,@Month,@Year);
		IF(LEN(@Account_Number)=19)
		 BEGIN
			SET @Flag = 2;
		 END
		ELSE
		 BEGIN
		 SET @Flag = 1;
		 END
  END
ELSE
 BEGIN
 INSERT INTO Customer_Payment VALUES (@Customer_Id,@Account_Number,@CVV,@Name_On_Card,@Month,@Year);
 IF(LEN(@Account_Number)=19)
		 BEGIN
			SET @Flag = 2;
		 END
		ELSE
		 BEGIN
		 SET @Flag = 1;
		 END
 END

 SELECT @Flag AS flag
End
SET NOCOUNT OFF





GO


