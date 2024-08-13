package task;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

class project_1
{
	private  String Balancedata;
	private List<AccountBalance>ac;
	
	
	
	public project_1() {}
	
     project_1(String Balancedata,List<AccountBalance> ac) {
		this.Balancedata =Balancedata;
		this.ac = ac;
	}
	public String getBalancedata() {
		return Balancedata;
	}
	public void setBalancedata(String balancedata) {
		this.Balancedata = Balancedata;
	}
	public List<AccountBalance> getAc() {
		return ac;
	}
	public void setAc(List<AccountBalance> ac) {
		this.ac = ac;
	}
}

class AccountBalance {

	   String AccountName;
	   String country;

	   String AccountType;
	   
	    public AccountBalance() {}
	  
           public AccountBalance( String AccountName,String country,String AccountType) {
        	   this.AccountName=AccountName;
        	   this.country =country;
        	   this.AccountType=AccountType;
			// TODO Auto-generated constructor stub
		}
	    public void setAccountName(String AccountName) {
	        this.AccountName = AccountName;
	    }
	    public String getAccountName() {
	        return AccountName;
	    }
	    
	    public void setCountry(String country) {
	        this.country = country;
	    }
	    public String getCountry() {
	        return country;
	    }
	    
	    public void setAccountType(String AccountType) {
	        this.AccountType = AccountType;
	    }
	    public String getAccountType() {
	        return AccountType;
	    }
	    
	}

class Example {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		List<AccountBalance> bal=new ArrayList<AccountBalance>();
		AccountBalance a =new AccountBalance("Lucky","India","Savings");
		bal.add(a);
		project_1 p=new project_1("11-07-2024", bal);
		ObjectMapper o=new ObjectMapper();
		o.writeValue(new File("./pojo.json"), p);


	}

}
