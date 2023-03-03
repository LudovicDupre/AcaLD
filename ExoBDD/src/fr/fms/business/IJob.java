package fr.fms.business;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IJob<T> {
	
	public boolean loginCheck(String log, String pass) throws SQLException; // Check user login+password.		
	public void displayCart(ArrayList<T> cart); 											// Put on display the article list.
	public ArrayList<T> addCart(T article,ArrayList<T> cart); 						// Add an articles to the cart.
	public ArrayList<T> subCart(int index,ArrayList<T> cart); 						// Remove an article at index location.
	public void orderCart(); 																			// Somehow capable to order at any given moment.
}
