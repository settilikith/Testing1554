package requestchaining;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import pojoclass.utility.ProjectPojo;

public class Scenario_1_DeleteProject {
	@Test
	 public void postDataToServer()
	 {
		Random random =new Random();
		int rannum =random.nextInt(5000);
		
		//create an Object to pojo class
		ProjectPojo p=new ProjectPojo("Airtel"+rannum,"created","Lucky",10);
		
		//Api==>add aproject in side server
    Response re=given().contentType(ContentType.JSON).body(p).when().post("http://106.51.90.215:8084/addProject");
		re.then().assertThat().statusCode(201).log().all();
		
		//capture project name from the response
		 String po=re.jsonPath().get("projectName");
		 System.out.println(po);
		 
		//Api2 delete project
		 given().delete("http://106.51.90.215:8084/projects/"+po).then().log().all();
		
	 }

}
