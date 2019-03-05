package zip;

import java.util.Scanner;

/**
 * 
 * 
 * @author Danny
 * Given a sample space S consisting of all perfect squares starting from 1, 4, 9 and so on. You are given a number N, you have to print the number of integers less than N in the sample space S.

Input :
The first line contains an integer T, denoting the number of test cases.Then T test cases follow. The first line of each test case contains an integer N, denoting the number.

Output :
Print the answer of each test case in a new line.

Constraints :
1<=T<=100
1<=N<=10^18

Example
Input :
2
9
3

Output :
2
1
 */
public class CountSquares {

	public static void main(String[] args) {
		

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for(int i=0;i<n;i++){
		    long num = scan.nextLong();
		    double root = Math.sqrt(num);
		    if(root%1 == 0)
		        System.out.println((int)root - 1);
		    else 
		        System.out.println((int)root );
		}
	}

}
