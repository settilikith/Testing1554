package responsevalidation;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

public class VerifyDatacomplexJsonpath {
	 @Test
	    public void Sampletest()
	    {
	      Response re=given().get("http://106.51.90.215:8084/all-modules/TY_PROJ_11758");
	    	re.then().log().all();
          List<String>lst =JsonPath.read(re.asString(),"content[*].moduleName");
           for(String data:lst)
        	   System.out.println(data);
           List<String>lst1 =JsonPath.read(re.asString(),"content[*].[?(@.moduleName=='customer371')].projectId");
           //System.out.println(lst1.get(0));
           String actualproject =lst1.get(0);
           Assert.assertEquals(actualproject,"Vaishali123371");
         }
}