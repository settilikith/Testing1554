package parameters;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class PathParamTest {
	
	@Test
	public void sampleTest()
	{
		given()
		.pathParam("projectId","TY_PROJ_11758")
		.when().get("http://106.51.90.215:8084/project/{projectId}")
		.then().log().all();
	}

}
