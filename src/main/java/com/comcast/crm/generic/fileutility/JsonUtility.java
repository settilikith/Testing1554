package com.comcast.crm.generic.fileutility;

import static io.restassured.RestAssured.given;

import java.util.List;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

public class JsonUtility {
	
	public String getDataonJsonpath(Response re,String jsonxpath)
	{
		List<Object> list=JsonPath.read(re.asString(), jsonxpath);
		return list.get(0).toString();
	}
     
	
	public boolean VerifyDataOnJsonPath(Response re,String jsonxpath,String expectedData)
	{
		List<String> list =JsonPath.read(re.asString(),jsonxpath);
		boolean flag =false;
	for(String str:list)
	{
		if(str.equals(expectedData)) {
			System.out.println(expectedData +"is available==Pass");
			flag=true;
		}
	}
	return flag;
	}
	
	public String getAccessToken()
	{
		 Response re=  given()	
			     .formParam("client_id","ninza-client")
				 .formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
				 .formParam("grant_type", "client_credentials")
				 .when()
				 .post(" http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
				re.then()
				 .log().all();
				
				String token=re.jsonPath().get("acess_token");
				return token;
	}
}
