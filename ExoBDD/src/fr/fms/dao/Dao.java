package fr.fms.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface Dao<T> {
	
	public Connection connection = BddConnection.getCon();
	public void create (T obj) throws SQLException;
	public T read(int id) throws SQLException;
	public boolean update(T obj) throws SQLException;
	public boolean delete(T obj) throws SQLException;
	public void readAll() throws SQLException;
}
