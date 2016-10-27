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
		
	}

	private class Node {
		int sum;
		Node left;
		Node right;

		Node (int s) {
			this.sum = s;
		}
	}
	private void setBinaries(Node n, String s){
		if (n.entry==null){
			
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
