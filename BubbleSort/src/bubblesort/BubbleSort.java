/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblesort;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author Beza
 */
public class BubbleSort {
    
    //Bubble sort function
    public static void bubbleSort(int[] anArray){
        int len = anArray.length;
 
        boolean f = false;
        while (!f){
            for (int i=1; i<= len-1; i++){
                if (anArray[i-1] > anArray[i]){
                    // Swap the two numbers
                    int temp = anArray[i-1];
                    anArray[i-1] = anArray[i];
                    anArray[i] = temp;
                    f = true;                 
                }
            System.out.println(Arrays.toString(anArray));
            }                         
        }
    }
    
    // Phase One where the input is hardcoded 
    public static void phaseOne(){
        int[] num= {5, 7, 3, 9, 1, 0, 6};
        
        bubbleSort(num);
    }
    
    // Phase Two where user enters numbers to sort
    public static void phaseTwo(){
        // Get number of integers and make an array of that length
        Scanner scan = new Scanner(System.in);
        System.out.print("How many integers do you have? ");
        String len = scan.nextLine();
        int n = Integer.parseInt(len);
        
        int num[];
        num = new int[n];
        
        // Fill in array one by one with numbers gotten from user
        for (int i=0; i<=n-1; i++){
            System.out.print("Please enter number " + (i+1) + ":");
            num[i] = Integer.parseInt(scan.nextLine());
        }
        
        // Use bubble sort on the array
        bubbleSort(num);
    }
    
    // Give user option to choose either to run with internal values,
    // insterting their own numbers or exit the loop
    public static void main(String[] args) {
        
        OUTER:
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("0) Exit");
            System.out.println("1) Run with internal values");
            System.out.println("2) Fill in an array");
            String choice = scan.nextLine();
            int input = Integer.parseInt(choice);
            switch (input) {
                case 1:
                    phaseOne();
                    System.out.println();
                    break;
                case 2:
                    phaseTwo();
                    System.out.println();
                    break;
                case 0:
                    break OUTER;
                default:
                    break;
            }
        }
    }
}