USE [RetailDatabase]
GO

/****** Object:  Table [dbo].[Customer_Login]    Script Date: 29-11-2016 00:39:51 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Customer_Login](
	[Customer_Id] [int] IDENTITY(1,1) NOT NULL,
	[Customer_Email] [varchar](50) NOT NULL,
	[Password] [varchar](50) NOT NULL,
	[Status] [char](1) NULL,
	[Created_Date] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[Customer_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


