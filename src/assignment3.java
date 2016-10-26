/**
 * CMPE 380 Assignment 3- 
 * @author Sam Codrington & Aidan Gunda
 * @date Oct 26th, 2016
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class assignment3 {

	public static void main(String[] args) {
		// TODO read file
		System.out.println("Assignment 3- Sam Codrington & Aidan Gunda");
		String samMcGee=readFile("Sam McGee.txt");
		/* Part a) build a Huffman code for a text document, and compute the total number of bits needed to
		store the encoded document. Compare this to the number of bits required if each character is
		stored with 8 bits (as in ASCII).
		When completing part a), remember that "line feed" is a character that needs to be encoded as
		well, so that the document can be successfully restored.*/
		Huffman partA=Huffman();
		
		/*
		Part b)  read a text file that contains a Huffman Code and store the code-strings in an appropriate
		data-structure, then use that code to decode a text file consisting solely of 1's and 0's (In this
		lab we will use the characters "1" and "0" to simulate individual bits)
		*/
		// TODO 

	}

	private static String readFile(String fileName) {
		String line,text = null;

		try {
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(fileName));

			do {
				line = br.readLine();
				text+=line;
			} while(line != null);

		} catch (FileNotFoundException ex) {
			System.out.println("File not found!");
			ex.printStackTrace();
		} catch (IOException ex) {
			System.out.println("IO Error");
			ex.printStackTrace();
		}
		return text;
	}

}
