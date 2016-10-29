/**
 * Private Class for Dictionary that contains character and count and has methods to retrieve them
 * Binary attribute should be a string of 1s and 0s that can be encoded/decoded
 * @author Sam
 *
 */

public class Entry{
	Entry(char c){
		character=c;
		count=1;
	}
	/**
	 * Constructor for Entry when binary is known
	 * @param c character for Entry
	 * @param b String of 1s and 0s that will be the binary encoding
	 */
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
	public String getBinary(){return binary;};
	public void setBinary(String b){binary=b;}
}
