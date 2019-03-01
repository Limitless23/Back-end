package zip;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Abbreviations {

    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {
    	int aLen = a.length();
        int bLen = b.length();
        boolean match = false;
        int i = 0;
        int j = 0;
        if(aLen<bLen)
            return "NO";

            while(j<aLen){
                String bChar=null;
                if(i<bLen)
                     bChar = String.valueOf(b.charAt(i));
                
                String aChar = String.valueOf(a.charAt(j)).toUpperCase();
                if(i==bLen && Character.isUpperCase(a.charAt(j))){
                    return "NO";
                }

                else if(Character.isUpperCase(a.charAt(j)) && !bChar.equals(aChar)){
                    return "NO";
                }      
                
                if( i<bLen && bChar.equals(aChar)){
                    i++;
                    j++;
                }
                else j++;
                
            }
            if(i==bLen)
                return "YES";
            else return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String a = scanner.nextLine();

            String b = scanner.nextLine();

            String result = abbreviation(a, b);
            
            System.out.println(result);
           // bufferedWriter.write(result);
           // bufferedWriter.newLine();
        }

        //bufferedWriter.close();

        scanner.close();
    }
}

