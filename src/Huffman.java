import java.util.ArrayList;

public class Huffman {
	private String textfile;
	private Dictionary dic=new Dictionary(); 
	private ArrayList<Node> nodeList=new ArrayList<Node>();

	/**
	 * Constructor from String
	 */
	Huffman(String s){
		textfile=s;
		readText();
		dic.sort();
		createBinaryTree();
		setBinaries(nodeList.get(nodeList.size()-1),"");
		dic.writeMe();
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
	private void createBinaryTree() {
		//Create all Leaves
		ArrayList<Node>clone=new ArrayList<Node>();
		for (Entry e: dic.getEntryList()){ 
			Node n=new Node(e);
			nodeList.add(n);
			clone.add(n);
		}
		// Begin to create the tree
		int[] mins=new int[2];
		while (clone.size()>1) {// we will have to make leaves-1 nodes always
			mins=findLeast(clone);

			Node n=new Node(clone.get(mins[0]),clone.get(mins[1]));
			nodeList.add(n);
			clone.add(n);
			if (mins[1]>mins[0]){
				clone.remove(mins[1]);
				clone.remove(mins[0]);
			}
			else{
				clone.remove(mins[0]);
				clone.remove(mins[1]);
			}
		}
	}
	private int[] findLeast(ArrayList<Node> a){
		int minA=0, minB=1;
		for (int j=2;j<a.size();j++){
			if (a.get(j).sum<a.get(minA).sum){
				minB=minA;
				minA=j;
			}
			else if(a.get(j).sum<a.get(minB).sum){
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

	public void encode(String filename) {
		// TODO Auto-generated method stub

	}
}
