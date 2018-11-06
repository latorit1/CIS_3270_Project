
public class Users {
	String firstName;
	String lastName;
	String address;
	String zipCode;
	String state;
	String userName;
	String password;
	String email;
	String SSN;
	
	Users(){
		
	}
	
	public static void main(String[] args) {
		

	}
	String getFirstName(){
		return firstName;
	}
	String getLastName(){
		return lastName;
	}
	String getUserName(){
		return userName;
	}
	String getSSN(){
		return SSN;
	}
	String getState(){
		return state;
	}
	String getZipCode(){
		return zipCode;
	}
	String getAddress(){
		return address;
	}
	String getPassword(){
		return password;
	}
	String getEmail(){
		return firstName;
	}
	
	//setters 
	void setFirstName(String str){
		 firstName = str;
	}
	void setLastName(String str){
		 lastName = str;
	}
	void setUserName(String str){
		 userName = str;
	}
	void setSSN(String str){
		 SSN = str;
	}
	void setState(String str){
		 state = str;
	}
	void setZipCode(String str){
		 zipCode = str;
	}
	void setAddress(String str){
		address = str;
	}
	void setPassword(String str){
		 password = str;
	}
	void setEmail(String str){
		firstName = str;
	}
	//customer subclass
	public class Customer extends Users{
		//customer default constructor
		Customer(){
			
		}
	}
	
	private class Admin extends Users{
		//Admin subclass default constructor
		Admin(){
			
		}
		
		//
	}
	
}
