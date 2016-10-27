/**
	 * Private Class for Dictionary that contains character and count and has methods to retrieve them
	 * @author Sam
	 *
	 */
	
public class Entry{
	Entry(char c){
		character=c;
		count=0;
	}
	
	private char character;
	private int count;
	
	public char getChar(){return character;}
	public int getCount(){return count;}
	public void increment(){count++;}
}
