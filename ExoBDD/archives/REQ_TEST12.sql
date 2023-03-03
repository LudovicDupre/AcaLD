CREATE TABLE T_Categories (
	IdCategories		int(4) 		PRIMARY KEY AUTO_INCREMENT,
	CatName 			varchar(30) NOT NULL,
	Description 			VARCHAR(100)	NOT NULL
) ENGINE = InnoDB;

INSERT INTO T_Categories (IdCategories, CatName, Description ) VALUE (1, 'Materiel info', 'Indispensable à un PC');
INSERT INTO T_Categories (IdCategories, CatName, Description ) VALUE (2, 'Logiciel', 'SE, Antivirus, IDE ...');
INSERT INTO T_Categories (IdCategories, CatName, Description ) VALUE (3, 'PC', 'Laptop et micro ordi');

SELECT * FROM T_Categories;