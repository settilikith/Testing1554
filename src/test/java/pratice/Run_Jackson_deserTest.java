package pratice;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Run_Jackson_deserTest {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
	ObjectMapper ob =new ObjectMapper();
	Project po =ob.readValue(new File("./project.json"), Project.class);
	System.out.println(po.getProjectName());
	System.out.println(po.getCreatedBy());
	System.out.println(po.getStatus());
	System.out.println(po.getTeamSize());

	}

}
