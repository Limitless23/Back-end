package zip;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PrimeGenerator {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int a = Integer.parseInt(in.readLine());
		for(int i=0;i<a;i++) {
			String nos[] = in.readLine().split(" ");
			int m = Integer.parseInt(nos[0]);
			int n = Integer.parseInt(nos[1]);
			
			for(int k=m;k<=n;k++) {
				
				if(k>10) {
					if((k%2 ==0) || (k%3 == 0) || (k%5 == 0) || (k%7 == 0)) {
						continue;
					}
					else if(isPrime(k)) {
						out.write(String.valueOf(k));
						out.write('\n');

						
					}
					 
				}
				else {
					if(isPrime(k)) {
						out.write(String.valueOf(k));
						out.write('\n');
					
				}
		
				}
				}
			out.write('\n');
			}
			out.flush();
			
		}
		
		
		
	

	public static boolean isPrime(int number) {
		
		boolean flag = true;
		for(int i=2;i<=Math.sqrt(number);i++) {
			if(number%i == 0) {
				flag=false;
				break;
			}
		}
		if(flag && number!=1) {
			return true;
		}
		else return false;
		
		
	}

}
