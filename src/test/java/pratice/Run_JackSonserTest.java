package pratice;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonPropertyOrder(
		value= { "createdBy",
				"projectName",
				"teamSize",
				"status"		
		})
 @JsonIgnoreProperties(
		 value= {
				 "teamSize"
		 })

class Project{   //pojo class[plain old java object]
	private String projectName;
	@JsonProperty(value="created By")
	private String createdBy;
	private String status;
	private int teamSize;
	
	public Project() {}
	public Project(String projectName,String createdBy,String status,int teamSize)
	{
		this.projectName=projectName;
		this.createdBy=createdBy;
		this.status=status;
		this.teamSize=teamSize;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
}

public class Run_JackSonserTest {
	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		Project po=new Project("Postman", "Likith", "Created", 10);
		ObjectMapper ob =new ObjectMapper();
		ob.writeValue(new File("./project.json"), po);
		System.out.println("End");
		
	}

}
