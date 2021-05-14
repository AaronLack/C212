import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * Header
 * @Author: Aaron Lack, alack
 * Last edited: 4/20/20
 * Class DistanceTo, Code given by Adeel in lab11.
 * These are the useful instance variable, getters, comparable methods used for class Shortest Distance.
 * Add a JUNIT Test at the end as well.
 */


public class DistanceTo implements Comparable<DistanceTo>{
	
	//Instance Variables
	private String target;
	private int distance;
	
	//Constructor
	public DistanceTo(String city, int dist) {
		target = city;
		distance = dist;
	}
	
	public String getTarget() {
		return target;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public void setDistance(int dist) {
		this.distance = dist;
	}
	
	@Override
	public int compareTo(DistanceTo other) {
		return distance - other.distance;
	}

	@Override
	public String toString() {
		return "[target = " + target + ", distance = "  + distance + "]";
	}
	
	
	

}
