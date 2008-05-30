-- Bad. Does not let you source it from the Command Line.
-- CONNECT 'jdbc:derby://localhost:1527/HelpDeskDB;user=HelpDeskApp;password=HelpDeskApp;create=true';

DROP TABLE HelpRequest;
DROP TABLE DropDownValue;

CREATE TABLE HelpRequest (
	ID INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	FirstName VARCHAR(50),
	LastName VARCHAR(50),
	EmailAddress VARCHAR(50),
	PhoneNumber VARCHAR(10),
	Urgent SMALLINT,
	Comments VARCHAR(100),
	DateEntered DATE,
	StatusID INT,
	TechnicianID INT,
	RoomNumber VARCHAR(10) NOT NULL,
	LocationID INT NOT NULL,
	IssueID INT NOT NULL
);

CREATE TABLE DropDownValue (
	ID INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	ListName VARCHAR(40) NOT NULL,
	DisplayValue VARCHAR(80)
);

INSERT INTO DropDownValue (ListName, DisplayValue) VALUES ('ISSUE', 'E-Mail');
INSERT INTO DropDownValue (ListName, DisplayValue) VALUES ('ISSUE', 'Outlook');
INSERT INTO DropDownValue (ListName, DisplayValue) VALUES ('ISSUE', 'Powerpoint');
INSERT INTO DropDownValue (ListName, DisplayValue) VALUES ('LOCATION', 'Martino Hall');
INSERT INTO DropDownValue (ListName, DisplayValue) VALUES ('LOCATION', 'Saint Josephs');
INSERT INTO DropDownValue (ListName, DisplayValue) VALUES ('LOCATION', 'Fournier');
INSERT INTO DropDownValue (ListName, DisplayValue) VALUES ('STATUS', 'Open');
INSERT INTO DropDownValue (ListName, DisplayValue) VALUES ('STATUS', 'Closed');