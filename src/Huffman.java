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

		// The next index after the first two nodes;
		int i = 2;

		// Begin to create the tree
		while (i < dic.getEntryList().size()) {
			if(nodeI.left == null && nodeJ.right == null){

			}
		}
		

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
}
