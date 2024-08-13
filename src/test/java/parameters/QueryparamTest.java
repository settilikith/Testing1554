package parameters;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class QueryparamTest {
   @Test
   public void sampleTest()
   {
	   given()
	   .queryParam("teamSize", 10)
	   .log().all()
	   .get("http://106.51.90.215:8084/project")
	   .then().log().all();
   }
}
