package IPLAnalysisProblem;

import java.io.IOException;
import java.util.Iterator;

public class IPLAnalyser {
	public static void main(String args[])
	{
		System.out.println("Welcome To Main Branch");
		
		IPLDataReader reader = new IPLDataReader("./assets/1.csv");
		reader.sort(7);
		System.out.println("\n\nTop 5 Batting Averages");
	    printLines(5, reader, 7);
	    
	    reader.sort(8);
	    System.out.println("\n\nTop 5 Strike Rates");
	    printLines(5, reader, 8);
		
		try {
			reader.reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void printLines(int count, IPLDataReader reader, int column) {
		for(int i=0;i<count;i++) {
			String[] s = reader.table.get(i);
			System.out.println(s[1] + ": " + s[column]);
		}
	}
}
