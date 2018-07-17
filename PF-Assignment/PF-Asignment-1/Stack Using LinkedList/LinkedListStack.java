
package linkedliststack;

import java.util.LinkedList;
import java.util.Scanner;


/**
 *
 * @author SHUBHAM JAIN
 */

class LinkedListImplementation {

	LinkedList<Integer> list = new LinkedList<Integer>();
    private int topIndex = -1;
    
    
    LinkedListImplementation() {
    
        topIndex = -1;
        
    }

    
     int getTopIndex(){
    	
    	return topIndex;
    }
    
    void push(int number){
   
    	topIndex ++;
    	list.add(number);
                        
    }
    
    
    int pop(){
  
        topIndex--;
    	return list.remove();
    
    }
    
    int top(){
    
       return list.get(topIndex);
 
    }

   
    boolean isEmpty(){
    
        if(topIndex == -1){
        
            return true;
            
        }
    
        return false;
    
    
    }
    


}

public class LinkedListStack {

    
    public static void main(String[] args) {
        // TODO code application logic here
    	LinkedListImplementation stack = new LinkedListImplementation();
         
         while(true){
             
             System.out.println("Enter the Option number : ");
             System.out.println("1.Push\n2.Pop\n3.Top\n4.IsEmpty\n5.Exit");
             Scanner sc = new Scanner(System.in);
             int option = sc.nextInt();
        
             switch(option){
                 
                     case 1 : 
                             System.out.println("Enter the number to add in Stack");
                             int number = sc.nextInt();
                             
                             if (stack.getTopIndex() == 2){
                             	
                             	System.out.println("Overflow");
                             
                             } else {
                             	
                             	stack.push(number);
                             }
                             
                             break;
                              
                     case 2 : 
                             if(stack.getTopIndex()==-1){
                             
                             	System.out.println("Underflow");
                             
                             }else {
                             	
                              	int value = stack.pop();
                             	System.out.println(value);
                             
                             }	
                             
                             break;
                              
                     case 3 : 
                     	  if(stack.getTopIndex()==-1){
                               
                           	System.out.println("Underflow");
                     	  
                     	  }else{
                             
                     	    int top_element = stack.top(); 
                            System.out.println("Top Element:" + top_element);
                             
                     	  } 
                             break;
                             
                     case 4 :
                             if(stack.isEmpty()){
                             
                                 System.out.println("Stack is Empty");
                                 
                             }else{
                     
                                 System.out.println("Stack is Not Empty");
                             
                             }
                             
                             break;
                     
                     case 5 :
              
                             System.exit(1);
                             
                     default :
                             
                             System.out.println("Wrong Option. Enter the Option number :");
                             break;
                 
                 
                 }
         
         
         }
      
    }
    
}
