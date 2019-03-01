package zip;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class PerfectDivisors {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		//BUFFEREDREADER/WRITER IS MUCH FASTER THAN SCANNER!!!!
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		//System.out.print("Enter n ");
		int n=Integer.parseInt(scan.readLine());
		for(int nos =0;nos<n;nos++) {
			int number = Integer.parseInt(scan.readLine());
			int sum = 0;
			
			for(int i = 2; i<=Math.sqrt(number);i++) {
				if(number==1) {
				
					break;
				}
				if(number%i==0) {
					if(i==number/i)
						sum+=i;
					else 
						sum+=i+number/i;
					
				}
			}
			if(number==1) {
				out.write('0');
				out.write('\n');
				
			}
			else {
			out.write(String.valueOf(sum+1));
			out.write('\n');
			
			}
		}
		
		out.flush();
		}
		//Instant end = Instant.now();
		//Duration interval = Duration.between(start, end);
		
		}
	

