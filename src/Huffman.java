import java.io.InputStream;

public class Huffman {
	private String textfile;
	private Dictionary dic=new Dictionary(); 
	private Node head;
	/**
	 * Constructor from String
	 */
	Huffman(String s){
		textfile=s;
		readText();
		dic.sort();
		createBinaryTree();
		setBinaries(head,"");
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
	private void setBinaries(Node n, String s){
		if (n.entry==null){ // this node is not a leaf
			String sleft=s+"0";
			setBinaries(n.left,sleft);
			String sright=s+"1";
			setBinaries(n.right,sright);
		}
		else {//this node is a leaf
			n.entry.setBinary(s);
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
