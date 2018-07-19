/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackpalindrome;

import java.util.Stack;
import java.util.Scanner;

/**
 *
 * @author SHUBHAM JAIN
 */
public class StackPalindrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Enter the String:");
        Scanner str = new Scanner(System.in);
        String inputString = str.nextLine();
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i<inputString.length(); i++){
           
            stack.push(inputString.charAt(i));
           
        }
        
        String reverseString = "";
        
        while(!stack.isEmpty()){
            reverseString = reverseString + stack.pop();
        }
        
        if(inputString.equals(reverseString))
            System.out.println("String is Palindrome");
        else
            System.out.println("String is not Palindrome");
        
    }
    
}
