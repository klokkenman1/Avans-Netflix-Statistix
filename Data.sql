/*    ==Scripting Parameters==

    Source Server Version : SQL Server 2016 (13.0.4001)
    Source Database Engine Edition : Microsoft SQL Server Express Edition
    Source Database Engine Type : Standalone SQL Server

    Target Server Version : SQL Server 2017
    Target Database Engine Edition : Microsoft SQL Server Standard Edition
    Target Database Engine Type : Standalone SQL Server
*/
USE [NetFlix]
GO
SET IDENTITY_INSERT [dbo].[Account] ON 

INSERT [dbo].[Account] ([Abonneenummer], [Naam], [Straat], [Postcode], [Huisnummer], [Plaats]) VALUES (1, N'Levi', N'beverlaan', N'2640QV', N'58', N'Breda')
INSERT [dbo].[Account] ([Abonneenummer], [Naam], [Straat], [Postcode], [Huisnummer], [Plaats]) VALUES (2, N'Hans', N'emmalaan', N'4822SV', N'29', N'Rotterdam')
INSERT [dbo].[Account] ([Abonneenummer], [Naam], [Straat], [Postcode], [Huisnummer], [Plaats]) VALUES (3, N'Kees', N'huisstraat', N'5383TF', N'285', N'Amsterdam')
SET IDENTITY_INSERT [dbo].[Account] OFF
INSERT [dbo].[Profiel] ([Abonneenummer], [Naam], [Geboortedatum]) VALUES (1, N'Levi', CAST(N'2018-01-13' AS Date))
INSERT [dbo].[Profiel] ([Abonneenummer], [Naam], [Geboortedatum]) VALUES (2, N'Gert', CAST(N'2018-01-13' AS Date))
INSERT [dbo].[Profiel] ([Abonneenummer], [Naam], [Geboortedatum]) VALUES (2, N'Hans', CAST(N'2018-01-13' AS Date))
INSERT [dbo].[Profiel] ([Abonneenummer], [Naam], [Geboortedatum]) VALUES (3, N'Kees', CAST(N'2018-01-13' AS Date))
SET IDENTITY_INSERT [dbo].[Programma] ON 

INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (1, N'Film1', CAST(N'02:00:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (2, N'Film2', CAST(N'02:15:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (3, N'Film3', CAST(N'01:18:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (4, N'Film4', CAST(N'02:08:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (5, N'A Studie in Pink', CAST(N'01:28:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (6, N'The Blind Banker
', CAST(N'01:28:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (7, N'The Great Game
', CAST(N'01:28:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (8, N'A Scandal in Belgravia
', CAST(N'01:28:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (9, N'The Hounds of Baskerville
', CAST(N'01:28:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (10, N'The Reichenbach Fall
', CAST(N'01:28:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (11, N'The Empty Hearse
', CAST(N'01:28:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (12, N'The Sign of Three
', CAST(N'01:28:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (13, N'His Last Vow
', CAST(N'01:28:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (14, N'Pilot
', CAST(N'00:58:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (15, N'Cat’s in the Bag…
', CAST(N'00:48:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (16, N'…And the Bag’s in the River
', CAST(N'00:48:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (17, N'Cancer Man
', CAST(N'00:48:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (18, N'Gray Matter
', CAST(N'00:48:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (19, N'Crazy Handful of Nothin’
', CAST(N'00:48:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (20, N'A No-Rough-Stuff-Type Deal
', CAST(N'00:48:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (21, N'Seven Thirty-Seven
', CAST(N'00:48:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (22, N'Grilled
', CAST(N'00:48:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (23, N'Bit by a Dead Bee
', CAST(N'00:48:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (24, N'Down
', CAST(N'00:48:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (25, N'Breakage
', CAST(N'00:48:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (26, N'Peekaboo
', CAST(N'00:48:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (27, N'Negro Y Azul
', CAST(N'00:48:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (28, N'Better Call Saul
', CAST(N'00:48:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (29, N'4 Days Out
', CAST(N'00:48:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (30, N'Over
', CAST(N'00:48:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (31, N'Mandala
', CAST(N'00:48:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (32, N'Phoenix
', CAST(N'00:48:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (33, N'ABQ
', CAST(N'00:48:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (34, N'The Crocodile''s Dilemma
', CAST(N'01:08:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (35, N'The Rooster Prince
', CAST(N'01:08:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (36, N'A Muddy Road
', CAST(N'01:08:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (37, N'Eating the Blame
', CAST(N'01:08:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (38, N'The Six Ungraspables
', CAST(N'01:08:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (39, N'Buridan''s Ass
', CAST(N'01:08:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (40, N'Who Shaves the Barber?
', CAST(N'01:08:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (41, N'The Heap
', CAST(N'01:08:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (42, N'A Fox, a Rabbit, and a Cabbage
', CAST(N'01:08:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (43, N'Morton''s Fork
', CAST(N'01:08:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (44, N'Waiting for Dutch
', CAST(N'01:08:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (45, N'Before the Law
', CAST(N'01:08:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (46, N'The Myth of Sisyphus
', CAST(N'01:08:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (47, N'The Gift of the Magi
', CAST(N'01:08:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (48, N'Fear and Trembling
', CAST(N'01:08:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (49, N'Rhinoceros
', CAST(N'01:08:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (50, N'Did you do this? No, you did it!
', CAST(N'01:08:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (51, N'Loplop
', CAST(N'01:08:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (52, N'The Castle
', CAST(N'01:08:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (53, N'Palindrome
', CAST(N'01:08:00' AS Time))
INSERT [dbo].[Programma] ([ProgrammaID], [Titel], [Tijdsduur]) VALUES (54, NULL, NULL)
SET IDENTITY_INSERT [dbo].[Programma] OFF
INSERT [dbo].[Bekeken] ([Abonneenummer], [Naam], [Gezien], [Percentage]) VALUES (1, N'Levi', 5, 100)
INSERT [dbo].[Bekeken] ([Abonneenummer], [Naam], [Gezien], [Percentage]) VALUES (1, N'Levi', 6, 100)
INSERT [dbo].[Bekeken] ([Abonneenummer], [Naam], [Gezien], [Percentage]) VALUES (1, N'Levi', 7, 50)
INSERT [dbo].[Bekeken] ([Abonneenummer], [Naam], [Gezien], [Percentage]) VALUES (2, N'Hans', 5, 100)
SET IDENTITY_INSERT [dbo].[Serie] ON 

INSERT [dbo].[Serie] ([SerieID], [Naam], [Leeftijd], [Taal], [Genre], [LijktOp]) VALUES (2, N'Sherlock', 12, N'Engels', N'Detective', 4)
INSERT [dbo].[Serie] ([SerieID], [Naam], [Leeftijd], [Taal], [Genre], [LijktOp]) VALUES (3, N'Breaking Bad', 16, N'Engels-Amerikaans', N'Spanning', 4)
INSERT [dbo].[Serie] ([SerieID], [Naam], [Leeftijd], [Taal], [Genre], [LijktOp]) VALUES (4, N'Fargo', 16, N'Engels-Amerikaans', N'Spanning', 3)
SET IDENTITY_INSERT [dbo].[Serie] OFF
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (5, 2, N'1')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (6, 2, N'1')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (7, 2, N'1')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (8, 2, N'2')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (9, 2, N'2')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (10, 2, N'2')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (11, 2, N'3')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (12, 2, N'3')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (13, 2, N'3')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (14, 3, N'1')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (15, 3, N'1')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (16, 3, N'1')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (17, 3, N'1')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (18, 3, N'1')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (19, 3, N'1')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (20, 3, N'1')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (21, 3, N'2')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (22, 3, N'2')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (23, 3, N'2')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (24, 3, N'2')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (25, 3, N'2')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (26, 3, N'2')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (27, 3, N'2')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (28, 3, N'2')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (29, 3, N'2')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (30, 3, N'2')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (31, 3, N'2')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (32, 3, N'2')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (33, 3, N'2')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (34, 4, N'1')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (35, 4, N'1')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (36, 4, N'1')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (37, 4, N'1')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (38, 4, N'1')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (39, 4, N'1')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (40, 4, N'1')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (41, 4, N'1')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (42, 4, N'1')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (43, 4, N'1')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (44, 4, N'2')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (45, 4, N'2')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (46, 4, N'2')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (47, 4, N'2')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (48, 4, N'2')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (49, 4, N'2')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (50, 4, N'2')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (51, 4, N'2')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (52, 4, N'2')
INSERT [dbo].[Aflevering] ([AfleveringID], [Serie], [Seizoen]) VALUES (53, 4, N'2')
INSERT [dbo].[Film] ([FilmID], [Leeftijdsindicatie], [Taal], [Genre]) VALUES (1, 16, N'Engels', N'Horror')
INSERT [dbo].[Film] ([FilmID], [Leeftijdsindicatie], [Taal], [Genre]) VALUES (2, 16, N'Engels', N'Horror')
INSERT [dbo].[Film] ([FilmID], [Leeftijdsindicatie], [Taal], [Genre]) VALUES (3, 12, N'Engels', N'Comedy')
INSERT [dbo].[Film] ([FilmID], [Leeftijdsindicatie], [Taal], [Genre]) VALUES (4, 15, N'Engels', N'Comedy')
