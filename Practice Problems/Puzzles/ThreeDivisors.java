package zip;
/**
 * 
 * Given a value N. The task is to find how many numbers less than or equal to N have numbers of divisors exactly equal to 3.

Input:
The first line contains integer T, denoting number of test cases. Then T test cases follow. The only line of each test case contains an integer N.

Output :
For each testcase, in a new line, print the answer of each test case.

Constraints :
1 <= T <= 105
1 <= N <= 109

Example:
Input :
3
6
10
30

Output :
1
2
3
 * 
 * 
 */
import java.util.Scanner;

public class ThreeDivisors {
	
	
	public void divisors(long num) {
		
		double root = Math.sqrt(num);
		System.out.println(sieve((int)root));
		
	}
	
	public int sieve(int n) {
		int count =0;
		int[] arr = new int[n+2];
		for(int i=2;i<=n;i++) {
			arr[i]=1;
		}
		for(int i=2;i<=n;i++) {
			for(int j=2;i*j<=n;j++) {
				arr[j*i]=-1;
				
			}
		}
		
		for(int i=2;i<=n;i++) {
			if(arr[i]==1)
				count++;
		}
		
		return count;
		
	}
	
	public static void main(String[] args) {
		ThreeDivisors div = new ThreeDivisors();
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for(int i=0;i<n;i++) {
			div.divisors(scan.nextLong());
		}
		

	}

}
