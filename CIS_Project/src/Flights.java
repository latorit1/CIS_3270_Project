
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
	class Flights {
	Date departureDate;
	Date departureTime;
	Date arrivalDate;
	Date arrivalTime;
	String departureCity;
	String arrivalCity;

	int passengerCount;
	int maxCapacity;
	
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
		System.out.println("Input city and state that the flight will depart from.");
		Scanner input = new Scanner(System.in);
		departureCity = input.nextLine();
	}
	void setArrivalCity(){
		
		System.out.println("Input city and state that the flight will arrive at.");
		Scanner input = new Scanner(System.in);
		departureCity = input.nextLine();
	}
	Flights(){
		setDepartureCity();
		setDepartureDate();
		setDepartureTime();
		setArrivalCity();
		setArrivalDate();
		setArrivalTime();
		ArrayList<Users> passengerList = new ArrayList<Users>();
		passengerCount = 0;
		setMaxCapacity();
	
	}
	
	Date getDepartureDate(){
		return departureDate;
	}
	String getDepartureCity(){
		return departureCity;
	}
	String getArrivalCity(){
		return arrivalCity;
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
	
	}
	
