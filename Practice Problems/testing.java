package zip;

import java.util.Collections;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.NumberFormat;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class testing {
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		/*
		--------------CALENDAR----------------------------------------
		Calendar cal = Calendar.getInstance();
		
		cal.set(2018,12,20);
		
		
        //cal.set(year,month,day);
        int d = cal.DAY_OF_WEEK;
        String[] week = {" ","SUNDAY","MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY", "SATURDAY"};
    
		System.out.println(week[d]);
		*/
		
		//------------------CURRENCY, LOCALE, LIST OF STUFF------------------
		/*
		NumberFormat n = NumberFormat.getInstance();
		
		System.out.println(n.format(1234).toString());
		Locale lon = new Locale("en","IN");
		
		
		Locale list[] = {Locale.US,lon,Locale.CHINA,Locale.FRANCE};
		
		
		
		for(Locale l: list){
			NumberFormat nf = NumberFormat.getCurrencyInstance(l);
			System.out.println(nf.format(1234).toString());
			
		}
		*/

//}
	//--------------------------MAP---------------------------
	/*
	public static Map<String,Integer> dict =new HashMap<String,Integer>();
	public static void main(String []argh)
	{
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		in.nextLine();
		for(int i=0;i<n;i++)
		{
			String name=in.nextLine();
			int phone=in.nextInt();
			in.nextLine();
            insert(name,phone);
		}
		while(in.hasNext())
		{
			String s=in.nextLine();
            check(s);
		}

	}
    public static void check(String name){
    	if(!dict.containsKey(name)) {
    		System.out.println("Not found");
    	}
    	else {
    		System.out.println(name+"="+dict.get(name));
    	}
    	

    }

    public static void insert(String name, int phone){
            dict.put(name,phone);
    }
    */
	/*	
	//----------------------STACK-----------------------
		//put the below two lines outside the main
		//public static Map<Character,Character> m = new HashMap<>();
		//public staticStack st = new Stack();
		Scanner sc = new Scanner(System.in);
		m.put('(',')');
		m.put('{','}');
		m.put('[',']');
		
		while (sc.hasNext()) {
			String input=sc.next();
			check(input);
			st.clear();
			
		
			}
	}
	
	public static void check(String str) {
		boolean flag = true;
		int j = str.length();
		int i;
		do{
		for(i = 0; i<str.length();i++) {
			//System.out.println(str.charAt(i));
			try {
			if(m.containsKey(str.charAt(i))) {
				st.push(str.charAt(i));
				//System.out.println("pushed "+str.charAt(i));
			}
			
			else if(m.get(st.peek()).equals(str.charAt(i))){
				st.pop();
			}
			
			if(i==str.length()-1 && st.size()>0) {
				flag=false;
				
			}
			}
			catch(Exception EmptyStackException) {
				flag=false;
				break;
				
			}
			
		}
		}while(st.size()!=0 && flag==true);
		if(st.size()==0 && i==j)
			System.out.println(true);
		else System.out.println(false);
	}
	*/
		//-------------------------HASHSET----------------------
		//public static HashSet<String> hset = new HashSet<String>();
		
		/*String[] a= {"a","b"};
		
		String b = "dam";
		hset.add(a+b);
		*/
		/*
		//----------------------------GENERICS-------------------
		Integer[] intArray = { 1, 2, 3 };
		String[] stringArray = {"Hello", "World"};
		myprint(intArray);
		myprint(stringArray);
		
		-----this function needs to be outside the mainm or you can create a class for it and use its object
}
		static <T> void myprint(T[] element) {
			for(int i =0;i<element.length;i++) {
				System.out.println(element[i]);
				
			}
		}
		*/
		
		//InputStream s = System.in;
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//in.
		//Scanner scan = new Scanner(System.in);
		//{... 8,6,4}  -1 -4
		// -3 -2
		// 		  {1 ,2 ,5 ,4, 3, 7, 8, 6}
		System.out.println("Enter string: ");
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		
		char[] charList = s.toCharArray();
		LinkedHashSet<String> set = new LinkedHashSet<String>();
		
		set.add(s);
		
		do {
			
			for(int i=0;i<charList.length;i++) {
				for(int j=i+1;j<charList.length;j++) {
					char temp = charList[i];
					charList[i] = charList[j];
					charList[j]= temp;
					
					set.add(new String(charList));
				}
			}
			
		}
		while(!s.equals(new String(charList)));
		ArrayList l = new ArrayList(set);
		Collections.sort(l);
		System.out.println(l.toString());
		}

        

	        

        

        

    
		
		
		
		
        
}
	


