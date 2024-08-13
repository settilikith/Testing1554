package pratice;

import org.asynchttpclient.Response;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class SampleTest {
	@Test
	public void SampleGetReq()
	{
		io.restassured.response.Response resp =RestAssured.get("https://reqres.in/api/users/2");
		System.out.println(resp.prettyPrint());
	}

}
