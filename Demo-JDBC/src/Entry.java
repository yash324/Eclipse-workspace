import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Entry {
	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		Properties props = new Properties();
		FileInputStream fin = new FileInputStream("dbDetails.properties");
		props.load(fin);
		String url = props.getProperty("jdbc.url");
		Connection dbConnection;
		dbConnection = DriverManager.getConnection(url);
		try (PreparedStatement selectStatement = dbConnection.prepareStatement(props.getProperty("jdbc.query.select"),
				ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
			ResultSet res = selectStatement.executeQuery();
			System.out.println("Before Update");
			while (res.next()) {
				System.out.print("ID: " + res.getInt("id"));
				System.out.println(", Name: " + res.getString("name"));
			}
			res.beforeFirst();
			while (res.next()) {
				int id = res.getInt("id");
				res.updateInt("id", id-10);
				res.updateRow();
			}
			System.out.println("\nAfter Update");
			res.beforeFirst();
			while (res.next()) {
				System.out.print("ID: " + res.getInt("id"));
				System.out.println(", Name: " + res.getString("name"));
			}
		}
	}
}
