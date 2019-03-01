package zip;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ListOfArrayLists {

	public static void main(String[] args) throws NumberFormatException, IOException {
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>(); 
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		//String s = "Hey how are you doing";
		//we.addAll(Arrays.asList(s.split(" ")));
		//System.out.println(we.toString());
		ArrayList<String> temp;
		int n = Integer.parseInt(in.readLine());
		for(int i=0;i<n;i++) {
			temp= new ArrayList<String>();
			temp.addAll(Arrays.asList(in.readLine().split(" ")));
			list.add(temp);			
		}
		//System.out.println(list.toString());
		int q = Integer.parseInt(in.readLine());
		for(int i=0;i<q;i++) {
			temp = new ArrayList<String>();
			String xy[] = in.readLine().split(" ");
			int x = Integer.parseInt(xy[0]);
			int y = Integer.parseInt(xy[1]);
			try {
				 out.write(list.get(x-1).get(y));
				 out.write("\n");
				
			} catch (IndexOutOfBoundsException e) {
				out.write("ERROR!");
				out.write("\n");
			}
			
			
		}
		out.flush();
		
		
	}

}
