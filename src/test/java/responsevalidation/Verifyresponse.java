package responsevalidation;

import org.apache.http.StatusLine;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Verifyresponse {
	@Test
	public void Verifyresponseheadertest()
	{
		Response  resp = given().get("http://106.51.90.215:8084/projects");
		
		resp.then().log().all();
		
		resp.then().assertThat().contentType(ContentType.JSON);
		resp.then().assertThat().statusLine("HTTP/1.1 200 ");
		resp.then().assertThat().statusCode(200);
		resp.then().assertThat().header("Transfer-Encoding", "chunked");
	}
	
    @Test
     public void Verifyresponsetimetest()
     {
          Response  resp = given().get("http://106.51.90.215:8084/projects");	
		  resp.then().log().all();
		  
		  long timeTaken =resp.time();
		  long timeTakensec=resp.timeIn(TimeUnit.SECONDS);
		  System.out.println(timeTaken);
		  System.out.println(timeTakensec);
		  
		  resp.then().assertThat().time(Matchers.lessThan(9000L));
		  resp.then().assertThat().time(Matchers.greaterThan(300L));
		  resp.then().assertThat().time(Matchers.both(Matchers.lessThan(900L)).and(Matchers.greaterThan(300L)));
		  
		  
     }
    
    @Test
    public void verifyresponseonbodytest()
    {
      Response re=given().get("http://106.51.90.215:8084/all-modules/TY_PROJ_11758");
    	re.then().log().all();
    	
    	re.then().assertThat().body("numberOfElements", Matchers.equalTo(20));
    	
    	re.then().assertThat().body("pageable.sort.unsorted",Matchers.equalTo(true));
    	
//       int data  =	re.jsonPath().get("numberOfElements");
//       System.out.println(data);
//    	
//       boolean data1 =re.jsonPath().get("pageable.sort.unsorted");
//       System.out.println(data1);
//       
//       String data2 =re.jsonPath().get("content[0].projectId");
//       System.out.println(data2);
    	ArrayList<String> lst = re.jsonPath().get("content.projectId");
    	System.out.println(lst);
    }
}
