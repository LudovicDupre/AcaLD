package fr.fms.dao;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.fms.entities.Category;

public class CategoryDao implements Dao<Category>{

	@Override
	public boolean create(Category obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Category read(int id) {
		try (Statement statement = connection.createStatement()){
			String str = "SELECT * FROM T_Categories where IdCategory=" + id + ";";									
			ResultSet rs = statement.executeQuery(str);
			if(rs.next()) return new Category(rs.getInt(1) , rs.getString(2) , rs.getString(3));
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
		return null;
	}

	@Override
	public boolean update(Category obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Category obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Category> readAll() {
		ArrayList<Category> categories = new ArrayList<Category>();
		String sql = "select * from T_Categories";
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(sql)){
				while(resultSet.next()) {
					categories.add(new Category(resultSet.getInt("idCategory"), resultSet.getString(2), resultSet.getString(3)));
				}
				return categories;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}

}
