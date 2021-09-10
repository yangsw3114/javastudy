package prob05;

import java.awt.List;
import java.util.ArrayList;

public class User {
	private String id;
	private String pwd;
	
	public User() {};
	
	public User(String id, String pwd) {
		this.id = id;
		this.pwd=pwd;
	}
	
	public Boolean findId(String id) throws UserNotFoundException{
		if(this.id == id) {
			return true;
		}
		else {
			throw new UserNotFoundException();
		}
		
	}
	public Boolean findPwd(String pwd) throws PasswordDismatchException{
		if(this.pwd == pwd) {
			return true;
		}
		else {
			throw new PasswordDismatchException();
		}
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
