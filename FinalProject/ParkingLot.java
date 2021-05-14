import java.util.ArrayList;

public class ParkingLot {
	
	//Instance Variables
	private ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();
	private int row;
	private int spots;
	private int levels;

	//Constructor
	public ParkingLot(ArrayList<ParkingSpot> parkingSpots, int row, int spots, int levels) {
		this.parkingSpots = parkingSpots;
		this.row = row;
		this.spots = spots;
		this.levels = levels;
	}

	//All Getters and Setters
	public ArrayList<ParkingSpot> getParkingSpots() {
		return parkingSpots;
	}

	public void setParkingSpots(ArrayList<ParkingSpot> parkingSpots) {
		this.parkingSpots = parkingSpots;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getSpots() {
		return spots;
	}

	public void setSpots(int spots) {
		this.spots = spots;
	}

	public int getLevels() {
		return levels;
	}

	public void setLevels(int levels) {
		this.levels = levels;
	}
	
	public String getInfo() {
		return "[rows = " + row + ", spots = " + spots + ", levels = " + levels + "]";
	}
	
	

}
