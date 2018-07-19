
package stackarray;


import java.util.Scanner;

class ImplementationOfStack{

    private int topIndex;
    private int stackArray[];
    
    ImplementationOfStack() {
    
        topIndex = -1;
        stackArray = new int[3];
        
    }

    
     int getTopIndex(){
    	
    	return topIndex;
    }
    
    void push(int number){
   
    	topIndex ++;
        stackArray[topIndex] = number ; 
                        
    }
    
    
    int pop(){
  
        return stackArray[topIndex--];
    
    }
    
    int top(){
    
       return stackArray[topIndex];
 
    }

   
    boolean isEmpty(){
    
        if(topIndex == -1){
        
            return true;
            
        }
    
        return false;
    
    
    }
    


}


public class StackArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        ImplementationOfStack stack = new ImplementationOfStack();
       
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
