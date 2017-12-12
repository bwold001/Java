/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bmicalculator;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

/**
 *
 * @author Beza
 */
public class BMIcalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Declare variables
        float weight = 0, heightInInches = 0;
        float bmi;
        
        // Declare a flag so that program will loop
        boolean f = true;
        while (f){
            
            //Declare another flag for valid user input
            boolean r = true;
            while (f) {
                // Ask user for weight
                String inputWeight = JOptionPane.showInputDialog("Please enter weight in" + "pounds: ");
                
                // Convert input string to float
                weight = Float.valueOf(inputWeight);
            
                // If input is not between 22 and 660 break loop.
                if (weight > 660 || weight < 22){
                    JOptionPane.showMessageDialog(null, "Please enter a valid weight");
                }
                else {
                    break;
                }
            }
            
            //Declare yet another flag for valid user height input
            boolean s = true;
            while (s){
                // Ask user for height
                String inputHeight = JOptionPane.showInputDialog("Please enter height in" + " inches: ");
                // Convert input string to float
                heightInInches = Float.valueOf(inputHeight);
                    
                // If height in feet is not between 10 and 90, then break loop
                if (heightInInches > 90 || heightInInches < 10){
                    JOptionPane.showMessageDialog(null, "Please enter a valid height");
                }
                else{
                    break;
                }
            }
            
            // Calculate BMI
            bmi = (float) (((weight)*703/((heightInInches)*(heightInInches))));
        
            // Format BMI to two one decimal
            DecimalFormat newBmi = new DecimalFormat("#.0");
        
            // Depending on the user's BMI display resul along with messages.
            if (bmi <= 18.5){
                JOptionPane.showMessageDialog(null, "Your BMI is: " + newBmi.format(bmi) + "\n"
                        + "Risk of developing problems such as nutritional deficiency and osteoporosis");
            }
            else if (bmi >= 18.5 && bmi <= 23 ){
                JOptionPane.showMessageDialog(null, "Your BMI is: " + newBmi.format(bmi) + "\n"
                    + "Low Risk (healthy range)");
            }
            else if (bmi >= 23 && bmi <= 27.5){
                JOptionPane.showMessageDialog(null, "Your BMI is: " + newBmi.format(bmi) + "\n"
                    + "Moderate risk of developing heart disease, high blood pressure, stroke, diabetes");
            }
            else if (bmi >= 27.5){
                JOptionPane.showMessageDialog(null, "Your BMI is: " + newBmi.format(bmi) + "\n"
                    + "High risk of developing heart disease, high blood pressure, stroke, diabetes");            
            }  
    }
}
}