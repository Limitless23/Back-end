package zip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;

public class BitSetDemo {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String nos[] = in.readLine().split(" ");
		int N = Integer.parseInt(nos[0]);
		int M = Integer.parseInt(nos[1]);
		BitSet B1 = new BitSet(N);
		BitSet B2 = new BitSet(N);
		B1.set(5);
		B2.set(5);
		B2.and(B1);
		System.out.println(B2);

	}

}
