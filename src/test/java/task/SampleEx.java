package task;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Demo_1
{
	private List<Demo> demo;
	 
	public Demo_1() {}

	public Demo_1(List<Demo> demo) {
		this.demo = demo;
	}

	public List<Demo> getDemo() {
		return demo;
	}

	public void setDemo(List<Demo> demo) {
		this.demo = demo;
	}
	
	
}

class Demo{

	  private List<Value> value;
	   private String itemConfigId;
	   
	   public Demo() {}
	   
      Demo(List<Value>value,String itemConfigId)
      {
    	  this.value =value;
    	  this.itemConfigId =itemConfigId;
      }
       
	    public void setValue(List<Value> value) {
	        this.value = value;
	    }
	    public List<Value> getValue() {
	        return value;
	    }
	    
	    public void setItemConfigId(String itemConfigId) {
	        this.itemConfigId = itemConfigId;
	    }
	    public String getItemConfigId() {
	        return itemConfigId;
	    }
	    
	}
 

class Value {

	  private List<User> user;
	  private List<Manager> manager;
	  private String pinname;
       public Value() {}
	  Value(List<User>user,List<Manager>manager,String pinname)
	  {
		  this.user=user;
		  this.manager=manager;
		  this.pinname=pinname;
	  }

	    public void setUser(List<User> user) {
	        this.user = user;
	    }
	    public List<User> getUser() {
	        return user;
	    }
	    
	    public void setManager(List<Manager> manager) {
	        this.manager = manager;
	    }
	    public List<Manager> getManager() {
	        return manager;
	    }
	    
	    public void setPinname(String pinname) {
	        this.pinname = pinname;
	    }
	    public String getPinname() {
	        return pinname;
	    }
	    
	}

class User {
	   private String id;
	   private  String value;
	   public User() {}
       User(String id,String value)
       {
    	   this.id=id;
    	   this.value=value;
       }

	    public void setId(String id) {
	        this.id = id;
	    }
	    public String getId() {
	        return id;
	    }
	    
	    public void setValue(String value) {
	        this.value = value;
	    }
	    public String getValue() {
	        return value;
	    }
	    
	}
class Manager {
	   private String id;
	   private String value;
	   public Manager() {}
	   Manager(String id,String value)
	   {
		   this.id=id;
		   this.value =value;
	   }
	    public void setId(String id) {
	        this.id = id;
	    }
	    public String getId() {
	        return id;
	    }
	    
	    public void setValue(String value) {
	        this.value = value;
	    }
	    public String getValue() {
	        return value;
	    }
	    
	}




public class SampleEx {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		
		//Manager
		List<Manager> lst1=new ArrayList();        //ListList<Manager> lst1=new ArrayList(new Manager());
		Manager m=new Manager("234234", "ENG");
		lst1.add(m);
		
		//User
		 List<User> lst2 =new ArrayList();
		 User u=new User("86877", "jerry");
		 lst2.add(u);
		 
		 //Value
		 List<Value> lst3=new ArrayList<Value>();
		 Value v =new Value(lst2,lst1,"PIN545");
		 lst3.add(v);
		 
		 //Demo
		 List<Demo>lst4=new ArrayList();
		 Demo d =new Demo(lst3,"itemConfig#123");
		 lst4.add(d);
		 
		 //Demo_1
		// Demo_1 demo =new Demo_1(lst4);
		 
		 ObjectMapper o=new ObjectMapper();
		 o.writerWithDefaultPrettyPrinter().writeValue( new File("./value.json"),lst4);
	}

}
