import java.sql.Connection;

import fr.fms.dao.BddConnection;

public class Singleton_test {

	public static void main(String[] args) {
		
		
		Connection x = BddConnection.getCon();
		new BddConnection();
		Connection y = BddConnection.getCon();
		new BddConnection();
		Connection z = BddConnection.getCon();
		
		System.out.println("HashCode of x is " + x.hashCode());
		System.out.println("HashCode of y is " + y.hashCode());
		System.out.println("HashCode of z is " + z.hashCode());

	}
}
