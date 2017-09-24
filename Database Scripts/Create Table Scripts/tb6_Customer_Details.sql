USE [RetailDatabase]
GO

/****** Object:  Table [dbo].[Customer_Details]    Script Date: 29-11-2016 00:41:55 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Customer_Details](
	[Customer_Id] [int] NULL,
	[Gender] [char](1) NULL,
	[Age] [int] NULL,
	[Door_No] [int] NULL,
	[Street] [varchar](100) NULL,
	[City] [varchar](50) NULL,
	[State] [varchar](50) NULL,
	[Country] [varchar](50) NULL
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[Customer_Details]  WITH CHECK ADD FOREIGN KEY([Customer_Id])
REFERENCES [dbo].[Customer_Login] ([Customer_Id])
GO

ALTER TABLE [dbo].[Customer_Details]  WITH CHECK ADD FOREIGN KEY([Customer_Id])
REFERENCES [dbo].[Customer_Login] ([Customer_Id])
GO


