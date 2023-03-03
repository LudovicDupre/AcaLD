package fr.fms.business;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IJob<Article> {
	
	public boolean loginCheck(String log, String pass) throws SQLException; // Check user login+password.
	public ArrayList<Article> newCart();														// Create a new cart and check if a cart already exist. Cart is bound to unique user.
	public ArrayList<Article> displayCart(ArrayList<Article> cart); 				// Put on display the article list.
	public void addCart(Article article); 														// Add an articles to the cart.
	public void subCart(int index); 																// Remove an article at index location.
	public void orderCart(); 																			// Somehow capable to order at any given moment.
}
