package com.company;

/**
 * Whoa. Concise code but way slower than mine...trying to understand this.
 */
public class Alt {//AHA! I GET IT NOW. This number just goes higher and higher looking for a number divisible by all numbers 1-20. Complete brute force.
    public static void main(String[] args) {  //Wow this is slow but concise...how does it work??
        boolean prime = false;
        int i = 1, number = 0;  //So i is the number we seeing if is represented
        while (!prime) {
            for (int j = 1; j <= 20; j++) {
                if (i % j != 0) {  //if the number we're checking doesn't have a factor of j
                    prime = false;  //it is prime
                    j = 21;  //jump out of this loop so we can continue to the next number
                } else prime = true;
            }
            if (prime) {//if the number was prime...
                number = i;
            }
            i++;
        }
        System.out.println(number);
    }
}
