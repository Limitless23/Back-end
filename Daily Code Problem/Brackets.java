package dailyCodeProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Brackets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string;
		System.out.println("Enter the string");
		Scanner scan = new Scanner(System.in);
		string=scan.nextLine();
		
		ArrayList<Character> stack = new ArrayList<Character>();
		HashMap<Character,Character> map = new HashMap<Character,Character>();
		map.put('}', '{');
		map.put(']', '[');
		map.put(')', '(');
		int i;
		for( i = 0; i < string.length();i++) {
			
			if(stack.isEmpty() && map.containsKey(string.charAt(i))) {
				
				System.out.println("Not a valid string");
				return;
				
			}
			
			else if(!stack.isEmpty() && map.containsKey(string.charAt(i))) {
				if(stack.get(stack.size()-1)==map.get(string.charAt(i))) {
					stack.remove(stack.size()-1);
				}
			}
			
			else {
				stack.add(string.charAt(i));
			}
			
		}
		
		if(i==string.length() && stack.isEmpty()) {
			System.out.println("It is a valid string");
		}
		else {
			System.out.println("Not a valid string");
		}
		
		
		

	}

}
