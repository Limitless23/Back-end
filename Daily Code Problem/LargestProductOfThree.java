package dailyCodeProblem;

/**
 * 
 * 
 * @author Danny
 * Given a list of integers, return the largest product that can be made by multiplying any three integers.

For example, if the list is [-10, -10, 5, 2], we should return 500, since that's -10 * -10 * 5.

You can assume the list has at least three integers.
 */

public class LargestProductOfThree {
	
	static int list[] = {-10, -10, 5, 2};
	public void maxProd() {
		//A will hold the largest element, B the second largest and C the third
		int maxA = Integer.MIN_VALUE, maxB = Integer.MIN_VALUE, maxC = Integer.MIN_VALUE;
		int minA = Integer.MAX_VALUE, minB = Integer.MAX_VALUE;
		
		for(int i=0;i<list.length;i++) {
			
			if(list[i]>maxA) {
				
				maxC=maxB;
				maxB=maxA;
				maxA=list[i];
				
			}
			else if (list[i]>maxB) {
				maxC=maxB;
				maxB=list[i];
			}
			else if (list[i]>maxC) {
				maxC=list[i];
			}
			
			if(list[i]<minA) {
				minB=minA;
				minA=list[i];
			}
			else if(list[i]<minB) {
				minB=list[i];
			}
			
			
		}
		
		System.out.println("The max prod is: "+ Math.max((minA*minB*maxA), (maxA*maxB*maxC)));
		
		
	}
	public static void main(String[] args) {
		
		LargestProductOfThree prod = new LargestProductOfThree();
		prod.maxProd();

	}

}
