CREATE DATABASE [NetFlix]
GO
USE [NetFlix]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 13/01/2018 16:38:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[Abonneenummer] [int] IDENTITY(1,1) NOT NULL,
	[Naam] [nvarchar](50) NULL,
	[Straat] [nvarchar](50) NULL,
	[Postcode] [nchar](6) NULL,
	[Huisnummer] [nvarchar](5) NULL,
	[Plaats] [nvarchar](50) NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[Abonneenummer] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Aflevering]    Script Date: 13/01/2018 16:38:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Aflevering](
	[AfleveringID] [int] NOT NULL,
	[Serie] [int] NULL,
	[Seizoen] [nvarchar](50) NULL,
 CONSTRAINT [PK_Afleverin] PRIMARY KEY CLUSTERED 
(
	[AfleveringID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Bekeken]    Script Date: 13/01/2018 16:38:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Bekeken](
	[Abonneenummer] [int] NOT NULL,
	[Naam] [nvarchar](50) NOT NULL,
	[Gezien] [int] NOT NULL,
	[Percentage] [int] NULL,
 CONSTRAINT [PK_Bekeken] PRIMARY KEY CLUSTERED 
(
	[Abonneenummer] ASC,
	[Naam] ASC,
	[Gezien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Film]    Script Date: 13/01/2018 16:38:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Film](
	[FilmID] [int] NOT NULL,
	[Leeftijdsindicatie] [int] NULL,
	[Taal] [nvarchar](50) NULL,
	[Genre] [nvarchar](50) NULL,
 CONSTRAINT [PK_Film] PRIMARY KEY CLUSTERED 
(
	[FilmID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Profiel]    Script Date: 13/01/2018 16:38:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Profiel](
	[Abonneenummer] [int] NOT NULL,
	[Naam] [nvarchar](50) NOT NULL,
	[Geboortedatum] [date] NULL,
 CONSTRAINT [PK_Profiel] PRIMARY KEY CLUSTERED 
(
	[Abonneenummer] ASC,
	[Naam] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Programma]    Script Date: 13/01/2018 16:38:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Programma](
	[ProgrammaID] [int] IDENTITY(1,1) NOT NULL,
	[Titel] [nvarchar](50) NULL,
	[Tijdsduur] [time](7) NULL,
 CONSTRAINT [PK_Programma] PRIMARY KEY CLUSTERED 
(
	[ProgrammaID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Serie]    Script Date: 13/01/2018 16:38:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Serie](
	[SerieID] [int] IDENTITY(1,1) NOT NULL,
	[Naam] [nvarchar](50) NULL,
	[Leeftijd] [int] NULL,
	[Taal] [nvarchar](50) NULL,
	[Genre] [nvarchar](50) NULL,
	[LijktOp] [int] NULL,
 CONSTRAINT [PK_Serie] PRIMARY KEY CLUSTERED 
(
	[SerieID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Aflevering]  WITH CHECK ADD  CONSTRAINT [FK_Aflevering_Programma] FOREIGN KEY([AfleveringID])
REFERENCES [dbo].[Programma] ([ProgrammaID])
GO
ALTER TABLE [dbo].[Aflevering] CHECK CONSTRAINT [FK_Aflevering_Programma]
GO
ALTER TABLE [dbo].[Aflevering]  WITH CHECK ADD  CONSTRAINT [FK_Aflevering_Serie] FOREIGN KEY([Serie])
REFERENCES [dbo].[Serie] ([SerieID])
GO
ALTER TABLE [dbo].[Aflevering] CHECK CONSTRAINT [FK_Aflevering_Serie]
GO
ALTER TABLE [dbo].[Bekeken]  WITH CHECK ADD  CONSTRAINT [FK_Bekeken_Account] FOREIGN KEY([Abonneenummer])
REFERENCES [dbo].[Account] ([Abonneenummer])
GO
ALTER TABLE [dbo].[Bekeken] CHECK CONSTRAINT [FK_Bekeken_Account]
GO
ALTER TABLE [dbo].[Bekeken]  WITH CHECK ADD  CONSTRAINT [FK_Bekeken_Profiel] FOREIGN KEY([Abonneenummer], [Naam])
REFERENCES [dbo].[Profiel] ([Abonneenummer], [Naam])
GO
ALTER TABLE [dbo].[Bekeken] CHECK CONSTRAINT [FK_Bekeken_Profiel]
GO
ALTER TABLE [dbo].[Bekeken]  WITH CHECK ADD  CONSTRAINT [FK_Bekeken_Programma] FOREIGN KEY([Gezien])
REFERENCES [dbo].[Programma] ([ProgrammaID])
GO
ALTER TABLE [dbo].[Bekeken] CHECK CONSTRAINT [FK_Bekeken_Programma]
GO
ALTER TABLE [dbo].[Film]  WITH CHECK ADD  CONSTRAINT [FK_Film_Programma] FOREIGN KEY([FilmID])
REFERENCES [dbo].[Programma] ([ProgrammaID])
GO
ALTER TABLE [dbo].[Film] CHECK CONSTRAINT [FK_Film_Programma]
GO
ALTER TABLE [dbo].[Profiel]  WITH CHECK ADD  CONSTRAINT [FK_Profiel_Account] FOREIGN KEY([Abonneenummer])
REFERENCES [dbo].[Account] ([Abonneenummer])
GO
ALTER TABLE [dbo].[Profiel] CHECK CONSTRAINT [FK_Profiel_Account]
GO
