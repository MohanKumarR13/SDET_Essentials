package sdet_essentials;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//1.Create Connection
//2.Create Statement / Query
//3.Excecute Query then Store the Results
//4.Print Results
public class ConvertDB_Result_JavaObject2 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");
		Statement statement = connection.createStatement();
		String s = "Select * From countrylanguage limit 1";

		ResultSet resultSet = statement.executeQuery(s);
		Country_Language country_Language = new Country_Language();
		while (resultSet.next()) {
			String CountryCode = resultSet.getString("CountryCode");
			String Language = resultSet.getString("Language");
			String IsOfficial = resultSet.getString("IsOfficial");
			String Percentage = resultSet.getString("Percentage");
			country_Language.setCountryCode(CountryCode);
			country_Language.setLanguage(Language);
			country_Language.setIsOfficial(IsOfficial);
			country_Language.setPercentage(Percentage);
		}
		/*
		 * System.out.println("Country Code : " + country_Language.getCountryCode());
		 * System.out.println("Language :" + country_Language.getLanguage());
		 * System.out.println("IsOfficial :" + country_Language.getIsOfficial());
		 * System.out.println("Percentage :" + country_Language.getPercentage());
		 */
		File jsonFile = new File("C:\\Users\\91995\\git\\SDET_Essentials\\SDET_Essentials\\CountryLanguage.json");

	}

}
