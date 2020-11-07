package IPLAnalysisProblem;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.opencsv.CSVReader;
import java.util.*;
import java.lang.*;

public class IPLDataReader {

	public String fileName;
	public CSVReader reader;
	public ArrayList<String[]> table;
	
	public IPLDataReader(String fileName) {
		this.fileName = fileName;
		try {
			readFile();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		this.table = new ArrayList<String[]>();
		Iterator<String[]> it = this.reader.iterator();
		
		this.table = readFromIterator(it);
	}
	
	private void readFile() throws FileNotFoundException {
		this.reader = new CSVReader(new FileReader(this.fileName));
	}
	
	public void sort(int columnName) {
		
		Comparator<String[]> comparator = new Comparator<String[]>() {

			@Override
			public int compare(String[] arg0, String[] arg1) {
				
				Float a;
				try {
					a = Float.parseFloat(arg0[columnName]);
				}
				catch(Exception e) {
					a = 0.0f;
				}
				Float b;
				try {
					b = Float.parseFloat(arg1[columnName]);
				}
				catch(Exception e) {
					b = 0.0f;
				}
				return b.compareTo(a);
			}
		};
		
		Collections.sort(table, comparator);
	}
	
	private ArrayList<String[]> readFromIterator(Iterator<String[]> it) {
		ArrayList<String[]> lines = new ArrayList<String[]>();
	    while (it.hasNext()) {
	    	lines.add((String[])it.next());
	    }
	    return lines;
	}
}
