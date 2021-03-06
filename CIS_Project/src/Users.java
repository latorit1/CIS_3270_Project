
import java.util.Scanner;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Users {
	//HashMap<Integer,Flights> flightList = new HashMap<Integer,Flights>();//hashmap containing all flights. Key will be Flight Number
	//static HashMap<String,Users> userList = new HashMap<String,Users>(); relocated. to Account Class Delete on final version
	
	private String firstName;
	private String lastName;
	private String addressStreet;
	private String zipCode;
	private String state;
	private String userName;
	private String password;
	private String email;
	private String SSN;
	private String addressCity;
	private String addressState;
	private HashMap<Integer,Flights> bookedFlights = new HashMap<Integer,Flights>();
	
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
		 //checks userList<> to see if specified userName is already taken
		 //If username not taken, the entry will become the new userObject's username
		 //If username is taken, program will notify that the isername is unavailable
		if(DataStorage.getUserList().get(str)==null){
			userName = str;
		}
		else{
			System.out.println("Username already taken. Please choose another one.");
			return;
		}
		 
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
	void setAddressStreet(){
		System.out.println("Enter your street address.");
		Scanner input = new Scanner(System.in);
		 String str = input.nextLine();
		 str=addressStreet;
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
		setAddressStreet();
		setAddressCity();
		setAddressState();
		setZipCode();
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
		//each user will have a hash map of booked flights that can be searched or manipulated
		HashMap<Integer,Flights> bookedFlights = new HashMap<Integer,Flights>();
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
	String  getAddressStreet(){
		return addressStreet;
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
	// addFlight method uses put() method to search flightList<> and add the desired flight to bookedFlights<> using the flightNumber (Integer i) as the key.
	//
	void addBooking(Integer i){
		bookedFlights.put(i,DataStorage.getFlightList().get(i));
		DataStorage.getFlightList().get(i).addPassenger(this.getUserName());
	}
	void cancelBooking(Integer i){
		bookedFlights.remove(i);
		DataStorage.getFlightList().get(i).removePassenger(this.getUserName());
		
	}
	@Override
	public String toString(){
		return "Username:\t"+ userName+"\nName:\t"+ firstName+" "+lastName+"\nAdress:\t"+addressStreet+" "+addressCity+", "+addressState+" "+zipCode;
	}
	
}
//customer subclass
class Customer extends Users{
		//customer default constructor
		Customer(){
			super();
			//needs search method
			
			//, bookFlight() should add Customer object to passengerList<>
			//bookFlight() should increment passengerCount 
		}
		
		
	}
 class Admin extends Users{
	//Admin subclass default constructor
	
	Admin(){
		super();
	}
	//stores all flights in an array list
	void createFlight(){
		Flights newFlight = new Flights();//create new Flights object
		DataStorage.getFlightList().put(newFlight.getFlightNumber(),newFlight);//adds newly created flight to flightList at last index
	}
	//CREATE FLIGHT method
	/* void createFlight(){
		Flight newFlight = new Flights();
		flightList.add(newFlight);
	}
	*/
	//DELETE FLIGHT method searches
	void deleteFlight(Integer i){
		DataStorage.getFlightList().remove(i); //use .remove fuction to remove specified object from flightList
	}
	//UPDATE FLIGHT 
	void updateFlight(Integer i){
		//access getters and setters for selected flight object
		DataStorage.getFlightList().get(i).setDepartureCity();
		DataStorage.getFlightList().get(i).setDepartureState();
		DataStorage.getFlightList().get(i).setDepartureDate();
		DataStorage.getFlightList().get(i).setDepartureTime();
		DataStorage.getFlightList().get(i).setArrivalCity();
		DataStorage.getFlightList().get(i).setArrivalState();
		DataStorage.getFlightList().get(i).setArrivalDate();
		DataStorage.getFlightList().get(i).setArrivalTime();
	
	}
	//
	
	//
	
}

