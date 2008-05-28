connect 'jdbc:derby://localhost:1527/HelpDeskDB;user=HelpDeskApp;password=HelpDeskApp;create=true';

drop table HELPREQUEST;
drop table DROPDOWNVALUE;

create table HELPREQUEST (
	ID INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
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

create table DROPDOWNVALUE (
	ID INT NOT NULL primary key,
	ListName VARCHAR(40) NOT NULL,
	DisplayValue VARCHAR(80)
);