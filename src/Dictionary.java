import java.util.ArrayList;

public class Dictionary {
	private int origCharCount;
	private ArrayList<Entry> entryList;
	Dictionary(){
		origCharCount=0;
	}
	public void addChar(char c){
		Entry e=check(c);
		if (e==null)
			entryList.add(new Entry(c));
		e.increment();
		origCharCount++;
		
	}
	/**
	 * If c is already contained in this dictionary's Charlist, returns that Entry, otherwise returns null
	 * @param c
	 */
	private Entry check(char c) {
		for (Entry e:entryList){
			if (e.getChar()==c)
				return e;
		}
		return null;
	}
	public int getCharCount(){return origCharCount;}
	
	/**
	 * Private Class for Dictionary that contains character and count and has methods to retrieve them
	 * @author Sam
	 *
	 */
	private class Entry{
		Entry(char c){
			character=c;
			count=0;
		}
		Entry(char c, String b){
			character=c;
			binary=b;
		}
		private char character;
		private int count;
		private String binary;
		public char getChar(){return character;}
		public int getCount(){return count;}
		public void increment(){count++;}
		public void setBin(String b){binary=b;}
	}
}
