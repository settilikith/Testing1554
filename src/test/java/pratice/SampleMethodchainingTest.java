package pratice;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class SampleMethodchainingTest {
	@Test
	public void getRequestTest()
	{
		//RestAssured.get("https://reqres.in/api/users/2").prettyPrint();
		get("https://reqres.in/api/users/2").then().log().all();
		
	}

}
