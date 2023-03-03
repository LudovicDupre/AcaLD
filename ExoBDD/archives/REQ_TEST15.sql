SELECT t_articles.IdArticles, t_articles.Description, t_articles.Brand, t_articles.UnitaryPrice, t_categories.CatName
FROM t_articles
LEFT JOIN  t_categories 
ON t_articles.IdCategory = t_categories.IdCategories
ORDER BY t_articles.UnitaryPrice ASC;


SELECT * FROM t_articles;
SELECT * FROM t_categories;
