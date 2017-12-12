/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import java.util.Scanner;

/**
 *
 * @author Beza
 */
public class Methods {

    //Calculates maximum of given values
    public static int max(int a, int b){
        if ((a > b) | (a == b)){
            return a;
        }
        return b;
    }
    
    //Calculates minimum of given values
    public static int min(int a, int b){
        
        if ((a < b) | (a == b)){
            return a;
        }
        return b;
    }
    
    //Calculates average of three given values
    public static double average(int a, int b, int c){
        int sum = a + b + c;
        double average = sum/3;
        return average;
    }
    
    //Calculates a given value rasied to a second given value
    public static double power(int a, int b){
        boolean correct = false;
        double result = 1;
        try {
            if(b>0) correct=true;
        }
        catch (Exception exception){
            if(b<0) System.err.println(exception.getMessage() + "\n");
        }
        if ((a==0) && (b==0)){
            result = 0;
        }
        
        for (int i=0; i<b; i++){
            result *= a;
        }
        return result;
    }
    
    //Determines whether a given value is odd or not
    //Returns false if value is 0
    public static boolean odd(int a){
        if (a==0){
            return false;
        }
        return a%2 == 1;
    }

    //Determines whether a given value is even or not
    //Returns false if value is 0
    public static boolean even(int a){

        return !((odd(a)) | (a==0));
    }    
    
    //Determines whether a given value is positive or not
    //Returns false if value is 0
    public static boolean positive(int a){
        return a > 0;
    }
    
    //Determines whether a given value is negative or not
    //Returns false if value is 0
    public static boolean negative(int a){
        return !((a==0) | (positive(a)));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        OUTER:
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Press 1 for Max");
            System.out.println("Press 2 for Min");
            System.out.println("Press 3 for Average");
            System.out.println("Press 4 for Power");
            System.out.println("Press 5 for Odd");
            System.out.println("Press 6 for Even");
            System.out.println("Press 7 for Positive");
            System.out.println("Press 8 for Negative");
            System.out.println("Press 9 to exit");
            String choice = scan.nextLine();
            int input = Integer.parseInt(choice);
            switch (input) {
                case 1:
                    System.out.println("Please enter first number: ");
                    String firstMaxNum = scan.nextLine();
                    int firstMax = Integer.parseInt(firstMaxNum);
                    System.out.println("Please enter second number: ");
                    String secondMaxNum = scan.nextLine();
                    int secondMax = Integer.parseInt(secondMaxNum);
                    System.out.println("Maximum is: " + 
                            max(firstMax, secondMax));
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Please enter first number: ");
                    String firstMinNum = scan.nextLine();
                    int firstMin = Integer.parseInt(firstMinNum);
                    System.out.println("Please enter second number: ");
                    String secondMinNum = scan.nextLine();
                    int secondMin = Integer.parseInt(secondMinNum);
                    System.out.println("Minimum is: " + min(firstMin, 
                            secondMin));
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Please enter first number: ");
                    String firstAveNum = scan.nextLine();
                    int firstAve = Integer.parseInt(firstAveNum);
                    System.out.println("Please enter second number: ");
                    String secondAveNum = scan.nextLine();
                    int secondAve = Integer.parseInt(secondAveNum);
                    System.out.println("Please enter third number: ");
                    String thirdAveNum = scan.nextLine();
                    int thirdAve = Integer.parseInt(thirdAveNum);
                    System.out.println("Average is: " + average(firstAve,
                                                        secondAve, thirdAve));
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Please enter first number: ");
                    String firstPowNum = scan.nextLine();
                    int firstPow = Integer.parseInt(firstPowNum);
                    System.out.println("Please enter second number: ");
                    String secondPowNum = scan.nextLine();
                    int secondPow = Integer.parseInt(secondPowNum);
                    System.out.println("Answer is: " 
                            + power(firstPow, secondPow));
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Please enter number: ");
                    String firstOddNum = scan.nextLine();
                    int firstOdd = Integer.parseInt(firstOddNum);
                    System.out.println(odd(firstOdd));
                    System.out.println();
                    break;    
                case 6:
                    System.out.println("Please enter number: ");
                    String firstEvenNum = scan.nextLine();
                    int firstEven = Integer.parseInt(firstEvenNum);
                    System.out.println(even(firstEven));
                    System.out.println();
                    break;
                case 7:
                    System.out.println("Please enter number: ");
                    String firstPosNum = scan.nextLine();
                    int firstPos = Integer.parseInt(firstPosNum);
                    System.out.println(positive(firstPos));
                    System.out.println();
                    break;
                case 8:
                    System.out.println("Please enter number: ");
                    String firstNegNum = scan.nextLine();
                    int firstNeg = Integer.parseInt(firstNegNum);
                    System.out.println(negative(firstNeg));
                    System.out.println();
                    break;
                case 9:
                    break OUTER;
                default:
                    break;
            }
        }
    }
    
}
