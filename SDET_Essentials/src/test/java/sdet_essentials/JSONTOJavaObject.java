package sdet_essentials;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONTOJavaObject {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		File jsonFile = new File("C:\\Users\\91995\\git\\SDET_Essentials\\SDET_Essentials\\CountryLanguage0.json");
		Country_Language country_Language = objectMapper.readValue(jsonFile, Country_Language.class);
		System.out.println("Country Code : " + country_Language.getCountryCode());
		System.out.println("Language : " + country_Language.getLanguage());
		System.out.println("IsOfficial : " + country_Language.getIsOfficial());
		System.out.println("Percentage : " + country_Language.getPercentage());

	}

}
