package moneycalculator.Model;

import java.util.Iterator;

public class PrimeNumbers implements Iterable<Integer> {

    private int prime = 1;

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Integer next() {
                prime = getNextPrime(prime);
                return prime;
            }

            @Override
            public void remove() {
            }

            private int getNextPrime(int prime) {
                while (true) {
                    prime++;
                    if (isPrime(prime)) {
                        return prime;
                    }
                }
            }

            private boolean isPrime(int prime) {
                for (int i = 2; i < prime - 1; i++) {
                    if (prime % i == 0) {
                        return false;
                    }
                }
                return true;
            }
        };
    }
}