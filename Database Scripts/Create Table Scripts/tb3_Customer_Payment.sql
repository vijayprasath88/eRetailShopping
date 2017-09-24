USE [RetailDatabase]
GO

/****** Object:  Table [dbo].[Customer_Payment]    Script Date: 29-11-2016 00:40:15 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Customer_Payment](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Customer_Id] [int] NULL,
	[Account_Number] [varchar](50) NULL,
	[CVV] [int] NULL,
	[Name_On_Card] [varchar](50) NULL,
	[Month] [int] NULL,
	[Year] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[Customer_Payment]  WITH CHECK ADD FOREIGN KEY([Customer_Id])
REFERENCES [dbo].[Customer_Login] ([Customer_Id])
GO

ALTER TABLE [dbo].[Customer_Payment]  WITH CHECK ADD FOREIGN KEY([Customer_Id])
REFERENCES [dbo].[Customer_Login] ([Customer_Id])
GO


