package fr.fms.business;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.dao.BddConnection;
import fr.fms.entities.Article;

public class IJobImpl implements IJob<Article>{

	@Override
	public boolean loginCheck(String log, String pass) throws SQLException{

		Connection conn = BddConnection.getCon();
		boolean check= false;
		String strSql = "SELECT T_Users.Password FROM T_Users WHERE Login ='"+log+"';";

		try (Statement statement = conn.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery(strSql)) {
				while (resultSet.next()) {
					String rsPassword = resultSet.getString(1);
					if (rsPassword.compareTo(pass)==0) {
						check = true;
					} else {
						check = false;
					}
				}
			}
		}
		return check;
	}

	
	@Override
	public void displayCart(ArrayList<Article> cart) {
		System.err.println("Your cart :");
		for (Article a : cart) {
			System.out.println(a.getId()+" "+a.getDescription()+" "+a.getBrand()+" "+a.getPrice());
		}
	}
	@Override
	public ArrayList<Article> addCart(Article article, ArrayList<Article> cart) {
		cart.add(article);
		return cart;
	}
	@Override
	public ArrayList<Article> subCart(int index, ArrayList<Article> cart) {
		cart.remove(index);
		return cart;
	}
	@Override
	public void orderCart() {
		System.err.println("\nOrder sent.\n");
	}
}