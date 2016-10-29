import java.io.PrintWriter;
import java.util.ArrayList;

public class Dictionary {
	private int origCharCount;
	private ArrayList<Entry> entryList=new ArrayList<Entry>();
	/**
	 * generates a Dictionary with an empty entryList and an origCharCount of 0
	 */
	Dictionary(){
		origCharCount=0;
	}
	/**
	 * Adds one character to the dictionary, 
	 * if it has already seen that character it increments the entry
	 * otherwise it creates a new entry with that character
	 * @param c character to be added
	 */
	public void addChar(char c){
		Entry e=check(c);
		if (e==null)
			entryList.add(new Entry(c)); //make new entry if we haven't seen it before
		else
			e.increment(); //increment if we have
		origCharCount++;
	}
	/**
	 * If c is already contained in this dictionary's Charlist, returns that Entry, otherwise returns null
	 * @param c character to check
	 */
	private Entry check(char c) {
		for (Entry e:entryList){
			if (e.getChar()==c)
				return e;
		}
		return null;
	}
	/**
	 * sort function sorts entries from lowest count to highest count! The entry's sums will increase monotonically, ie. each one is >= to the one before it
	 */
	public void sort(){
		ArrayList<Entry> sorted = new ArrayList<Entry>();
		while(entryList.size()>0){
			int minIndex=0;
			Entry min=entryList.get(0);
			Entry e;
			for (int i=0; i<entryList.size(); i++){
				e=entryList.get(i);
				if (e.getCount()<min.getCount()){
					min=e;
					minIndex=i;
				}
			}
			sorted.add(min);
			entryList.remove(minIndex);
		}
		entryList=sorted;
	}
	
	public int getCharCount(){return origCharCount;}
	public ArrayList<Entry> getEntryList() { return entryList; }
	/**
	 * Outputs the contents of the dictionary into a readable text file
	 */
	public void writeMe(){
		ArrayList<String> lines=new ArrayList<String>();
		for (Entry e: entryList){
			String line=null;
			if (e.getChar()=='\n')
				line="<LF>"+"\t"+e.getBinary();
			else
				line=e.getChar()+"\t"+e.getBinary();
			lines.add(line);
		}
		try{
			System.out.println("Printing Dictionary into text file");
		    PrintWriter writer = new PrintWriter("asgmt3partA.txt", "UTF-8");
		    for (String l:lines)
		    	writer.println(l);
		    writer.close();
		} catch (Exception e) {
			System.out.println("Something has gone terribly wrong");
		}
	}
	/**
	 * returns the binary from the entry for character c
	 * @param c character to find the corresponding entry for
	 * @return c's entry's Binary String
	 */
	public String encode(char c) {
		Entry e=check(c);
		if (e==null)
			System.out.println("Check function isn't working!! We shouldn't have gotten here!");
		return e.getBinary();
	}

}
