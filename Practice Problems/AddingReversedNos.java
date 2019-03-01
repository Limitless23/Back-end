package zip;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class AddingReversedNos {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n =Integer.parseInt(in.readLine());
		for(int i=0;i<n;i++) {
			String[] number = in.readLine().split(" ");
			int sum = reversedSum(number[0], number[1]);
			out.write(String.valueOf(sum));
			out.write("\n");
		}
		
		out.flush();

	}
	
	public static int reversedSum(String a, String b) {
		
		int rev1,rev2,sum ;
		StringBuilder r = new StringBuilder();
		r.append(a);
		rev1 = Integer.parseInt(String.valueOf(r.reverse()));
		StringBuilder s = new StringBuilder();
		s.append(b);
		rev2 = Integer.parseInt(String.valueOf(s.reverse()));	
		
		sum = rev1+rev2;
		StringBuilder f = new StringBuilder();
		f.append(sum);
		return Integer.parseInt(String.valueOf(f.reverse()));
		
	}

}
