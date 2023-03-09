package fr.fms;

import java.util.Scanner;
import java.util.function.Predicate;

import fr.fms.dao.ArticleDao;
import fr.fms.dao.CustomerDao;
import fr.fms.dao.Dao;
import fr.fms.dao.DaoFactory;
import fr.fms.dao.UserDao;
import fr.fms.entities.Article;
import fr.fms.entities.User;

public class TestShop extends Thread {	
	public TestShop(String name){
	    super(name);
	  }
	  public void run(){
		  try {
			Thread.sleep(1000);
		 } catch (InterruptedException e) {
			e.printStackTrace();
		 }
		 System.out.println(this.getName() + " : " + new ArticleDao().read(1));
		 System.out.println(this.getName() + " : " + new UserDao().read(1));
		 System.out.println(this.getName() + " : " + new CustomerDao().read(1));
	  }      
	
	public static void main(String[] args) {	
		testThreads();
//		new UserDao().create(new User("toto", "123"));
//		testDaoFactory();
//		testUserArticle();		
//		testUserDao();		
//		testArticleDao();
//		ArticleDao articleDao = new ArticleDao();
//		articleDao.createPrepared(new Article("S9","Samsung",250));		
	}

	private static void testThreads() {
		TestShop t1 = new TestShop(" 1-");
		TestShop t2 = new TestShop(" 2-");
		TestShop t3 = new TestShop(" 3-");
		TestShop t4 = new TestShop(" 4-");
		TestShop t5 = new TestShop(" 5-");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
	//----------------Ex 10
	private static void testUserArticle() {
		Scanner scan = new Scanner(System.in);
		UserDao userDao = new UserDao();		
		System.out.println("saisissez votre identifiant :");
		String login = scan.nextLine();
		System.out.println("saisissez votre password :");
		String pwd = scan.nextLine();		
		//méthode 1 pas très performante
//		for(User user : userDao.readAll()) {
//			if(login.equalsIgnoreCase(user.getLogin()) && pwd.equalsIgnoreCase(user.getPwd())) {
//				for(Article article : new ArticleDao().readAll()) {
//					System.out.println(article);
//				}
//			}	
//		}	
		
		//méthode 2
		User user = userDao.findUserByCredentials(login, pwd);
		if(user != null) {
			for(Article article : new ArticleDao().readAll()) {
				System.out.println(article);
			}
		}
		else System.out.println("accès refusé !");
			
		scan.close();
		//userDao.create(new User("mohamed","123"));
	}

	//afficher tous les utilisateurs en base
	private static void testUserDao() {
		UserDao userDao = new UserDao();
		
		for(User user : userDao.readAll())
			System.out.println(user);
	}
	//----------------test les méthodes Crud du composant d'accès aux données : ArticleDao
	private static void testArticleDao() {
		ArticleDao articleDao = new ArticleDao();
		
		//Afficher tous les articles
		for(Article article : articleDao.readAll()) {
			System.out.println(article);
		}	
		System.out.println();
		//Afficher un article à partir de son id
		Article article = articleDao.read(5);
		System.out.println(article);
		
		//Mise à jour de l'article
		article.setDescription("Batterie TopTop");
		articleDao.update(article);
		
		//Supprimer un article
		if(article != null)		
			articleDao.delete(article);
		
		//Insertion de l'article en base
		if(article != null)		
			articleDao.create(article);
		
		System.out.println();
		//Afficher tous les articles
		for(Article art : articleDao.readAll()) {
			System.out.println(art);
		}			
	}
	
	//test notre fabrique à objet ou composant d'accès
	private static void testDaoFactory() {
		Dao<User> userDao = DaoFactory.getUserDao();
			
		Predicate<Article> artPredicate = a -> a.getId() >= 5 && (a.getPrice() > 50 && a.getPrice() < 100); 
		DaoFactory.getArticleDao().readAll()
					.stream()
					.filter(artPredicate)
					.forEach(System.out::println);
			
		System.out.println("---------------------------------------------");
		
		userDao.readAll().forEach(user -> System.out.println(user));
	}
}
