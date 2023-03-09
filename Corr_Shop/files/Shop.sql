-- ------------------------------------------------------------------------------
-- - Reconstruction de la base de données                                     ---
-- ------------------------------------------------------------------------------
DROP DATABASE IF EXISTS Shop;
CREATE DATABASE Shop;
USE Shop;

-- -----------------------------------------------------------------------------
-- - Construction de la table des utilisateurs                               ---
-- -----------------------------------------------------------------------------
CREATE TABLE T_Users (
	IdUser				int(4)		PRIMARY KEY AUTO_INCREMENT,
	Login				varchar(20)	NOT NULL UNIQUE,
	Password			varchar(20)	NOT NULL
) ENGINE = InnoDB;

INSERT INTO T_Users (IdUser, Login, Password) VALUES ( 1, 'Anderson' ,	'Neo' );
INSERT INTO T_Users (IdUser, Login, Password) VALUES ( 2, 'Skywalker',	'Luke' );
INSERT INTO T_Users (IdUser, Login, Password) VALUES ( 3, 'Plissken' ,	'Snake' );
INSERT INTO T_Users (IdUser, Login, Password) VALUES ( 4, 'Ripley'   ,	'Ellen' );
INSERT INTO T_Users (IdUser, Login, Password) VALUES ( 5, 'Bond'     ,	'James' );

SELECT * FROM T_Users;

-- -----------------------------------------------------------------------------
-- - Construction de la table des clients	                                 ---
-- -----------------------------------------------------------------------------

CREATE TABLE T_Customers (
	IdCustomer				int(4)		PRIMARY KEY AUTO_INCREMENT,
	name					varchar(30)	NOT NULL,
	firstName				varchar(30)	NOT NULL,
	email 					varchar(30)	NOT NULL unique,
	phone 					varchar(20)	,
	address					varchar(50)	,
	idUser					int(4)		NOT NULL,
	FOREIGN KEY (idUser)	REFERENCES T_Users(idUser)
) ENGINE = InnoDB;

-- -----------------------------------------------------------------------------
-- - Construction de la table des catégories d'articles
-- -----------------------------------------------------------------------------

CREATE TABLE T_Categories (
	IdCategory 				INT(4) 		 PRIMARY KEY AUTO_INCREMENT,
	CatName 				VARCHAR(30)  NOT NULL,
	Description 			VARCHAR(100) NOT NULL
) ENGINE = InnoDB;

insert into T_Categories (IdCategory, CatName, Description) values (1 , 'PC' , 'ordinateur portable ou pas');
insert into T_Categories (IdCategory, CatName, Description) values (2 , 'SmartPhone' , 'Tel derniere generation avec ecran tactile');
insert into T_Categories (IdCategory, CatName, Description) values (3 , 'Materiel IT' , 'Tout matos informatique');
insert into T_Categories (IdCategory, CatName, Description) values (4 , 'SE et Logiciel' , 'Systeme dexploitation et autre Software');

select * from t_categories;

-- -----------------------------------------------------------------------------
-- - Construction de la table des articles en vente                         ---
-- -----------------------------------------------------------------------------
CREATE TABLE T_Articles (
	IdArticle				int(4)		PRIMARY KEY AUTO_INCREMENT,
	Description				varchar(30)	NOT NULL,
	Brand					varchar(30)	NOT NULL,
	UnitaryPrice			float(8)	NOT NULL DEFAULT 0,
	IdCategory				int(4),
	FOREIGN KEY (IdCategory)	REFERENCES T_Categories(IdCategory)
) ENGINE = InnoDB;

INSERT INTO T_Articles ( Description, Brand, UnitaryPrice , IdCategory ) VALUES ( 'Souris'     ,	'Logitoch', 65			, 3 );
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice , IdCategory ) VALUES ( 'Clavier'    ,	'Microhard', 49.5 		, 3);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice , IdCategory ) VALUES ( 'Systeme d''exploitation',	'Fenetres Vistouille',	150 , 4);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice , IdCategory  ) VALUES ( 'Tapis souris', 'Chapeau Bleu',5 		, 3);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice , IdCategory  ) VALUES ( 'Cle USB 8 To', 'Syno', 8 				, 3);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice , IdCategory  ) VALUES ( 'Laptop'      , 	'PH',	1199        , 1);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice , IdCategory  ) VALUES ( 'CD x 500'    , 'CETME', 250 			, 3);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice , IdCategory  ) VALUES ( 'DVD-R x 100' , 'CETME', 99 			, 3);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice , IdCategory  ) VALUES ( 'DVD+R x 100' , 'CETME', 105			, 3);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice , IdCategory  ) VALUES ( 'Batterie Laptop', 'PH',	80 			, 3);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice , IdCategory  ) VALUES ( 'Casque Audio', 'Syno',	55 			, 3);
INSERT INTO T_Articles ( Description, Brand , IdCategory  ) VALUES ( 'WebCam'      , 	'Logitoch' 							, 3);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice , IdCategory  ) VALUES ( 'MacBook', 'Apple',	2000 			, 1);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice , IdCategory  ) VALUES ( 'S10', 'Samsung',	1500				, 2);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice , IdCategory  ) VALUES ( 'Iphone150', 'Apple',	200000			, 2);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice , IdCategory  ) VALUES ( 'Office', 'Microsoft',	150 			, 4);


SELECT * FROM T_Articles;

-- ALTER TABLE t_articles ADD COLUMN IdCategory INT(4);
-- ALTER TABLE T_Articles ADD FOREIGN KEY(IdCategory) REFERENCES T_Categories(IdCategory);

-- select IdArticle,T_Articles.Description,Brand,UnitaryPrice,T_Articles.IdCategory,CatName,T_Categories.Description 
-- from t_articles inner join t_categories where t_articles.IdCategory = t_categories.IdCategory and IdArticle=1;

-- SELECT IdArticle,t_articles.Description,brand,UnitaryPrice,CatName FROM t_articles 
-- INNER JOIN t_categories WHERE t_articles.IdCategory=t_categories.IdCategory AND IdArticle>10 ORDER BY UnitaryPrice;

CREATE TABLE T_Orders (
	IdOrder				int(4)		PRIMARY KEY AUTO_INCREMENT,
	Amount				float(4)	NOT NULL DEFAULT 0,
	DateOrder 			DATE		NOT NULL DEFAULT NOW(),
	IdCustomer          INT(4)   	NOT NULL,
	FOREIGN KEY(IdCustomer) REFERENCES T_Customers(IdCustomer)
) ENGINE = InnoDB;



CREATE TABLE T_Order_Items (
	IdOrderItem			int(4)	PRIMARY KEY AUTO_INCREMENT,
	
	IdArticle           INT(4)   NOT NULL,
	FOREIGN KEY(IdArticle) REFERENCES T_Articles(IdArticle),
	
	Quantity			FLOAT(4) NOT NULL DEFAULT 1,
	UnitaryPrice		FLOAT(4)	NOT NULL DEFAULT 0,
	
	IdOrder             INT(4)   NOT NULL,
	FOREIGN KEY(IdOrder) REFERENCES T_Orders(IdOrder)
) ENGINE = InnoDB;