package task;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Example2 {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		ObjectMapper ob =new ObjectMapper();
	    project_1 po  =ob.readValue(new File("./pojo.json"),project_1.class);
		System.out.println(po.getAc());
		System.out.println(po.getBalancedata());
		// TODO Auto-generated method stub

	}

}
