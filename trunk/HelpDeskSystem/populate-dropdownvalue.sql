-- Bad. Does not let you source it from the Command Line.
-- CONNECT 'jdbc:derby://localhost:1527/HelpDeskDB;user=HelpDeskApp;password=HelpDeskApp;create=true';

DELETE FROM DropDownValue;

INSERT INTO DropDownValue VALUES 
(1, 'ISSUE', 'E-Mail'),
(2, 'ISSUE', 'Outlook'),
(3, 'ISSUE', 'Powerpoint'),
(4, 'LOCATION', 'Martino Hall'),
(5, 'LOCATION', 'Saint Josephs'),
(6, 'LOCATION', 'Fournier'),
(7, 'STATUS', 'Open'),
(8, 'STATUS', 'Closed');