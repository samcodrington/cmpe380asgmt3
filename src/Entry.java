/**
	 * Private Class for Dictionary that contains character and count and has methods to retrieve them
	 * @author Sam
	 *
	 */
	
public class Entry{
	Entry(char c){
		character=c;
		count=1;
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
}
