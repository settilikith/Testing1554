package com.sample.crud.withoutbdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestforReadTest {
	@Test
	public void getDataFromServer()
	{
	  Response resp =RestAssured.get("http://106.51.90.215:8084/projects");
	  //System.out.println(resp.asString());
	 // System.out.println(resp.prettyPrint());
	  resp.then().assertThat().statusCode(200);
	  resp.then().log().all();
		
	}
	@Test
	public void postDataToServer()
	{
		JSONObject js=new JSONObject();
		js.put("createdBy", "Likith");
		js.put("projectName", "FirFlink_1");
		js.put("status", "Created");
		js.put("teamSize", 10);
		//given(): It use to create the precondition before send the request
	  RequestSpecification req =	RestAssured.given();
	  req.contentType(ContentType.JSON);
	  req.body(js.toJSONString());
	  Response resp  =req.post("http://106.51.90.215:8084/addProject");
	  resp.then().log().all();
	  resp.then().assertThat().statusCode(201);
	}
     @Test
     public void puttDataToServer()
 	{
 		JSONObject js=new JSONObject();
 		js.put("createdBy", "Likith");
 		js.put("projectName", "FireFlink_25");
 		js.put("status", "Created");
 		js.put("teamSize", 10);
 		//given(): It use to create the precondition before send the request
 	  RequestSpecification req =	RestAssured.given();
 	  req.contentType(ContentType.JSON);
 	  req.body(js.toJSONString());
 	  Response resp  =req.put("http://106.51.90.215:8084/projects/TY_PROJ_11736");
 	  resp.then().log().all();
 	  resp.then().assertThat().statusCode(200);
 	}
     @Test
     public void deleteDatafromServer()
  	{
  	  Response resp  =RestAssured.delete("http://106.51.90.215:8084/projects/TY_PROJ_11736");
  	  resp.then().log().all();
  	  resp.then().assertThat().statusCode(204);
  	}

}
