import java.io.InputStream;

public class Huffman {
	private String textfile;
	private Dictionary dic=new Dictionary(); 
	
	/**
	 * Constructor from String
	 */
	Huffman(String s){
		textfile=s;
		readText();
		dic.sort();
		createBinaryTree();
	}
	private void createBinaryTree() {
		// TODO Auto-generated method stub

		// Get the first two nodes from the list
		Node nodeI = new Node(dic.getEntryList().get(0));
		Node nodeJ = new Node(dic.getEntryList().get(1));

		// Begin to create the tree
		

	}

	private class Node {
		public int sum;
		public Node left;
		public Node right;
		public Entry entry;

		Node (Entry e) {
			this.sum = 0;
			this.left = null;
			this.right = null;
			this.entry = e;
		}
	}
	/**
	 * Constructor From Dictionary & binary string / integer??
	 */
	Huffman (String dic, String bin){
		
	}
	/** Generate Dictionary
	 * @return Dictionary for Huffman's Text File
	 */
	private void readText(){
		int length=textfile.length();
		char c;
		for (int i=0;i<length;i++){
			c=textfile.charAt(i);
			dic.addChar(c);
		}
				
	}
	
	
	/*
	 * We're going to generate a Huffman Object using the read file as a string as input
	 * The object will have a private string origTextString, int asciCharCount,
	 */
	// TODO character count method! (while we're at it # of bits needed to store unencoded (total num characters * 8 bits per ASCII)
	
	// TODO generate binary tree from read file
	// TODO get Huffman codes from binary tree
}
