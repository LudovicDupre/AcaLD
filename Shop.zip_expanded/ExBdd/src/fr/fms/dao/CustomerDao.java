package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.Customer;

public class CustomerDao implements Dao<Customer> {

	@Override
	public boolean create(Customer obj) {
		String str = "INSERT INTO T_Customers (Name,FirstName,Email,Phone,address,idUser) VALUES (?,?,?,?,?,?);";
		try (PreparedStatement ps = connection.prepareStatement(str,Statement.RETURN_GENERATED_KEYS)){
			ps.setString(1, obj.getName());
			ps.setString(2, obj.getFirstName());			
			ps.setString(3, obj.getEmail());
			ps.setString(4, obj.getPhone());
			ps.setString(5, obj.getAddress());
			ps.setInt(6, obj.getIdUser());
			ps.execute();
			try(ResultSet generatedKeySet = ps.getGeneratedKeys()){
				if(generatedKeySet.next()) {
					//obj.setIdCustomer(0);
					return true;
				}	
			}		
		} catch (SQLException e) {
			logger.severe("pb sql sur la création d'un client");
		} 				
		return false;
	}

	@Override
	public Customer read(int id) {
		String str = "select * from T_Customers where IdCustomer=?";
		try(PreparedStatement ps = connection.prepareStatement(str)){
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				return new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
		} catch (SQLException e) {
			logger.severe("pb sql sur la lecture d'un client " + e.getMessage());
		}
		return null;
	}

	@Override
	public boolean update(Customer obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Customer obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Customer> readAll() {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		String strSql = "SELECT * FROM T_Customers";		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
				while(resultSet.next()) {
					int idCustomer = resultSet.getInt(1);	
					String name = resultSet.getString(2);
					String fisrtName = resultSet.getString(3);
					String email = resultSet.getString(4);
					String tel = resultSet.getString(5);
					String address = resultSet.getString(5);
					int idUser = resultSet.getInt(6);
					customers.add((new Customer(idCustomer,name,fisrtName,email,tel,address,idUser)));						
				}	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return customers;
	}
	
	public Customer findCustomerByEmail(String email) {
		String strSql = "SELECT * FROM T_Customers where Email=?;";
		try(PreparedStatement ps = connection.prepareStatement(strSql)){
			ps.setString(1, email);
			try(ResultSet resultSet = ps.executeQuery()){ 		
				if(resultSet.next()) {
					return new Customer(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),
							resultSet.getString(5),resultSet.getString(6),resultSet.getInt(7));	
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}	
		return null;
	}

}
