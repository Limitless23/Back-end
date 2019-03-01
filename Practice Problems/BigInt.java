package zip;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BigInt {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String n = scanner.nextLine();
        BigInteger b = new BigInteger(n);
        System.out.println(b.isProbablePrime(5));
        
        scanner.close();
    }
}

