
public class Huffman {
	private String textfile;
	private Dictionary dic; 
	
	/**
	 * Constructor from String
	 */
	Huffman(String s){
		textfile=s;
		readText();
		
	}
	/**
	 * Constructor From Dictionary & binary string / integer??
	 */
	Huffman (Dictionary dic, String bin){
		
	}
	/** Generate Dictionary
	 * @return Dictionary for Huffman's Text File
	 */
	private void readText(){
		//TODOadds each char to the dictionary
		while(get())
		
	}
	
	
	/*
	 * We're going to generate a Huffman Object using the read file as a string as input
	 * The object will have a private string origTextString, int asciCharCount,
	 */
	// TODO character count method! (while we're at it # of bits needed to store unencoded (total num characters * 8 bits per ASCII)
	
	// TODO generate binary tree from read file
	// TODO get Huffman codes from binary tree
}
