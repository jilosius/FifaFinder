
CREATE TABLE competes_in (
  Overall INT NULL,
   Attack INT NULL,
   Midfield INT NULL,
   Defence INT NULL,
   FifaVersion INT NOT NULL,
   ClubID INT NOT NULL,
   LeagueID INT NOT NULL,
   CONSTRAINT pk_competes_in PRIMARY KEY (FifaVersion, ClubID, LeagueID)
);

CREATE TABLE fifa_version (
  FifaVersion INT NOT NULL,
   CONSTRAINT pk_fifa_version PRIMARY KEY (FifaVersion)
);

CREATE TABLE is_from (
  PlayerID INT NOT NULL,
   CountryID INT NOT NULL,
   CONSTRAINT pk_is_from PRIMARY KEY (PlayerID, CountryID)
);

CREATE TABLE is_located_at (
  LeagueID INT NOT NULL,
   CountryID INT NOT NULL,
   CONSTRAINT pk_is_located_at PRIMARY KEY (LeagueID, CountryID)
);

CREATE TABLE land (
  CountryID INT NOT NULL,
   CountryName VARCHAR(255) NULL,
   Flag VARCHAR(255) NULL,
   CONSTRAINT pk_land PRIMARY KEY (CountryID)
);

CREATE TABLE liga (
  LeagueID INT NOT NULL,
   League VARCHAR(255) NOT NULL,
   Logo VARCHAR(255) NULL,
   CONSTRAINT pk_liga PRIMARY KEY (LeagueID)
);

CREATE TABLE mannschaften (
  ClubID INT NOT NULL,
   ClubName VARCHAR(255) NULL,
   ClubLogo VARCHAR(255) NULL,
   CONSTRAINT pk_mannschaften PRIMARY KEY (ClubID)
);

CREATE TABLE plays_for (
  Height INT NULL,
   ClubPosition VARCHAR(255) NULL,
   ClubNumber INT NULL,
   NationalPosition VARCHAR(255) NULL,
   NationalNumber INT NULL,
   PreferredFoot VARCHAR(255) NULL,
   ContractUntil INT NULL,
   OnLoan VARCHAR(15) NULL,
   NationalTeam VARCHAR(255) NULL,
   Age INT NULL,
   Weight INT NULL,
   Overall INT NULL,
   Potential INT NULL,
   BestPosition VARCHAR(255) NULL,
   ClubID INT NULL,
   ValueEUR BIGINT NULL,
   Wage BIGINT NULL,
   ReleaseClause BIGINT NULL,
   IntReputation INT NULL,
   WeakFoot INT NULL,
   SkillMoves INT NULL,
   Cossing INT NULL,
   Finishing INT NULL,
   HeadingAccuracy INT NULL,
   ShortPassing INT NULL,
   Volleys INT NULL,
   Dribbling INT NULL,
   Curve INT NULL,
   FKAccuracy INT NULL,
   LongPassing INT NULL,
   BallControl INT NULL,
   Acceleration INT NULL,
   SprintSpeed INT NULL,
   Agility INT NULL,
   Reaction INT NULL,
   Balance INT NULL,
   ShotPower INT NULL,
   Jumping INT NULL,
   Stamina INT NULL,
   Strength INT NULL,
   LongShots INT NULL,
   Aggression INT NULL,
   Interceptions INT NULL,
   Positioning INT NULL,
   Vision INT NULL,
   Penalties INT NULL,
   Composure INT NULL,
   Marking INT NULL,
   StandingTackle INT NULL,
   SlidingTackle INT NULL,
   GKDiving INT NULL,
   GKHandling INT NULL,
   GKKicking INT NULL,
   GKPositioning INT NULL,
   GKReflexes INT NULL,
   PhotoUrl VARCHAR(255) NULL,
   PlayerID INT NOT NULL,
   FifaVersion INT NOT NULL,
   CONSTRAINT pk_plays_for PRIMARY KEY (PlayerID, FifaVersion)
);

CREATE TABLE spieler (
  PlayerID INT NOT NULL,
   KnownName VARCHAR(255) NULL,
   FullName VARCHAR(255) NULL,
   birthDate date NULL,
   CONSTRAINT pk_spieler PRIMARY KEY (PlayerID)
);

ALTER TABLE competes_in ADD CONSTRAINT FK_COMPETES_IN_ON_CLUBID FOREIGN KEY (ClubID) REFERENCES mannschaften (ClubID);

ALTER TABLE competes_in ADD CONSTRAINT FK_COMPETES_IN_ON_FIFAVERSION FOREIGN KEY (FifaVersion) REFERENCES fifa_version (FifaVersion);

ALTER TABLE competes_in ADD CONSTRAINT FK_COMPETES_IN_ON_LEAGUEID FOREIGN KEY (LeagueID) REFERENCES liga (LeagueID);

ALTER TABLE is_from ADD CONSTRAINT FK_IS_FROM_ON_COUNTRYID FOREIGN KEY (CountryID) REFERENCES land (CountryID);

ALTER TABLE is_from ADD CONSTRAINT FK_IS_FROM_ON_PLAYERID FOREIGN KEY (PlayerID) REFERENCES spieler (PlayerID);

ALTER TABLE is_located_at ADD CONSTRAINT FK_IS_LOCATED_AT_ON_COUNTRYID FOREIGN KEY (CountryID) REFERENCES land (CountryID);

ALTER TABLE is_located_at ADD CONSTRAINT FK_IS_LOCATED_AT_ON_LEAGUEID FOREIGN KEY (LeagueID) REFERENCES liga (LeagueID);

ALTER TABLE plays_for ADD CONSTRAINT FK_PLAYS_FOR_ON_CLUBID FOREIGN KEY (ClubID) REFERENCES mannschaften (ClubID);

ALTER TABLE plays_for ADD CONSTRAINT FK_PLAYS_FOR_ON_FIFAVERSION FOREIGN KEY (FifaVersion) REFERENCES fifa_version (FifaVersion);

ALTER TABLE plays_for ADD CONSTRAINT FK_PLAYS_FOR_ON_PLAYERID FOREIGN KEY (PlayerID) REFERENCES spieler (PlayerID);