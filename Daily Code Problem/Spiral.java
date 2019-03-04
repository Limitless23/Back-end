package dailyCodeProblem;


/**
 * 
 * @author Danny
 * Problem: Given a N by M matrix of numbers, print out the matrix in a clockwise spiral.
 */


public class Spiral {
	
	int totNos = 20;  //product of matrix dimensions
	
	int arr[][] = {{1,  2,  3,  4,  5},
            {6,  7,  8,  9,  10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20}};
	 int level = -1;
	
	 
	 public void right(int i, int j) {
		 
		 while(j< arr[0].length && arr[i][j]!=Integer.MIN_VALUE) {
			 System.out.println(arr[i][j]);
			 arr[i][j]=Integer.MIN_VALUE;
			 totNos--;
			 if(totNos==0)
				 return;
			 j++;
		 }
		 
		 down(i+1,j-1);
	 }
	
	 
	 public void down(int i, int j) {
		 
		 while(i < arr.length && arr[i][j]!=Integer.MIN_VALUE) {
			 System.out.println(arr[i][j]);
			 arr[i][j]= Integer.MIN_VALUE;
			 totNos--;
			 if(totNos==0)
				 return;
			 i++;
		 }
		 
		 left(i-1,j-1);
	 }
	 
	 public void left(int i, int j) {
		 
		 while(j>=0 && arr[i][j]!=Integer.MIN_VALUE ) {
			 System.out.println(arr[i][j]);
			 arr[i][j]=Integer.MIN_VALUE;
			 totNos--;
			 if(totNos==0)
				 return;
			 j--;
		 }
		 
		 up(i-1,j+1);
	 }
	 
	 public void up(int i,int j) {
		
		 while(i>=0 && arr[i][j]!=Integer.MIN_VALUE) {
			 System.out.println(arr[i][j]);
			 arr[i][j]=Integer.MIN_VALUE;
			 totNos--;
			 if(totNos==0)
				 return;
			 i--;
		 }
		 
		 right(i+1,j+1);
	 }
	public static void main(String[] args) {
		
		Spiral print = new Spiral();
		print.right(0, 0);
		

	}

}
