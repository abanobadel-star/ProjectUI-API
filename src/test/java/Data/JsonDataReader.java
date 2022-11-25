package Data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonDataReader {

	public String firstname, lastname, email,
	password, address, city, state,
	zipcode, country, mobile, alias;
	public void JsonReader() throws IOException, ParseException {

		String filePath = System.getProperty("user.dir")+"/src/test/java/data/data.json"; //to get path for json data
		File srcFile = new File(filePath);   //get object from file
		JSONParser parser = new JSONParser();  //get object from jsonreader
		JSONArray jarray = (JSONArray)parser.parse(new FileReader(srcFile));

		for(Object jsonObj : jarray)
		{
			JSONObject usersObj = (JSONObject) jsonObj ;
			firstname = (String) usersObj.get("firstname");
			lastname = (String) usersObj.get("lastname");
			email = (String) usersObj.get("email");
			password = (String) usersObj.get("password");
			address = (String) usersObj.get("address");
			city = (String) usersObj.get("city");
			state = (String) usersObj.get("state");
			zipcode = (String) usersObj.get("zipcode");
			country = (String) usersObj.get("country");
			mobile = (String) usersObj.get("mobile");
			alias = (String) usersObj.get("alias");

		}
	}
}