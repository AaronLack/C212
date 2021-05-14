import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Header
 * @Author: Aaron Lack, alack
 * Last edited: 4/20/20
 * Class ShortestDistance, will make a read method of a file input, a write method, and the algorithm given below
 * Create a map instance variable that stores all the directed edges of the cities in the geography map
 * Also create a starting city instance variable that will be an empty string and will change as the file 
 * is being read for the priority queue.  
 * When making the object, type in the starting location and it will display shortest distance for all cities.
 * 
 * Algorithm for shortest distance: 
 * Let x be starting point: where x is a city
 * Add DistanceTo(x,0) to a priority queue
 * Declare a map shortestKnownDistance which will eventually contain shortest distance from x to all other cities
 * While the priority queue is not empty
 * 		Get the smallest element.
 * 		If the target is not a key in shortestKnownDistance
 * 		Let d be the distance to that target.
 * 		Put (target, d) into shortestKnownDistance
 * 		For all citites c that have a direct connection from target
 * 			Add DistanceTo(c, d+distance from target to c) to the priority queue
 * 
 * Sample output: (in file):
 * {Pierre: 2, Pueblo: 5, "Phonenix: 4" when source is Pendleton}
 */

public class ShortestDistance {
	
	//This map is for all the direct connections distances
	private Map<String, HashSet<DistanceTo>> map = new HashMap<String, HashSet<DistanceTo>>();
	private String startingCity = "";
	
	//Constructor, make an object where you type in the starting city and call the read and write methods
	public ShortestDistance(String startingCity) throws FileNotFoundException {
		this.startingCity = startingCity;
		readFile();
		writeFile();
	}

	public void readFile() throws FileNotFoundException {
		//Read in a text file of all the distances possible for all the cities (edges in the graph)
		String startingPoint = "";
		File inputFile = new File ("distances.txt");
		Scanner in = new Scanner(inputFile);
		HashSet<DistanceTo> distances = new HashSet<>();
		//tokens[0] is the starting city
		while(in.hasNextLine()) {
			String lines = in.nextLine();
			String[] tokens = lines.split(" ");
			startingPoint = tokens[0];
			DistanceTo d = new DistanceTo(tokens[1], Integer.parseInt(tokens[2]));
			if(!map.containsKey(startingPoint)) {
				distances.add(new DistanceTo(tokens[1], Integer.parseInt(tokens[2])));
				map.put(startingPoint, new HashSet<>());
			}
			map.get(startingPoint).add(d);
		}
		in.close();
	}
	
	public Map<String, DistanceTo> findShortestDistance() throws FileNotFoundException {	
		//put the values of distances map into a hashset to be used for shortestKnownDistance
		Map<String, DistanceTo> shortestKnownDistance = new HashMap<>();
		PriorityQueue<DistanceTo> pq = new PriorityQueue<DistanceTo>(); 
		//Starting point
		pq.add(new DistanceTo(startingCity, 0));
		while(!pq.isEmpty()) {
			//Will get smallest element in priority queue
			DistanceTo smallestElement = pq.poll(); 
			if(!shortestKnownDistance.containsKey(smallestElement.getTarget())) {
				String target = smallestElement.getTarget();
				Integer distance = smallestElement.getDistance();
				shortestKnownDistance.put(target,new DistanceTo(startingCity,distance));
				//Iterate over the map and will get a distance too object. Then you will add it to the priority queue.
				Iterator<DistanceTo> iter = map.get(target).iterator(); 
				while (iter.hasNext()) {
					DistanceTo smallest = iter.next();
					pq.add(new DistanceTo(smallest.getTarget(), distance + smallest.getDistance()));
				}
			}
		}
		return shortestKnownDistance;
	}
	
	public void writeFile() throws FileNotFoundException {
		//Try catch is default for writing it. 
		FileWriter out;
		try {
			out = new FileWriter("shortestDistances.txt");
			out.write(findShortestDistance().toString() + "\n");
			out.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String args[]) throws FileNotFoundException {
		//Create a ShortestDistance object and just pass in the city you want to start at
		//Then call the findShortestDistance method.
		ShortestDistance test = new ShortestDistance("Pueblo");
		Map<String, DistanceTo> testMap = test.findShortestDistance();
		for(String s : testMap.keySet()) {
			DistanceTo value = testMap.get(s);
			String shortestDistance = value.getTarget() + " to " + s.toString() + ": " +  value.getDistance();
			System.out.println(shortestDistance);
		}
	}
	
}
