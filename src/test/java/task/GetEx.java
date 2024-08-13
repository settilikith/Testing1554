package task;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

class results{
	private String id;
	private String total;
	private String customerId;
	public results(String id, String total, String customerId) {
		super();
		this.id = id;
		this.total = total;
		this.customerId = customerId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
}


class Links_1
{
	String Self ;
  String Next ;
	 List<results>result;
	
  
  public Links_1(String self, String next, List<results> result) {
		super();
		Self = self;
		Next = next;
		this.result = result;
	}


public String getSelf() {
	return Self;
}


public void setSelf(String self) {
	Self = self;
}


public String getNext() {
	return Next;
}


public void setNext(String next) {
	Next = next;
}


public List<results> getResult() {
	return result;
}


public void setResult(List<results> result) {
	this.result = result;
}
  
}


class Links{
	  private Links_1 link;

	public Links(Links_1 link) {
		super();
		this.link = link;
	}

	public Links_1 getLink() {
		return link;
	}

	public void setLink(Links_1 link) {
		this.link = link;
	}
	  
  }


public class GetEx {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
	List<results> lst =new ArrayList();
	results re1=new results("7235", "78.2", "9001");
	results re2=new results("7236", "68.2", "9002");
	lst.add(re1);
	lst.add(re2);
	Links_1 l =new Links_1("herf:/Orders","herf:Orders/page=2", lst);
	Links link =new Links(l);
	ObjectMapper o=new ObjectMapper();
	o.writerWithDefaultPrettyPrinter().writeValue(new File("./link.txt"),link);

	}

}
