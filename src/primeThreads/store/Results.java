
package primeThreads.store;

import java.util.Vector;


public class Results implements StdoutDisplayInterface {
    // appropriate data structure as private data member
	private Vector<Integer> primes = new Vector<>();

    // appropriate method to save prime number to the data structure
	public void insert_num(int num) {
		primes.addElement(num);
	}

    public void writeSumToScreen() {
    	int sum = 0;
	    for (int i = 0; i < primes.size(); i++) {
	    	sum += primes.get(i);
	    }
        System.out.println(sum);
    }
} 


