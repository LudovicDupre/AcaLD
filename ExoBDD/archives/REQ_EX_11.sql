CREATE USER 'alexander'@'localhost' IDENTIFIED BY 'password';

SELECT HOST,USER FROM mysql.user;

GRANT ALL ON ECourses.* TO 'alexander'@localhost';