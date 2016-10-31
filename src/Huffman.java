import java.io.PrintWriter;
import java.util.ArrayList;

public class Huffman {
	private String textfile;
	private Dictionary dic=new Dictionary(); 
	private Node head;
	private ArrayList<String> binVals = new ArrayList();

	/**
	 * Constructor from String
	 */
	Huffman(String s){
		textfile=s;
		readText();
		dic.sort();
		createBinaryTree();
		setBinaries(head,"");
		dic.writeMe();
	}
	/**
	 * Alternate Constructor From Dictionary string & encodedtextFile
	 * @param dic string representation of a Dictionary textfile
	 * @param bin string representation of an encoded textfile
	 */
	Huffman (ArrayList<String> dic, String bin){
		//might want to pass dic as an ArrayList<String>, with each line of the dictionary as it's own string
		this.dic = new Dictionary(dic);
		this.binVals = getBinary(bin);
	}
	//	TODO decode bin by
	//	TODO generate textfile of decoded file
	/** 
	 * readText method adds each character of the textfile into the dictionary
	 */
	private void readText(){
		int length=textfile.length();
		char c;
		for (int i=0;i<length;i++){
			c=textfile.charAt(i);
			dic.addChar(c);
		}			
	}
	/**
	 * createBinaryTree creates a full list of nodes
	 */
	private void createBinaryTree() {
		//Create all Leaves
		ArrayList<Node>clone=new ArrayList<Node>();
		for (Entry e: dic.getEntryList()){ 
			Node n=new Node(e);
			clone.add(n);
		}
		// Begin to create the tree
		int[] mins=new int[2];
		Node n=null;
		while (clone.size()>1) {// while there are still two objects to find the least of
			mins=findLeast(clone);

			n=new Node(clone.get(mins[0]),clone.get(mins[1]));
			clone.add(n);
			//remove larger indice first so the index is still accurate after the first removal
			if (mins[1]>mins[0]){ 
				clone.remove(mins[1]);
				clone.remove(mins[0]);
			}
			else{
				clone.remove(mins[0]);
				clone.remove(mins[1]);
			}
		}
		head=n; //last node created will be top of the binary tree! this is used in the setBinaries method
	}

	public String decode() {
		String fullText = null;
		String binaryString = null;

		for(int i = 0; i < binVals.size(); i++) {
			String binVal = binVals.get(i);
			binaryString += binVal;

			// Check if the series of binary values represents a "space" character
			if(binaryString == "01") {
				fullText += " ";
				binaryString = null;
			}
			// Check if the series of binary values represents a "line-feed" character
			else if(binaryString == "00011") {
				fullText += "\n";
				binaryString = null;
			}

			// Check if the series of binary values represents a character defined in
			// our dictionary
			else {
				for (int j = 0; j < dic.getEntryList().size(); j++) {
					if (binaryString == dic.getEntryList().get(i).getBinary()) {
						String temp = Character.toString(dic.getEntryList().get(i).getChar());
						fullText += temp;
						binaryString = null;
					}
				}
			}
		}

		return fullText;
	}

	/**
	 * The encode method prints a message detailing how many bits the Huffmann encoder saved
	 * @param filename
	 */

	public void encode(String filename) {
		int i=-1, length=0;
		String enc = null;
		try{
			System.out.println("Printing Dictionary into text file");
		    PrintWriter writer = new PrintWriter(filename, "UTF-8");
		    for (i=0;i<textfile.length();i++){
		    	enc=dic.encode(textfile.charAt(i));
		    	length+=enc.length();
		    	writer.write(enc);
		    }
		    writer.close();
		} catch (Exception e) {
			System.out.println("Something has gone terribly wrong");
		}
		System.out.println("Our Huffman object encoded a text file that would be "+i*8+" bits long in ASCII into a bit string that is "+length+ " bits long");
		System.out.println("This method saved "+(i*8-length)+" bits!!");

	}
	/**
	 * findLeast traverses a given ArrayList of Nodes and finds the Nodes with the least Sum and returns their indices in a int[] vertex
	 * @param a the ArrayList to be traversed
	 * @return mins = {min,2ndmin}
	 */
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
	
	/**
	 * setBinaries
	 * @param n
	 * @param s
	 */
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
	 * Creates a list of String values of 0 or 1, representing the individual binary characters
	 * of an encoded text file.
	 * @param binString
	 * @return
	 */
	private ArrayList<String> getBinary(String binString) {
		ArrayList<String> binList = new ArrayList();

		String[] temp = binString.split("");

		for(int i = 0; i < binString.length(); i++)
			binList.add(temp[i]);

		return binList;
	}
	/**
	 * Private class for nodes of binary tree, if entry is null== node is a branch, otherwise node is a leaf. 
	 * @author Aidan
	 */

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
}
