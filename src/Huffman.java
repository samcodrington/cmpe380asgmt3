import java.io.InputStream;
import java.util.ArrayList;

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
		//Create all Leaves
		ArrayList<Node> binTree=new ArrayList<Node>();
		for (Entry e: dic.getEntryList()){
			Node n=new Node(e);
			binTree.add(n);
		}
		// Begin to create the tree
		int i=0;
		while (i < dic.getEntryList().size()-1) {
			
		}
		

	}

	private class Node {
		public int sum;
		public Node left;
		public Node right;
		public Entry entry;

		Node (Entry e) {
			this.sum = e.getCount();
			this.left = null;
			this.right = null;
			this.entry = e;
		}
		Node (Node l, Node r){
			this.sum=l.sum+r.sum;
			this.left=l;
			this.right=r;
			this.entry=null;
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
