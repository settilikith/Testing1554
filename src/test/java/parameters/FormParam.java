package parameters;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class FormParam {
	@Test
	public void sampleTest()
	{
		given()
		   .formParam("teamSize", 10)
		   .log().all()
		   .post("http://106.51.90.215:8084/addProject")
		   .then().log().all();
	}

}
