/**
 * CMPE 380 Assignment 3- 
 * @author Sam Codrington & Aidan Gunda
 * @date Oct 26th, 2016
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.*;
public class assignment3 {

	public static void main(String[] args) {
		// TODO read file
		System.out.println("Assignment 3- Sam Codrington & Aidan Gunda");
		String samMcGee=readFile("Sam McGee.txt");
		System.out.println ("Successfully Read SamMcGee.txt");
		/* Part a) build a Huffman code for a text document, and compute the total number of bits needed to
		store the encoded document. Compare this to the number of bits required if each character is
		stored with 8 bits (as in ASCII).
		When completing part a), remember that "line feed" is a character that needs to be encoded as
		well, so that the document can be successfully restored.*/
		Huffman partA=new Huffman(samMcGee);
		System.out.println("Loaded into Huffman Object");

		/*
		Part b)  read a text file that contains a Huffman Code and store the code-strings in an appropriate
		data-structure, then use that code to decode a text file consisting solely of 1's and 0's (In this
		lab we will use the characters "1" and "0" to simulate individual bits)
		 */
		// TODO 

	}

	private static String readFile(String fileName) {
		char c;
		ArrayList<Character> charList=new ArrayList<Character>();

		try {
			File file=new File(fileName);			
			InputStream in=new FileInputStream(file);
			Reader reader= new InputStreamReader(in,"UTF-8");
			Reader br = new BufferedReader(reader);
			charList=readChar(br);
		} catch (FileNotFoundException ex) {
			System.out.println("File not found!");
			ex.printStackTrace();
		} catch (IOException ex) {
			System.out.println("IO Error");
			ex.printStackTrace();
		}


		Iterator<Character> it = charList.iterator();
		StringBuilder sb = new StringBuilder();

		while(it.hasNext()) {
			sb.append(it.next());
		}
		return sb.toString();

	}

	private static ArrayList<Character> readChar(Reader br) throws IOException {
		ArrayList<Character> charList=new ArrayList<Character>();
		int i;
		int n=1;
		while (br.read()!=0xFEFF){
			br.mark(n);
			br.reset();
			n++;
		}
		while ((i=br.read())!=-1){
			char c=(char) i;
			charList.add(c);

		}
		return charList;
	}

}
