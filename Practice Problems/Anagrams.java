package zip;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagrams {

    static boolean isAnagram(String a, String b) {
    	Map<String, Integer> mapA = createMap(a);
    	Map<String, Integer> mapB = createMap(b);
    	
    	if(a.length()==0 || b.length()==0 || a.length()!=b.length()) {
    		return false;
    	}
    	
    	for(int i =0;i<a.length();i++) {
    		String ch = String.valueOf(a.charAt(i));
    		if(mapA.get(ch)!=mapB.get(ch)) {
    			return false;
    		}
    	}
    	
    
		return true;
        
    }
    
    public static Map<String,Integer> createMap( String a){
    	
    	Map<String, Integer> mapA = new HashMap<String, Integer>();
    	for(int i = 0;i<a.length();i++) {
    		if(mapA.get(String.valueOf(a.charAt(i)).toLowerCase())==null) {
    			mapA.put(String.valueOf(a.charAt(i)).toLowerCase(), 1);
    		}
    		else {
    			int n = mapA.get(String.valueOf(a.charAt(i)).toLowerCase());
    			mapA.replace(String.valueOf(a.charAt(i)).toLowerCase(), n+1);
    		}
    	}
		return mapA;
    	
    }

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}

