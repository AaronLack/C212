import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
* Header
* @Author: Aaron Lack, alack
* Last edited: 5/1/20
* Class Vehicle, an object to be implemented in other classes
* This class will have instance variables, a constructor, getters and setters
* private int spotsNeeded is the number of spots a car needs. Ex: 1 for small, 2 for large, etc.
* private String vehicleSize is a string repersentation of the car. Ex: small, large
* int spotsNeeded and vehicleSize needs to be consistent. 
* string user will allow the User's car to be attached to a car in the user class.
*/


public class Vehicle {
	
	//Instance Variables
	private int spotsNeeded;
	private int vehicleSize;
	private String user;
	private int spotID;

	//Constructor
	public Vehicle(int spotsNeeded, int vehicleSize, String user, int spotID) {
		this.spotsNeeded = spotsNeeded;
		this.vehicleSize = vehicleSize;
		this.user = user;
		this.spotID = spotID;
	}

	//All getters and setters
	public int getVehicleSize() {
		return vehicleSize;
	}

	public int getSpotNumber() {
		return spotID;
	}

	public void setSpotNumber(int spotNumber) {
		this.spotID = spotNumber;
	}

	public void setVehicleSize(int vehicleSize) {
		this.vehicleSize = vehicleSize;
	}

	public int getSpotsNeeded() {
		return spotsNeeded;
	}

	public void setSpotsNeeded(int spotsNeeded) {
		this.spotsNeeded = spotsNeeded;
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
}