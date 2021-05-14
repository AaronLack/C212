import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;


/*
* Header
* @Author: Casey Daleiden
* Last edited: 5/1/20
*/
public class Admin {
	private static String username;
	private static String password;
	private String fullName;
	private static int userID;
	static HashMap<String, String> usernamePasswordMap = new HashMap<String, String>();
	static HashMap<String, Integer> nameIDMap = new HashMap<String, Integer>();
	static ArrayList<ParkingSpot> parkingSpots = new ArrayList<>();
	static ArrayList<ParkingLot> parkingLots = new ArrayList<>();
	
	public Admin(String username, String password, String fullName, int userID) {
		this.username = username;
		this.password = password;
		this.userID = userID;
		this.fullName = fullName;
	}
	
	public static String signIn() {
		int iter = 0;
		String choice = "";
		Scanner sc = new Scanner(System.in);
		while (iter == 0) {
			System.out.println("Type 'login' to login or 'create' to create an account: ");
			String input = sc.next();
			if (input.equals("login") || input.equals("create")) {
				iter = 1;
				choice = input;
			}
		}
		if(choice.equals("login")) {
			while(iter == 1) {
				System.out.println("Username: ");
				username = sc.next();
				//check for username
				System.out.println("Password: ");
				password = sc.next();
				//check for username
				//usernamePasswordMap.put(, )
				for (String i : usernamePasswordMap.keySet()) {
					if(i.equals(username)) {
						if(usernamePasswordMap.get(i).equals(password)) {
							iter = 2;
						} else {
							System.out.println("Username or Password are wrong, try again.");
						}
					}
				}
			}
		}else if(choice.equals("create")){
			while(iter == 1) {
				usernamePasswordMap.put("admin", "abcde");
				System.out.println("Username: ");
				username = sc.next();
				//make sure username doesnt exist
				
				for (String i : usernamePasswordMap.keySet()) {
					if(i.equals(username)) {
						System.out.println("Username is currently in use, try another.");
					} else {
						iter = 2;
						System.out.println("Password: ");
						password = sc.next();
					}
				}
			userID = GenerateID();
			usernamePasswordMap.put(username, password);
			nameIDMap.put(username, userID);
			}
		}
		return username;
	}
	
	public static int carSize() {
		Random rand = new Random();
		int randNum = rand.nextInt(1)+1;
		return randNum;
	}
	
	//add lot
	public static void addLot()
	{
		int numSpots = numSpots();
		int numRows = numRows();
		int numLevels = numLevels();
		for(int i=0; i<numSpots; i++) {
			//int spotsNeeded, String vehicleSize, String user
			int size = carSize();
			String sizes = "";
			if(size == 1) {
	            sizes =  "small";
	        }
	        else if (size == 2) {
	        	sizes = "large";
	        }
			int spotID = GenerateID();
			
			Vehicle car = new Vehicle(size, size, "user", spotID);
		
			//Vehicle vehicle, int spotNumber, int size, boolean vacant
			ParkingSpot spot = new ParkingSpot(car, spotID, size, true);
		
			parkingSpots.add(spot);
		}
		
		//parkingSpot ArrayList, rows, spots, levels
		ParkingLot lot = new ParkingLot(parkingSpots, numRows, numSpots, numLevels);
		parkingLots.add(lot);

		System.out.println("Created parking lot with " + numSpots + " spots, " + numRows + " rows, and " + numLevels + " levels");
		System.out.println("lot ID: " + lot.toString());
	}
	
	public static void removeLot(String remover)
	{
		int index = 0;
		int removeInd = 0;
		int correct = 0;

		for(int i = 0; i < parkingLots.size(); i++){
			
			if(parkingLots.get(i).toString().equals(remover)) {
				removeInd = i;
				System.out.println("Lot at ID: " + parkingLots.get(i) + " Removed");
				System.out.println("Lot: " + parkingLots.get(i)+ " had " + parkingLots.get(i).getInfo());
				correct = 1;
			}
			index += 1;
		}
		
		if (correct == 0){
			System.out.println("ID was incorrect");
		} else {
			parkingLots.remove(removeInd);
		}
	}
	
	public static void changeCapacity(String capacity, int change)
	{
		int index = 0;
		int ind = 0;
		int correct = 0;

		for(int i = 0; i < parkingLots.size(); i++){
			
			if(parkingLots.get(i).toString().equals(capacity)) {
				ind = i;
				System.out.println("Lot at ID: " + parkingLots.get(i) + " found");
				System.out.println("it had " + parkingLots.get(i).getSpots() + " spots");
				correct = 1;
			}
			index += 1;
		}
		if (correct == 0){
			System.out.println("ID was incorrect");
		} else {
			parkingLots.get(ind).setSpots(change);
			System.out.println("it now has " + parkingLots.get(ind).getSpots() + " spots");
		}
	}
	
	public static void blackList(String blackList)
	{
		int check = 0;
		int index = 0;
		int ind = 0;
		String answer = "";
		for (String i : usernamePasswordMap.keySet()) {
			if(i.equals(blackList)) {
				check = 1;
				ind = index;
				answer = i;
			}
			index += 1;
		}
		if (check == 0){
			System.out.println("No such Username exists");
		} else {
			System.out.println("Username: " + answer + " is now blacklisted");
			usernamePasswordMap.remove(answer);
		}
	}
	
	
	static int GenerateID()
	{
		Random random = new Random();
		int id = random.ints(10000000, 99999999).findFirst().getAsInt();
		return id;
	}
	
	static int numSpots()
	{
		Random random = new Random();
		int spots = random.ints(20, 100).findFirst().getAsInt();
		return spots;
	}
	
	static int numRows()
	{
		Random random = new Random();
		int rows = random.ints(1, 21).findFirst().getAsInt();
		return rows;
	}
	
	static int numLevels()
	{
		Random random = new Random();
		int levels = random.ints(1, 6).findFirst().getAsInt();
		return levels;
	}
	
	public static HashMap<String, String> getMap() {
		return usernamePasswordMap;
	}
	
	public static void main(String[] args){
		//login using admin to try out code
		usernamePasswordMap.put("admin", "abcde");
		String user = signIn();
		String input = "";
		Scanner options = new Scanner(System.in);
		if(user.equals("admin")) {
			System.out.println("Admin Commands: ");
			System.out.println("'addLot'");
			System.out.println("'removeLot'");
			System.out.println("'changeCapacity'");
			System.out.println("'addSteward'");
			System.out.println("'removeSteward'");
			System.out.println("'blacklist'");
			System.out.println("'logOut'");
			System.out.println("------->Which command would you like to perform?");
			int num = 1;
			while(num != 0) {
				input = options.next();
				if (input.equals("addLot")) {
					addLot();
				} else if(input.equals("removeLot")) {
					System.out.println("Type the lot ID you would like to remove: ");
					String remove = options.next();
					removeLot(remove);
				} else if(input.equals("changeCapacity")) {
					System.out.println("Type the lot ID that you would like to change in capacity: ");
					String capacity = options.next();
					System.out.println("What number would you like to change that to?");
					int change = options.nextInt();
					changeCapacity(capacity, change);
				} else if(input.equals("addSteward")) {
					System.out.println("add");
				} else if(input.equals("removeSteward")) {
					System.out.println("remove");
				} else if(input.equals("blacklist")) {
					System.out.println("Type in a username that you want to blacklist: ");
					String blackList = options.next();
					blackList(blackList);
				} else if (input.equals("logOut")) {
					System.out.println("Bye!");
					num = 0;
				}
			}
		}
		options.close();
	}
}