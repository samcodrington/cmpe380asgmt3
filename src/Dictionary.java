import java.util.ArrayList;

public class Dictionary {
	private int charCount;
	private ArrayList<Entry> Charlist=new ArrayList<Entry>();
	Dictionary(){
		charCount=0;
	}
	public void addChar(char c){
		//TODO
		//TODO if we don't have the character already- create Entry
		//TODO if we do --> find Entry and increment it
	}
	
	/**
	 * Private Class for Dictionary that contains character and count and has methods to 
	 * @author Sam
	 *
	 */
	private class Entry{
		Entry(char c){
			character=c;
			count=0;
		}
		Entry(char c, int i){
			character=c;
			count=i;
		}
		private char character;
		private int count;
		public char getChar(){return character;}
		public int getCount(){return count;}
		public void increment(){count++;}
	}
}
