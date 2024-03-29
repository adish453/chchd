-- Bad. Does not let you source it from the Command Line.
-- CONNECT 'jdbc:derby://localhost:1527/HelpDeskDB;user=HelpDeskApp;password=HelpDeskApp;create=true';

CREATE TABLE HelpDeskApp.HelpRequest (
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

CREATE TABLE HelpDeskApp.DropDownValue (
	ID INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	ListName VARCHAR(40) NOT NULL,
	DisplayValue VARCHAR(80)
);