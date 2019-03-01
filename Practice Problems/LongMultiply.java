package zip;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LongMultiply {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(in.readLine());
		//String nos[];
		 long result,a,b;
		for(int i=0;i<n;i++) {
			String nos[] = in.readLine().split(" ");
			//String result = multiply(nos[0],nos[1]);
			a = Long.parseLong(nos[0]);
			b = Long.parseLong(nos[1]);
			result=a*b;
			out.write(String.valueOf(result));
			out.write('\n');
			
		}
		out.flush();

	}
	/*
	public static String multiply(String no1, String no2) {
		String prod;
		long a = Long.parseLong(no1);
		long b = Long.parseLong(no2);
		
		return prod;
		
	}*/

}
