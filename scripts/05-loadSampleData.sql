-- Sample Data

USE EXERCISE;

INSERT INTO user VALUES(1, 'alfred@exercise.com', 'alfred', 'QWqw!@12');
INSERT INTO user VALUES(2, 'brenda@exercise.com', 'brenda', 'ASas!@12');
INSERT INTO user VALUES(3, 'charlie@exercise.com', 'charlie', 'ZXzx!@12');

INSERT INTO userrole VALUES(null, 1, 'Program Manager');
INSERT INTO userrole VALUES(null, 2, 'Scrum Master');
INSERT INTO userrole VALUES(null, 2, 'Software Engineer');
INSERT INTO userrole VALUES(null, 3, 'Tester');
INSERT INTO userrole VALUES(null, 3, 'Build Engineer');

INSERT INTO userhobby VALUES(null, 1, 'Golf', 'sampleDataLoader', NOW());
INSERT INTO userhobby VALUES(null, 2, 'Refactoring', 'sampleDataLoader', NOW());
INSERT INTO userhobby VALUES(null, 3, 'Failing Jira Tickets', 'sampleDataLoader', NOW());

INSERT INTO userphone VALUES(null, 1, 'OFFICE', '7035551000', 'sampleDataLoader', NOW());
INSERT INTO userphone VALUES(null, 1, 'MOBILE', '2025555309', 'sampleDataLoader', NOW());
INSERT INTO userphone VALUES(null, 2, 'MOBILE', '5715551234', 'sampleDataLoader', NOW());
INSERT INTO userphone VALUES(null, 2, 'HOME', '7035555678', 'sampleDataLoader', NOW());
-- Charlie intentionally has no phone numbers to test empty nested collection.
