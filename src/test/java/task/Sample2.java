package task;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Sample2 {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		ObjectMapper o =new ObjectMapper();
	    Demo  de =o.readValue(new File("./value.json"), Demo.class);
	    System.out.println(de.getItemConfigId());
	    System.out.println(de.getValue());
		// TODO Auto-generated method stub

	}

}
