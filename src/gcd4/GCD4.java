/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcd4;

/**
 *
 * @author Jonah
 */
public class GCD4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int smallInt = 0;
        int largeInt = 0;
        
        int[] test1 = {12, 8, 4};
        int[] test2 = {49, 21, 7};
        int[] test3 = {252, 105, 21};
        int[] test4 = {60, 24, 12};
        int[] test5 = {1071, 462, 21};
        
        int[][] testArray = {test1, test2, test3, test4, test5};
        
        try {
            largeInt = Integer.parseInt(System.console().readLine("Enter the larger integer for the GCD: "));
        } catch(NumberFormatException e) {
            System.out.println("Sorry, your input should be an integer. Try again.");
            e.printStackTrace();
        }
        
        try {
            smallInt = Integer.parseInt(System.console().readLine("Enter the smaller integer for the GCD: "));
        } catch(NumberFormatException e) {
            System.out.println("Sorry, your input should be an integer. Try again.");
            e.printStackTrace();
        }
        
        int largeIntPrint = largeInt;
        int smallIntPrint = smallInt;
        
        int GCD = gcd(largeInt, smallInt);
        
        System.out.printf("The greatest common divisor of %d and %d is %d", largeIntPrint, smallIntPrint, GCD);
        
        System.out.println("");
        System.out.println("");
        
        for (int i = 0; i < testArray.length; i++) {
            int gcd = gcd(testArray[i][0], testArray[i][1]);
            
            if (gcd == testArray[i][2]) {
                System.out.printf("Test %d : gcd(%d, %d) = %d PASS", i+ 1, testArray[i][0], testArray[i][1], gcd);
                System.out.println("");
            } else {
                System.out.printf("Test %d : gcd(%d, %d) = %d FAIL: expected %d", i + 1, testArray[i][0], testArray[i][1], gcd, testArray[i][2]);
                System.out.println("");
            }
        }
    }
    
    static int gcd(int largeInt, int smallInt) {
        int subtraction = largeInt - smallInt;
        
        while (smallInt != subtraction) {
            if (smallInt < subtraction) {
                largeInt = subtraction;
                subtraction = largeInt - smallInt;
            } else {
                largeInt = smallInt;
                smallInt = subtraction;
                subtraction = largeInt - smallInt;
            }
        }
        
        int GCD = subtraction;
        
        return GCD;
    }
    
}
