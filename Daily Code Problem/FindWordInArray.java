package dailyCodeProblem;

import java.util.Scanner;

/**
 * 
 * @author Danny
 *
 *	Given a 2D matrix of characters and a target word, write a function that returns whether the word can be found in the matrix by going left-to-right, or up-to-down.

For example, given the following matrix:

[['F', 'A', 'C', 'I'],
 ['O', 'B', 'Q', 'P'],
 ['A', 'N', 'O', 'B'],
 ['M', 'A', 'S', 'S']]

and the target word 'FOAM', you should return true, since it's the leftmost column. Similarly, given the target word 'MASS', you should return true, since it's the last row.
 */

public class FindWordInArray {
	
	char arr[][] = {{'F', 'A', 'C', 'I'},
					{'O', 'B', 'Q', 'P'},
					{'A', 'N', 'O', 'B'},
					{'M', 'A', 'S', 'S'}};
	
	public  boolean leftToRight(String word) {
		
		for(int i=0;i<arr.length;i++) {
			
			for(int j=0;j<arr[0].length;j++) {
				
				if(arr[i][j]==word.charAt(0)) { 
						
					if((arr[0].length-j)>=word.length()) {
						
						if(UpDown(word,j,i,1))
							return true;
						
					}
					
					if((arr.length-i)>=word.length()) {
						if(UpDown(word, i ,j,0))
							return true;
					}
			}}
			
		}
		
		return false;
		
	}
	
	public  boolean UpDown(String word, int i, int j,int flag) {
		int count =0;
		for(int t=i;t<word.length();t++) {
			if(flag==0) {
				if(arr[t][j]==word.charAt(count++) );
				else break;
			}
			else {
				if(arr[j][t]==word.charAt(count++));
				else break;
				}
			}
		if(count == word.length())
			return true;
		else return false;
		
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the String ");
		String word = scan.next();
		
		FindWordInArray find = new FindWordInArray();
		if(find.leftToRight(word) ) {
			System.out.println("It is present!");
		}
		else System.out.println("Word not found");
		
	}

}
