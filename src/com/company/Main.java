package com.company;
//I'm pretty pleased at how it turned out! The range is small so I'm not really looking into optimizing this one.
//I started analyzing just a list of numbers seeing how it was mathematically possible. Came across a few realizations and then had fun learning how to implement my solution!
//In hindsight, pretty simple. I liked how I used the array :)
//Checking from smallest factors to largest. The only factors that are possible are prime numbers (2 is prime). Maybe I should have just generated prime numbers first...no not worth it for the range

public class Main {
    final static int max = 20;  //The number up to which we want all numbers to be a factor

    public static void main(String[] args) {
        int product = 1;
        int[] factors = new int[max];  //The position in the array represents the actual factor, the number at that position is the number of occurrences of that factor

        for (int i = 2; i < max + 1; i++) {  //Checking divisibility by numbers 2-20 inclusive.
            int temp = i;
            for (int j = 2; j < max; j++) {  //Checking to see if the number can be represented with current factors in the factors array
                int numOfFactor = factors[j];  //Don't want to change the actual value in the array so we make a copy

                while (temp % j == 0 && temp >= j) {  //While j, the current factor in the array, is a factor of i and i is smaller than j then divide by j and increment its occurrence in the factors array
                    if (numOfFactor > 0)  //If j is in the array of factors "use it" and decrement the counter for it
                        numOfFactor--;
                    else  //otherwise if the factor doesn't exist in the array add it by incrementing value at the position
                        factors[j]++;
                    temp /= j;  //No matter what, if temp had a factor, it gets smaller
                }
                if (temp < j)
                    break;  //Don't bother checking the rest of the array since larger numbers can't go into a smaller one...
            }
        }

        for (int i = 2; i < max; i++) {  //Find the product of all the factors
            if (factors[i] > 0) {
                for (int j = factors[i]; j > 0; j--) {  //If there are factors at position j, multiply them!
                    product *= i;
                }
            }
        }
        System.out.println(product);

    }
}
