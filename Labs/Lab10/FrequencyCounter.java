import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
 * Header
 * @Author: Aaron Lack, alack
 * Last edited: 4/15/20
 * Class FrequencyCounter
 * This class opens the file names given 
 * I will create two output files, tinyTaleStatistics and taleStatistics to have the stats of both files be seperate.
 * I accomplished this by setting a static variable to 0.
 * I split the words line by line so that it is easier to process
 * I only create getter methods for numLines, numWords, and numDistinctWords because that is all I need. 
 * Create a main method to pass in the file names test the results for both files at the same time
 */

public class FrequencyCounter {
	
	//Instance variables
	File file;
	Scanner scan;
	Set<String> distinctStrings;
	Map<String, Integer> frequency;
	ArrayList<StringData> strings; //data from other class 
	static int newFile = 0;
	int numLines;
	int numWords;
	int numDistinctWords;
	
	//Constructor
	public FrequencyCounter(String filename) throws FileNotFoundException {
		file = new File(filename);
		scan = new Scanner(file);
		distinctStrings = new HashSet<String>();
		frequency = new HashMap<>();
		strings = new ArrayList<>();
		this.numLines = 0;
		this.numWords = 0;
		this.numDistinctWords = 0;
		populateFiles();
	}

	//Getters for my integer variables
	public int getNumLines() {
		return numLines;
	}

	public int getNumWords() {
		return numWords;
	}
	
	public int getNumDistinctWords() {
		return numDistinctWords;
	}


	public void populateFiles() throws FileNotFoundException {

		while(scan.hasNextLine()) {
			numLines++;
			//Splitting each word in an array by string so I can process them line by line.
			String[] words = scan.nextLine().split(" ");
			for(int i = 0; i < words.length; i++){
				numWords++;
			  	distinctStrings.add(words[i]);
					if(frequency.containsKey(words[i])){
						frequency.put(words[i], frequency.get(words[i]) + 1);
					}
					else {
						frequency.put(words[i],1);
					}
					//Hashsets remove duplicates, so the distinct words is just the size of the set. 
					numDistinctWords = distinctStrings.size();	
			}
		}
		
		for(String data: distinctStrings) {
			strings.add(new StringData(data, frequency.get(data), data.length()));
		}
		//Sorts the strings in order by how they appear
		Collections.sort(strings);
		write();
	}
	
	public void write() {
		//An if statement for the static variable is used so that the correct file can written out for their stats.
		String fileName = "tinyTaleStatistics.txt";
		if(newFile == 1) {
			fileName = "taleStatistics.txt";
		}
		//Catching exceptions for printwriter. 
		try(FileWriter out = new FileWriter(fileName)) {
			
			out.write("Number of Words: " + getNumWords() + "\n");
			out.write("Number of Lines: " + getNumLines() + "\n");
			out.write("Number of Distinct Words: " + getNumDistinctWords() + "\n");
			
			for(StringData data : strings) {
				String line = data.getStrings()+ " {Word Length: " + data.getLength() + "}:" + data.getCount() + "\n";
				out.write(line);
			}
			
			//The clear method makes sure that the bigger file doesnt have states from smaller file as well. 
			frequency.clear();
			distinctStrings.clear();
			strings.clear();
			out.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) throws FileNotFoundException{
		//Test it with the main function
		//Displaying parts a-c in the console. 
		//Setting newFiile to 0 so that these stats are written to tinyTaleStatistics.txt
		newFile = 0;
		FrequencyCounter tinyTaleText = new FrequencyCounter("tinyTale.txt");
		System.out.println("tinyTale.txt stats");
		System.out.println("Number of Words: " + tinyTaleText.getNumWords());
		System.out.println("Number of Lines: " + tinyTaleText.getNumLines());
		System.out.println("Number of Distinct Words 2: " + tinyTaleText.getNumDistinctWords());
		
		//Setting newFiile to 1 so that these stats are written to taleStatistics.txt
		newFile = 1;
		FrequencyCounter taleTxt = new FrequencyCounter("tale.txt");
		System.out.println("tale.txt stats");
		System.out.println("Number of Words: " + taleTxt.getNumWords());
		System.out.println("Number of Lines: " + taleTxt.getNumLines());
		System.out.println("Number of Distinct Words 2: " + taleTxt.getNumDistinctWords());
		
	}
	

}

