import java.sql.Connection;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public class Database {
		
	public static Connection getConnection() throws SQLServerException {

		SQLServerDataSource ds = new SQLServerDataSource();
		ds.setUser("companyuser");
		ds.setPassword("ThisIsALongPassword");
		ds.setServerName("localhost\\sqlexpress");
		ds.setDatabaseName("Company");
		return ds.getConnection();
	}
}
