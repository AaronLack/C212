/*
* Header
* @Author: Aaron Lack, alack
* Last edited: 5/1/20
* Class ParkingSpot, an object to be put into other classes
* This class will have instance variables, a constructor, getters and setters
* private String spotNumber is a unique parkingspot with an attached number.
* private int size is the size of the parking spot. ex: 1, 2, etc.
* private boolean vacant is true if the spot is empty and false if it is taken.
*/

public class ParkingSpot {
	
	//Instance Variables
	private int spotNumber;
	private int size;
	private boolean vacant;
	private Vehicle vehicle;
	
	//Constructor
	public ParkingSpot(Vehicle vehicle, int spotNumber, int size, boolean vacant) {
		this.spotNumber = spotNumber;
		this.size = size;
		this.vacant = vacant;
		this.vehicle = vehicle;
	}

	//All Getters and Setters
	public int getSpotNumber() {
		return spotNumber;
	}

	public void setSpotNumber(int spotNumber) {
		this.spotNumber = spotNumber;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean isVacant() {
		return vacant;
	}

	public void setVacant(boolean vacant) {
		this.vacant = vacant;
	}
	
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}

}