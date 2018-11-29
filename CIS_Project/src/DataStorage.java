import java.util.HashMap;
public class DataStorage {
	static HashMap<String,Users>userList = new HashMap<String,Users>();
	static HashMap<Integer,Flights>flightList = new HashMap<Integer,Flights>();
	static HashMap<Integer,Flights> getFlightList(){
		return flightList;
	}
	static HashMap<String,Users> getUserList(){
		return userList;
	}
}
