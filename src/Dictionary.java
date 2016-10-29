import java.io.PrintWriter;
import java.util.ArrayList;

public class Dictionary {
	private int origCharCount;
	private ArrayList<Entry> entryList=new ArrayList<Entry>();
	Dictionary(){
		origCharCount=0;
	}
	public void addChar(char c){
		Entry e=check(c);
		if (e==null)
			entryList.add(new Entry(c));
		else
			e.increment();
		origCharCount++;
	}
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
	/**
	 * If c is already contained in this dictionary's Charlist, returns that Entry, otherwise returns null
	 * @param c
	 */
	private Entry check(char c) {
		for (Entry e:entryList){
			if (e.getChar()==c)
				return e;
		}
		return null;
	}
	public int getCharCount(){return origCharCount;}
	public ArrayList<Entry> getEntryList() { return entryList; }
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
		   // do something
		}
	}

}
