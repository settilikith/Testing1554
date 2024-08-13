package com.sample.crud.withbdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class SampleTestforReadTest {
	@Test
	public void getDataFromServer()
	{
	  given(). get("http://106.51.90.215:8084/projects").then().assertThat().statusCode(200).log().all(); 
	  	}
    @Test
    public void postDataToServer()
    {
    	JSONObject js =new JSONObject();
    	js.put("createdBy", "Likith");
		js.put("projectName", "FirFlink_889");
		js.put("status", "Created");
		js.put("teamSize", 10);
		given().contentType(ContentType.JSON).body(js.toJSONString()).when().post("http://106.51.90.215:8084/addProject").then().assertThat().
		statusCode(201).log().all();
    }
    @Test
    public void PutDataToServer()
    {
    	JSONObject js =new JSONObject();
    	js.put("createdBy", "Likith");
		js.put("projectName", "FirFlink_9898");
		js.put("status", "Created");
		js.put("teamSize", 10);
		given().contentType(ContentType.JSON).body(js.toJSONString()).when().put("http://106.51.90.215:8084/projects/TY_PROJ_11759").then().assertThat().
		statusCode(200).log().all();
    	
    }
    @Test
    public void DeleteDatafromServer()
    {
    	given().delete("http://106.51.90.215:8084/projects/TY_PROJ_11759").then().statusCode(204).log().all();
    }
}
