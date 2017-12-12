/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encode;

import static java.lang.System.in;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Beza
 */
public class Encode {

    /**
     * @param args the command line arguments
     */
    // Ask user if they want to cypher or decypher a message.
    // According to what they select, it calls corresponding function.
    public static void main(String[] args) {
        OUTER:
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Do you want to (C)ypher or (D)ecypher?");
            System.out.println("Type 'E' to exit.");
            String choice = scan.nextLine();
            char c = choice.charAt(0);
            switch (c) {
                case 'C':
                    cypher();
                    System.out.println();
                    break;
                case 'D':
                    decypher();
                    System.out.println();
                    break;
                case 'E':
                    break OUTER;
                default:
                    break;
            }
        }
        }

    // Decyphers a message by looping through every character in the
    // user's input word to it's ASCII equivalent. It then checks if
    // the value is in the 32-126 range. Finally, it subtracts the 
    // given key from the ASCII and converts it back to charactes.  
    private static void decypher() {
        
        Scanner scan = new Scanner(System.in);
        String word;
        int key, wordLength;
        
        System.out.println("Please enter the message to decypher: ");
        word = scan.nextLine();
        wordLength = word.length();
        System.out.println();
        System.out.println("Please enter a decyphering key: ");
        key = scan.nextInt();
        String converted=""; 
        for (int i=0; i<wordLength; i++){
            char character = word.charAt(i);
            int ascii = (int) character-key;
            int adjustedAscii = adjustRange(ascii);
            char conv = (char) adjustedAscii;
            converted += Character.toString(conv); 
        }
        System.out.println();
        System.out.println("Decyphered text is: "+converted);

    }

    // Does the same thing as decypher but adds the key instead of
    // subtracting
    private static void cypher() {
        
        Scanner scan = new Scanner(System.in);
        String word;
        int key, wordLength;
        
        System.out.println("Please enter the message to cypher: ");
        word = scan.nextLine();
        wordLength = word.length();
        System.out.println();
        System.out.println("Please enter a cyphering key: ");
        key = scan.nextInt();
        String converted=""; 
        for (int i=0; i<wordLength; i++){
            char character = word.charAt(i);
            int ascii = (int) character+key;
            int adjustedAscii = adjustRange(ascii);                    
            char conv = (char) adjustedAscii;
            converted += Character.toString(conv); 
        }
        System.out.println();
        System.out.println("Cyphered text is: "+converted);    
        
    }

    // Adjusts a giver ASCII to a 32-126 range.C
    private static int adjustRange(int ascii) {
        
        if (ascii>126){
            ascii = (ascii-126)+31;
            return ascii;
        }
        else if (ascii<32){
            ascii = (ascii-31)+126;
            return ascii;
        }
       return ascii;
    }
        
}    

