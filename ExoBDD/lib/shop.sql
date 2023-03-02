-- - Reconstruction DB

DROP DATABASE IF EXISTS shop;
CREATE DATABASE shop;
USE shop;

-- - Construstion of shopping articles DB

CREATE TABLE T_Articles (
	IdArticles 		int(4) 		PRIMARY KEY AUTO_INCREMENT,
	Description 	varchar(30) NOT NULL,
	Brand 			varchar(30)	NOT NULL,
	UnitaryPrice	float(8)	NOT NULL
) ENGINE = InnoDB;

INSERT INTO T_Articles (Description, Brand, UnitaryPrice ) Value ('Souris',		'Logitoch',	 	65);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice ) Value ('Clavier',		'Microhard',	49.5);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice ) Value ('Systeme d''exploitation',		'Fenetres Vistouille',	 	150);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice ) Value ('Tapis souris',		'Chapeau bleu',	 	5);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice ) Value ('Cle USB 8 To',		'Syno',	 	8);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice ) Value ('Laptop',		'PH',	 	1199);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice ) Value ('CD X 500',		'CETME',	 	250);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice ) Value ('DVD-R x 100',		'CETME',	 	99);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice ) Value ('DVD+R x 100',		'CETME',	 	105);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice ) Value ('Batterie Laptop',		'PH',	 	80);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice ) Value ('Casque Audio',		'Syno',	 	105);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice ) Value ('WebCam',		'Logitoch',	 	755);


SELECT * FROM T_Articles;


