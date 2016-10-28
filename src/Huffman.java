import java.io.InputStream;
import java.util.ArrayList;

public class Huffman {
	private String textfile;
	private Dictionary dic=new Dictionary(); 
	private Node head;
	private ArrayList<Node> binList=new ArrayList<Node>();

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
		for (Entry e: dic.getEntryList()){
			Node n=new Node(e);
			binList.add(n);
		}
		final int leafSize=binList.size();
		// Begin to create the tree
		int i=0;
		int count = 0;
		int[] mins=new int[2];
		while (count<leafSize-1) {// we will have to make leaves-1 nodes always
			mins=findLeast(i);
			if (mins[0]<leafSize&&mins[1]<leafSize)
				i+=2;
			else if(mins[0]<leafSize&&mins[1]<leafSize)
				i++;
			Node n=new Node(binList.get(mins[0]),binList.get(mins[1]));
			binList.add(n);
			count++;
		}
	}
	private int[] findLeast(int i){
		int minA = i, minB=i+1;
		for (int j=i;j<binList.size();j++){
			if (binList.get(j).sum<binList.get(minA).sum){
				minB=minA;
				minA=j;
			}
			else if(binList.get(j).sum<binList.get(minB).sum){
				minB=j;
			}
		}
		int[] mins={minA,minB};
		return mins;
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
