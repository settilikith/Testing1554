package authtest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class BearerTokenAuthTest {
	
	@Test
	public void sampleTest()
	{
		given()
		  .auth().oauth2("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJybWd5YW50cmEiLCJleHAiOjE3MjEwNTQzNDQsImlhdCI6MTcyMTAxODM0NH0.ZuVPpurzAkyDTs-zFhTYrpLb9y-Iv6xh4SvRtox_jM0")
		 .log().all()
		 .when()
		    .get("http://106.51.90.215:8084/projects").then()
		    .log().all();
	}

}
