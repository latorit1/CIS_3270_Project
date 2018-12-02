import java.util.HashMap;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
	class Flights {
	private static int flightCount = 0;//used to generate flight numbers will increment every time a new Flights object is created
	private Integer flightNumber;
	private Date departureDate;
	private Date departureTime;
	private Date arrivalDate;
	private Date arrivalTime;
	private String departureCity;
	private String departureState;
	private String arrivalCity;
	private String arrivalState;
	
	private int passengerCount;
	private int maxCapacity;
	HashMap<String,Users> passengerList = new HashMap<String,Users>();//hashmap containing all passengers, will use userName as the key
	
	
	//Date and time formatters. 
	SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
	SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm");
	void setMaxCapacity(){
		System.out.println("Enter the maximum amount of passengers for this flight.");
		Scanner input = new Scanner(System.in);
		maxCapacity = input.nextInt();
	}
	void setDepartureDate(){
		System.out.println("Input departure date of the flight");//should use calendar 
		Scanner input = new Scanner(System.in);
		String str;
		str = input.nextLine();
		try {
			departureDate = dateFormatter.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//
	}
	void setDepartureTime(){
		System.out.println("Input departure time of the flight");//should use calendar 
		Scanner input = new Scanner(System.in);
		String str;
		str = input.nextLine();
		try {
			departureTime = timeFormatter.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void setArrivalDate(){
		System.out.println("Input arrival date of the flight");//should use calendar 
		Scanner input = new Scanner(System.in);
		String str;
		str = input.nextLine();
		try {
			arrivalDate = dateFormatter.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void setArrivalTime(){
		System.out.println("Input arrival time of the flight.");//should use calendar 
		Scanner input = new Scanner(System.in);
		String str;
		str = input.nextLine();
		try {
			arrivalTime = timeFormatter.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void setDepartureCity(){
		System.out.println("Input city that the flight will depart from.");
		Scanner input = new Scanner(System.in);
		departureCity = input.nextLine();
	}
	void setDepartureState(){
		System.out.println("Input state that the flight will depart from.");
		Scanner input = new Scanner(System.in);
		departureState = input.nextLine();
	}
	void setArrivalCity(){
		
		System.out.println("Input city and state that the flight will arrive at.");
		Scanner input = new Scanner(System.in);
		arrivalCity = input.nextLine();
	}
	void setArrivalState(){
		
		System.out.println("Input city and state that the flight will arrive at.");
		Scanner input = new Scanner(System.in);
		arrivalState = input.nextLine();
	}
	Flights(){
		setDepartureCity();
		setDepartureState();
		setDepartureDate();
		setDepartureTime();
		setArrivalCity();
		setArrivalState();
		setArrivalDate();
		setArrivalTime();
		
		passengerCount = 0;
		setMaxCapacity();
		flightCount++;//static int variable increments by one each time a new Flights object is created. 
		flightNumber = (Integer)flightCount;//flightNumber is set to the current FlightCount and then cast to an Integer
		
	
	}
	
	Date getDepartureDate(){
		return departureDate;
	}
	String getDepartureCity(){
		return departureCity;
	}
	String getDepartureState(){
		return departureState;
	}
	String getArrivalCity(){
		return arrivalCity;
	}
	String getArrivalState(){
		return arrivalState;
	}
	Date getDepartureTime(){
		return departureTime;
	}
	Date getArrivalTime(){
		return arrivalTime;
	}
	int getPassengerCount(){
		return passengerCount;
	}
	int getMaxCapacity(){
		return maxCapacity;
	}
	//check to see if flight is full. 
	boolean getIsFull(){
		return this.passengerList.size()>=this.maxCapacity;//if size of passengerList<> is greater than or equal to the max capacity of the flight, will inform user that flight is full and prevent them from booking the flight
	}
	Integer getFlightNumber(){
		return flightNumber;
	}
	
	//method will add 
	void addPassenger(String str){
		if(getIsFull()==true){
			System.out.println("Sorry! This flight is full.");
			return;
		}
		//Method will add the user to the passengerList using the 
		passengerList.put(str,DataStorage.getUserList().get(str));//should return userList<> and allow you to use the get() method to return the User assigned to that key
	}
	@Override
	public String toString(){//getting error message on departure Time
		System.out.println("Flight " + flightNumber+ "\nFrom: " +departureCity+" , "+departureState+"\n"+departureDate+" "+departureTime+ "\nTo: "+ arrivalCity+ ", " +arrivalState+"\n"+arrivalDate+arrivalTime);
		return "Flight " + this.flightNumber+ "\nFrom: " +this.departureCity+" , "+this.departureState+"\n"+this.departureDate+" "+this.departureTime+ "\nTo: "+ this.arrivalCity+ ", " +this.arrivalState+"\n"+this.arrivalDate+this.arrivalTime;
	}
}
	
