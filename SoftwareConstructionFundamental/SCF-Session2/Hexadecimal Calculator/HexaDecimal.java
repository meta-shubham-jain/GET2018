import java.util.Scanner;

/**
 * This class takes operation number from user to perform the addition subtraction, multiplication, division and
 *  compare for greater than less than and equal to of two numbers.  
 *  @author Shubham Jain
 */

public class HexaDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HexCalc cal = new HexCalc();
		
		while(true) {
				
			System.out.println("Enter Operation to Perform:");
            System.out.println("1.Additon\n2.Subtraction\n3.Multiplication\n4.Division\n5.Comparision For Greater");
            System.out.println("6.Comparision For Smaller\n7.Comparision for Equal\n8.Exit");
            Scanner sc = new Scanner(System.in);

            int option = sc.nextInt();
           
        	System.out.println("Enter First Number in Hexadecimal");
			String input1 = sc.next();
			System.out.println("Enter Second Number in Hexadecimal");
			String input2 = sc.next();
			
			if((cal.isValid(input1)) && (cal.isValid(input2))) {
    
				switch(option) {
	            
	            case 1 :	
						
	            		System.out.println("Answer = " + cal.addition(input1,input2));
	            		break;
	            
	            case 2 :
		            	
	            		System.out.println("Answer = "+ cal.subtraction(input1,input2));
	            		break;
	            
	            case 3 :
	        		
		            	System.out.println("Answer = "+ cal.multiplication(input1,input2));
			        	break;
		        
	            case 4 :
	        			
		          		if(!(cal.hex2Decimal(input2)==0)){
	            		
		          			System.out.println("Answer = "+ cal.division(input1,input2));
		          			break;
		          		
		          		} else {
		          			
		          			System.out.println("Denominator shouldnt be zero");
		          			
		          		}
	            
	            case 5 :
	            	
	            		if(cal.comparisionForGreater(input1,input2)){
	            			
	            			System.out.println("Given number is greater");
	            			
	            		} else {
	            			
	            			System.out.println("Given number is not greater than Second Number");
	            		}

	            		break;
	            		
	            case 6 :
	            		
	            		if(cal.comparisionForSmaller(input1,input2)){
            			
	            			System.out.println("Given number is smaller");
            			
            		} else {
            			
            				System.out.println("Given number is not smaller than Second Number");
            		}
            
	            		break;
	            		
	            case 7 :
	            		

             		if(cal.comparisionForEqual(input1,input2)){
            		
             			System.out.println("Given number is Equal to second Number");
            			
            		} else {
            			
            			System.out.println("Given number is not equal to Second Number");
            		}
            
	            		break;
	            		
	            default :
		        	
	            		System.out.println("Wrong Option");
		        		break;
	        
           
            }
            
			
		} else {
			
			System.out.println("Given input is not Correct");

		}
	
	

		}
		
		
		
	}

}
