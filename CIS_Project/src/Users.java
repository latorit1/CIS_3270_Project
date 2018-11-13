import java.util.Scanner;
import java.util.ArrayList;

public abstract class Users {
	String firstName;
	String lastName;
	String address;
	String zipCode;
	String state;
	String userName;
	String password;
	String email;
	String SSN;
	String addressCity;
	String addressState;
	
	void setFirstName(){
		System.out.println("Enter user's first name");
		 Scanner input = new Scanner(System.in);
		 String str = input.nextLine();
		 firstName = str;
	}
	void setLastName(){
		System.out.println("Enter desired user's last ame");
		 Scanner input = new Scanner(System.in);
		 String str = input.nextLine();
		 lastName = str;
	}
	//
	void setUserName(){
		 System.out.println("Enter desired username");
		 Scanner input = new Scanner(System.in);
		 String str = input.nextLine();
		 userName = str;
	//will need to if/else add function to check for uniqueness	 
	}
	void setSSN(){
		 System.out.println("Enter user's Social Security Number in the format NNN-NN-NNNN");
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		if (str.matches("\\d{3}(-)?\\d{2}(-)?\\d{4}")){
		SSN = str;
		}
		else{
			 System.out.println("Invalid SSN");
			 return;
		}
		
	}
	void setState(String  str){
		 state = str;
	}
	void setZipCode(){
		System.out.println("Enter five digit zipcode");
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		if(str.matches("\\d{5}")){
			zipCode = str;
		}
		else{
			System.out.println("Invalid zip code");
			return;
			}
		}
		 
	void setAddressState(){
		System.out.println("Enter your state of residence.");
		Scanner input = new Scanner(System.in);
		 String str = input.nextLine();
		 str=addressState;
	}
	void setAddressCity(){
		System.out.println("Enter your city of residence.");
		Scanner input = new Scanner(System.in);
		 String str = input.nextLine();
		 str=addressCity;
	}
	
	void setAddress(){
		
		setAddressCity();
		setAddressState();
		setZipCode();//added to set Address
	}
	void setPassword(){
		System.out.println("Enter the new password. Passwords must be 8-24 charcters long and ay only include letters,numbers, and underscores.");
		Scanner input = new Scanner(System.in);
		 String str = input.nextLine();
		 //v
		if(str.matches("\\w{8,24}")){
		password = str;
		}
	}
	void setEmail(){
		System.out.println("Enter user's email address.");
		 Scanner input = new Scanner(System.in);
		 String str = input.nextLine();
		 //v
		if(str.matches("\\w+[^\\.\\@]*@\\w+\\.\\com")){
		/*check email syntax. 1 or more number or digit followed by 0 
			or more non "." or @ characters followed @ 
			then 1 or more word characters followed by ".com"
			
			*/
		email = str;
		}
		else{
			System.out.println("Invalid Email address.");
			return;
		}
	}
	Users(){
		setFirstName();
		setLastName();
		setAddress();
		setSSN();
		setEmail();
		setUserName();
		setPassword();
		
	}
	
	public static void main(String[] args) {
		

	}
	String getFirstName(){
		return firstName;
	}
	String  getLastName(){
		return lastName;
	}
	String  getUserName(){
		return userName;
	}
	String  getSSN(){
		return SSN;
	}
	String  getState(){
		return state;
	}
	String  getZipCode(){
		return zipCode;
	}
	String  getAddress(){
		return address;
	}
	String  getAddressState(){
		return addressState;
	}
	String  getAddressCity(){
		return addressCity;
	}
	String  getPassword(){
		return password;
	}
	String  getEmail(){
		return email;
	}
	
	//setters 
	
	
	
	//customer subclass
	public class Customer extends Users{
		//customer default constructor
		Customer(){
			//needs search method
			//needs methods for booking and cancelling flights
			// bookFlight() should add Customer object to passengerList<>
			//bookFlight() should increment passengerCount 
		}
	}
	
	private class Admin extends Users{
		//Admin subclass default constructor
		
		Admin(){
			
		}
		ArrayList<Flights> flightList = new ArrayList<Flights>();//stores all flights in an array list
		void createFlight(){
			Flights newFlight = new Flights();//create new Flights object
			flightList.add(newFlight);//adds newly created flight to flightList at last index
		}
		//CREATE FLIGHT method
		/* void createFlight(){
			Flight newFlight = new Flights();
			flightList.add(newFlight);
		}
		*/
		//DELETE FLIGHT method
		void deleteFlight(){
			//flightList.remove(); use .remove fuction to remove specified object from flightList
		}
		//UPDATE FLIGHT 
		void updateFlight(){
			//access getters and setters for selected flight object
		}
		//
		
		//
		
	}
	
}
