package dailyCodeProblem;
/**
 * 
 * @author Danny
 *
 *A number is considered perfect if its digits sum up to exactly 10.

Given a positive integer n, return the n-th perfect number.

For example, given 1, you should return 19. Given 2, you should return 28.
 */
public class PerfectNumber {
	
	
	public void findNth(int n) {
		
		int count = 0;
		
		for(int i=19;;i=i+9) {
			int sum = 0;
			for(int x=i;x>0;x=x/10) {
				sum+=x%10;
			}
			if(sum==10)
				count++;
			
			if(count==n) {
				System.out.println(i);
				break;
			}
			
		}
		
		
	}
	
	/*Most efficient method
	 * 
	 * public void findNth(int n) 
	{ 
    	int nthElement = 19 + (n - 1) * 9; 
    	int outliersCount = (int)Math.log10(nthElement) - 1; 
  
    // find the nth perfect number 
    	nthElement += 9 * outliersCount; 
    	System.out.println(nthElement); 
	} 
	 * 
	 * 
	 */
	
	
	public static void main(String[] args) {
		
		PerfectNumber perfect = new PerfectNumber();
		perfect.findNth(20);
	}

}
