package sdet_essentials;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

//1.Create Connection
//2.Create Statement / Query
//3.Excecute Query then Store the Results
//4.Print Results
public class ConvertDB_Result_JavaObject_JsonFiles {

	public static void main(String[] args) throws SQLException, StreamWriteException, DatabindException, IOException {
		// TODO Auto-generated method stub
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");
		Statement statement = connection.createStatement();
		String s = "Select * From countrylanguage";
		ArrayList<Country_Language>country_LanguagesList=new ArrayList<Country_Language>();
		ResultSet resultSet = statement.executeQuery(s);
		while (resultSet.next()) {
			String CountryCode = resultSet.getString("CountryCode");
			String Language = resultSet.getString("Language");
			String IsOfficial = resultSet.getString("IsOfficial");
			String Percentage = resultSet.getString("Percentage");
			Country_Language country_Language = new Country_Language();
			country_Language.setCountryCode(CountryCode);
			country_Language.setLanguage(Language);
			country_Language.setIsOfficial(IsOfficial);
			country_Language.setPercentage(Percentage);
			country_LanguagesList.add(country_Language);
		}
	for(int i=0;i<country_LanguagesList.size();i++) {
		File jsonFile = new File("C:\\Users\\91995\\git\\SDET_Essentials\\SDET_Essentials\\CountryLanguage"+i+".json");
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(jsonFile, country_LanguagesList.get(i));
	}
		connection.close();
		System.out.println("Done");
	}

}
