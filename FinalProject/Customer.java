import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Customer {

    static int balance;
    String username;
    String password;
    static ArrayList<ParkingSpot> parkingSpots= Admin.parkingSpots;

    public static Boolean requestSpot(Vehicle myCar, ParkingLot myLot){
        Boolean foundSpot = false;
        ArrayList<ParkingSpot> spotList = myLot.getParkingSpots();
        for(ParkingSpot p : spotList){
            if(p.isVacant()){
                if(p.getSize() >= myCar.getVehicleSize()){
                    p.setVacant(false);
                    myCar.setSpotNumber(p.getSpotNumber());
                    p.setVehicle(myCar);
                    foundSpot = true;
                }
            }
        }
        if(foundSpot == false){
            spotList = rearrangement(spotList);
            for(ParkingSpot p : spotList){
                if(p.isVacant()){
                    if(p.getSize() >= myCar.getVehicleSize()){
                        p.setVacant(false);
                        myCar.setSpotNumber(p.getSpotNumber());
                        p.setVehicle(myCar);
                        foundSpot = true;
                    }
                }
            }
        }
        if(foundSpot == false){
            System.out.println("Could not find a spot :(");
            return false;
        }
        else{
            charge(15);
            return true;
        }
    }

    //Rearranges so large cars get large spots first
    public static ArrayList<ParkingSpot> rearrangement(ArrayList<ParkingSpot> spotList){
        ArrayList<ParkingSpot> newPS = new ArrayList<ParkingSpot>();
        ArrayList<Vehicle> newVehicleList = new ArrayList<Vehicle>();
        for(ParkingSpot ps : spotList){
            newPS.add(new ParkingSpot(null, ps.getSpotNumber(), ps.getSize(), true));
            newVehicleList.add(ps.getVehicle());
        }
        newPS.sort((a, b) -> a.getSize() > b.getSize()?1:0);
        newVehicleList.sort((a, b) -> a.getVehicleSize() > b.getVehicleSize()?1:0);
        for(int i = 0; i < newVehicleList.size(); i++){
            newPS.get(i).setVehicle(newVehicleList.get(i));
            newVehicleList.get(i).setSpotNumber(i);
        }
        return newPS;
    }

    public Customer(String username, String password){
        balance = 0;
        this.username = username;
        this.password = password;
    }

    public static void charge(int cost){
        balance -= cost;
        //userPaySystem();
    }

    public static void pay(int payment){
        balance += payment;
    }

    public static void userPaySystem(String pay, int payAmount){
        //Scanner sc = new Scanner(System.in);
        System.out.println("This is your balance: " + balance);
            //System.out.println("What is your method of payment? (Credit / Debit / Coupon) ");
            //String payMethod = sc.next();
            pay(payAmount);
        //sc.close();
    }

    public static void printCustomerInfo(String filename, HashMap<String, String> map) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File(filename));
        for (String username: map.keySet()){
            pw.println("Username: " + username);
            pw.println("Password: " + map.get(username));
            pw.println();
        }
        pw.close();
    }
    
    public String getUsername() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}
	
	public static void leaveSpot(Vehicle vehicle, ParkingLot parkingLot){
        for(int i = 0; i < parkingLot.getSpots(); i++){
            if(parkingLot.getParkingSpots().get(i).getVehicle() == vehicle)
                parkingLot.getParkingSpots().get(i).setVacant(true);
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
    	String input = "";
        String user = Admin.signIn();
        Scanner options = new Scanner(System.in);
        //initial lot
		int numSpots = Admin.numSpots();
		int numRows = Admin.numRows();
		int numLevels = Admin.numLevels();
		for(int i=0; i<numSpots; i++) {
			//int spotsNeeded, String vehicleSize, String user
			int size = Admin.carSize();
			String sizes = "";

			int spotID = Admin.GenerateID();
			
			Vehicle car = new Vehicle(size, size, "user", spotID);
		
			//Vehicle vehicle, int spotNumber, int size, boolean vacant
			ParkingSpot spot = new ParkingSpot(car, spotID, size, true);
		
			Admin.parkingSpots.add(spot);
		}
		
		//parkingSpot ArrayList, rows, spots, levels
		ParkingLot lot = new ParkingLot(parkingSpots, numRows, numSpots, numLevels);
		Admin.parkingLots.add(lot);
        //inital lot
		
		numSpots = Admin.numSpots();
		numRows = Admin.numRows();
		numLevels = Admin.numLevels();
		//int spotsNeeded, String vehicleSize, String user
		int size = Admin.carSize();
		String sizes = "";
		int spotID = Admin.GenerateID();
		
		Vehicle car1 = new Vehicle(size, size, "user", spotID);
		
        
		if(!user.equals("admin")) {
			System.out.println("User Commands: ");
			System.out.println("'paySystem'");
			System.out.println("'requestSpot'");
			System.out.println("'leaveSpot'");
			System.out.println("'logOut'");
			System.out.println("------->Which command would you like to perform?");
			int num = 1;
			while(num != 0) {
				input = options.next();
				if(input.equals("paySystem")) {
					System.out.println("What is your method of payment? (Credit / Debit / Coupon) ");
					String pay = options.next();
					System.out.println("How much would you like to pay? $");
		            int payAmount = options.nextInt();
					userPaySystem(pay, payAmount);
				} else if(input.equals("requestSpot")) {
					requestSpot(car1, Admin.parkingLots.get(0));
					System.out.println("Car has requested and found a spot");
				} else if(input.equals("leaveSpot")) {
					leaveSpot(car1, Admin.parkingLots.get(0));
					System.out.println("Car has left the spot");
				} else if(input.equals("logOut")) {
					System.out.println("Bye!");
					num = 0;
				}
			}
		options.close();
		}
		
		printCustomerInfo("CustomerInfo.txt", Admin.getMap());
	}
}