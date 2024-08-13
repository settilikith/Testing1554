package ddt;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

import io.restassured.http.ContentType;

public class Adddatafromexcel {
	
	@Test(dataProvider = "getData")
	public void sampleTest(String pname,String status)
	{
		String req="{\r\n"
				+ "  \"createdBy\": \"Likith\",\r\n"
				+ "  \"projectName\": \""+pname+",\r\n"
				+ "  \"status\": \""+status+",\r\n"
				+ "  \"teamSize\": 0\r\n"
				+ "}";
		
		given()
		.contentType(ContentType.JSON)
		.body(req)
		.when()
		.post("http://106.51.90.215:8084/addProject")
		.then().log().all();
		
	}         
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		ExcelUtility el =new ExcelUtility();
	      int  count=el.getLastrow("Sheet2");
	      Object[][] ob=new Object[count][2];
	      for(int i=0;i<count;i++)
		{
	    	ob[i] [0]=el.readdatafromexcel("Sheet2", i+1, 0);
	    	ob[i] [1]=el.readdatafromexcel("Sheet2", i+1, 1);
		}
		return ob;
		
		
	}


}
