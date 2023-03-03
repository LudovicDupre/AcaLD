ALTER TABLE t_articles ADD COLUMN IdCategory INT(4);
ALTER TABLE T_Articles ADD FOREIGN KEY(IdCategory) REFERENCES T_Categories(IdCategory);

SELECT * FROM t_articles;