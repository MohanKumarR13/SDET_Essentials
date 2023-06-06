package sdet_essentials;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//1.Create Connection
//2.Create Statement / Query
//3.Excecute Query then Store the Results
//4.Print Results
public class RetreiveDataFromDB_JDBC {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");
		Statement statement = connection.createStatement();
		String s = "Select * From countrylanguage";
		/* String s = "Select * From countrylanguage limit 1"; */

		ResultSet resultSet = statement.executeQuery(s);
		while (resultSet.next()) {
			String CountryCode = resultSet.getString("CountryCode");
			String Language = resultSet.getString("Language");
			String IsOfficial = resultSet.getString("IsOfficial");
			String Percentage = resultSet.getString("Percentage");

			System.out.println(CountryCode + " " + Language + " " + IsOfficial + " " + Percentage);
		}
		connection.close();
	}

}
