CREATE USER 'ludovic'@'localhost' IDENTIFIED BY 'password';

SELECT HOST,USER FROM mysql.user;

GRANT ALL ON shop.* TO 'ludovic'@localhost';