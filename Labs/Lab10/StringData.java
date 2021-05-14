/*
 * Header
 * @Author: Aaron Lack, alack
 * Last edited: 4/15/20
 * Class StringData, makes instance variables for the word, count, and length
 * Generate getter and setter methods for these instance variables to be used in FrequencyCounter
 * Also implement the comparable interface so that the strings can be properly sorted by frequency.
 */

public class StringData implements Comparable {
	
	private String strings;
	private int count;
	private int length;
	
	public StringData(String strings, int count, int length) {
		this.strings = strings;
		this.count = count;
		this.length = length;
	}

	public String getStrings() {
		return strings;
	}

	public void setStrings(String strings) {
		this.strings = strings;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	//Overrides the comparable interface
	@Override
	public int compareTo(Object obj) {
		//if one is larger than the other
		if(this.getCount() > ((StringData)obj).getCount()) {
			return -1;
		}
		else if(this.getCount() == ((StringData)obj).getCount()){
			return 0;
		}
		else {
			return 1;
		}
	}

}