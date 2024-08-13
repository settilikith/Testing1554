package ddt;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class AddMultipleProjectTest {
	@Test(dataProvider = "getData")
	public void sampleTest(String pname,String status)
	{
		String req="{\r\n"
				+ "  \"createdBy\": \"Likith\",\r\n"
				+ "  \"projectName\": \""+pname+",\r\n"
				+ "  \"status\": \""+status+",\r\n"
				+ "  \"teamSize\": 0\r\n"
				+ "}";
		
		given()
		.contentType(ContentType.JSON)
		.body(req)
		.when()
		.get("http://49.249.28.218:8091/addProject")
		.then().log().all();
		
	}                                                  
	@DataProvider
	public Object[][] getData()
	{
		Object[][] ob=new Object[3][2];
		ob[0][0]="AirIndia_1";
		ob[0][1]="Created";
		
		ob[1][0]="Google";
		ob[1][1]="Created";
		
		ob[2][0]="AirIndia_2";
		ob[2][1]="Created";
		return ob;
		
	}

}
