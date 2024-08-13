package requestchaining;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.utility.EmployeePoJo;
import pojoclass.utility.ProjectPojo;

public class Scenario_2_AddemployeetoProject {
	@Test
	public void sampleTest()
	{
		Random random =new Random();
		int rannum =random.nextInt(5000);
		
		//create an Object to pojo class
		ProjectPojo p=new ProjectPojo("Airtel"+rannum,"created","Lucky",0);
		
		//Api==>add aproject in side server
    Response re=given().contentType(ContentType.JSON).body(p).when().post("http://49.249.28.218:8091/addProject");
		re.then().assertThat().statusCode(201).log().all();
		
		//capture project name from the response
		 String po=re.jsonPath().get("projectName");
		 System.out.println(po);
		 
		 //API-2==>add employee to same project
		 //String designation, String dob, String email, String empName, double experience,
			//String mobileNo, String project, String role, String username
		 
		 EmployeePoJo emp =new EmployeePoJo("Arcitect","07/09/2001","settilikith376@gmail.com",
				 "user_"+rannum,2,"9100734593",po,"ROLE_EMPLOYEE","user_"+rannum);
		 given().contentType(ContentType.JSON).body(emp).when().post("http://49.249.28.218:8091/employees")
		 .then().assertThat().statusCode(201).log().all();
	}

}
