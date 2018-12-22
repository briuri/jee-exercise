-- Loads the exercise user for mySQL.
create user 'exercise'@'73.251.195.64' IDENTIFIED by '<insertPasswordHere>';
grant delete, insert, select, update on exercise.* to 'exercise'@'73.251.195.64';
create user 'exercise'@'172.31.63.211' IDENTIFIED by '<insertPasswordHere>';
grant delete, insert, select, update on exercise.* to 'exercise'@'172.31.63.211';
flush privileges;
