package authtest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class BasicAuthTest {
	@Test
	public void sampleTest()
	{
		given()
		  .auth().basic("rmgyantra","rmgy@9999")
		  .log().all()
	       .when().get("http://106.51.90.215:8084/login")
	       .then().log().all();
	}

}
