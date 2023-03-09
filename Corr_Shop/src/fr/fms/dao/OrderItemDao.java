package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.fms.entities.OrderItem;

public class OrderItemDao implements Dao<OrderItem> {

	@Override
	public boolean create(OrderItem obj) {
		String str = "INSERT INTO T_Order_Items (IdArticle, Quantity, UnitaryPrice, IdOrder) VALUES (?,?,?,?);";	
		try (PreparedStatement ps = connection.prepareStatement(str)){	
			ps.setInt(1, obj.getIdArticle());
			ps.setInt(2, obj.getQuantity());
			ps.setDouble(3, obj.getUnitaryPrice());
			ps.setInt(4, obj.getIdOrder());
			
			ps.executeUpdate();			
			return true;
		} catch (SQLException e) {
			logger.severe("pb sql sur la création d'un orderItem : " + e.getMessage());
		}
		return false;
	}

	@Override
	public OrderItem read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(OrderItem obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(OrderItem obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<OrderItem> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
