package pratice;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

     class Projectdemo
    {

	 private  String projectName;
	  private String projectstatus;
	  private int teamSize;
	   private List<String> teamMember;
	   private ProjectManager projectManager;

        
	     Projectdemo(String projectName, String projectstatus, int teamSize, List<String> teamMember,
			ProjectManager projectManager) {
		this.projectName = projectName;
		this.projectstatus = projectstatus;
		this.teamSize = teamSize;
		this.teamMember = teamMember;
		this.projectManager = projectManager;
	}
		public void setProjectName(String projectName) {
	        this.projectName = projectName;
	    }
	    public String getProjectName() {
	        return projectName;
	    }
	    
	    public void setProjectstatus(String projectstatus) {
	        this.projectstatus = projectstatus;
	    }
	    public String getProjectstatus() {
	        return projectstatus;
	    }
	    
	    public void setTeamSize(int teamSize) {
	        this.teamSize = teamSize;
	    }
	    public int getTeamSize() {
	        return teamSize;
	    }
	    
	    public void setTeamMember(List<String> teamMember) {
	        this.teamMember = teamMember;
	    }
	    public List<String> getTeamMember() {
	        return teamMember;
	    }
	    
	    public void setProjectManager(ProjectManager projectManager) {
	        this.projectManager = projectManager;
	    }
	    public ProjectManager getProjectManager() {
	        return projectManager;
	    }
	    
	}

 class ProjectManager {
	   String name;
	   String empId;


	    ProjectManager(String name, String empId) {
		this.name = name;
		this.empId = empId;
	}
		public void setName(String name) {
	        this.name = name;
	    }
	    public String getName() {
	        return name;
	    }
	    
	    public void setEmpId(String empId) {
	        this.empId = empId;
	    }
	    public String getEmpId() {
	        return empId;
	    }
 }
public class Run_Pojo {
	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		List<String> lst=new ArrayList();
		lst.add("Jhon");
		lst.add("david");
		lst.add("Stev");
		ProjectManager pm =new ProjectManager("Sagar", "tp01");
		Projectdemo po =new Projectdemo("Likith", "created", 10, lst, pm);
		ObjectMapper o=new ObjectMapper();
		o.writeValue(new File("./project1.json"), po);
	}

}
