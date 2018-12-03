import java.util.HashMap;
public class DataStorage {
	private static HashMap<String,Users>userList = new HashMap<String,Users>();
	private static HashMap<Integer,Flights>flightList = new HashMap<Integer,Flights>();
	static HashMap<Integer,Flights> getFlightList(){
		return flightList;
	}
	static HashMap<String,Users> getUserList(){
		return userList;
	}
}
