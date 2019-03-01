package zip;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SmallestPalindrome {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n =Integer.parseInt(in.readLine());
		for(int i=0;i<n;i++) {
			int number = Integer.parseInt(in.readLine());
			out.write(String.valueOf(checkSmallestPal(number)));
			out.write("\n");
		}
		
		out.flush();
		
		
	}
	
	public static int checkSmallestPal(int number) {
		number=number+1;
		int rev ;
		StringBuilder r = new StringBuilder();
		while(true) {
			r.append(String.valueOf(number));
			rev = Integer.parseInt(String.valueOf(r.reverse()));
			if(rev == number)
				break;
			else
			{
				number++;
				r = new StringBuilder();
			}
		}
		return rev;
		
	}
	
public static String checkPal(int number) {
		
		int rev ;
		StringBuilder r = new StringBuilder();
	
		r.append(String.valueOf(number));
		rev = Integer.parseInt(String.valueOf(r.reverse()));
		if(rev == number)
				return "YES";
		else if (number % rev == 0) {
			return "YES";
		}
		else
			{
				return "NO";
			}
		}

}
