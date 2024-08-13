package authtest;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class Outh2Test {
	
	@Test
	public void sampleTest()
	{
	 Response re=  given()	
	     .formParam("client_id","ninza-client")
		 .formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
		 .formParam("grant_type", "client_credentials")
		 .when()
		 .post(" http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
		re.then()
		 .log().all();
		
		//capture token from the response
	String token	=re.jsonPath().get("access_token");
	   
	   
	   
		given()
		.auth().oauth2(token)
		.when()
		   .get("http://49.249.28.218:8091/projects")
		   .then()
		   .log().all();
	}

}
