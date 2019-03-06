package zip;

/**
 * 
 * 
 * Given two positive numbers x and y, check if y is a power of x or not.

Input:
First line contains an integer, the number of test cases 'T'. Each test case should contain two positive numbers x and y.


Output:
Print 1 if y is a power of x, else print 0.


Constraints: 
1<=T<=30
1<=x<=103
1<=y<=108


Example:
Input:
2
2 8
1 3

Output:
1
0
 */

import java.util.Scanner;

public class IsPower {

public void power(int x,int y) {
        
        boolean flag = false;
        
        if(x==1){
            if(y==1)
                flag=true;
            
        }
        else {
            
            double pow = Math.log(y)/Math.log(x);
            if(pow%1==0){
                flag=true;
            }
            
        }
        
        if(flag){
            System.out.println(1);
        }
        else System.out.println(0);
        
        
    }
    
	public static void main (String[] args) {
	    IsPower gfg = new IsPower();
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int x[] = new int[n];
		int y[] = new int[n];
		for(int i=0;i<n;i++){
		   gfg.power(scan.nextInt(),scan.nextInt());
		     
		}

}
}
