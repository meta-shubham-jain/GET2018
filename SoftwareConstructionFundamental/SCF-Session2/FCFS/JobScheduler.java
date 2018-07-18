import java.util.Scanner;

/**
 * This class will evaluate completion time, turn around time, waiting time, average waiting time, maximum waiting time process
 * and displays all the above mention details. 
 * @author Shubham Jain
 *
 */

public class JobScheduler {
	
	int process;
	int process_id;
	float averageWaitingTime;
	int maxWaitingTime;
	int input [][];
    int completion[];
    int waiting[];
    int turnaround[];

   /**
    * It will initialize the variables of class. 
    * @param value assigns process id to process variable.
    */
    
    JobScheduler(int value){
	   
	   process = value;
	   averageWaitingTime=0;
	   maxWaitingTime=0;
	   input = new int[process][2];
	   completion = new int[process];
	   waiting = new int[process];
	   turnaround = new int[process];
	   	
   }
	
	/** 
	 * This method will take the Arrival time and Burst time for each process from the user.
	 */
    
    void get(){
    	
    	int value;
    	Scanner sc = new Scanner(System.in);
          
    	for(int i =0,j=0; i < process; i++){
    	    j=0;
	    	System.out.println("Enter Arrival time for "+(i+1)+" process");
	    	value = sc.nextInt();
	    	input[i][j++]= value;
	    
	    	System.out.println("Enter Burst time for "+(i+1)+" process");
	    	value = sc.nextInt();
	    	input[i][j]= value;
		   	  
      } 
    }
    
    /**
     * This method calculate the completion time for each process.
     */
    
    void computeCompletionTime(){
    
    	int time =0;
    	for(int i=0; i<process; i++){
    		
    	 time = time + input[i][1]; 	
    	 completion[i] = time;			
    
    	}
  	
     }
    
    /**
     * This method calculate the waiting time for each process.
     */
    
    void computeWaitingTime(){
    	
    	for(int i=0; i<process; i++){
    		
    		waiting[i]=turnaround[i]-input[i][1];
    		
    	}    	
    	
    }	
    
    /**
     * This method calculate the turn around time for each process.
     */
    
    void computeTurnAroundTime(){
    	
    	for(int i=0; i<process; i++) {
    		
    		turnaround[i]=completion[i]-input[i][0];
    		
    	}
    	
    }
   
    /**
     * This method calculate average waiting time of processes.
     */
    
    void computeAverageWaitingTime(){
    	
    	for(int i=0; i<process; i++){
    		
    		averageWaitingTime = averageWaitingTime + waiting[i];
    		
    	}
    	
    	averageWaitingTime = averageWaitingTime/process;
    }
    
    /**
     * This method compute the maximum waiting time of the process with process id.
     */
    
    void computeMaxWaitingTime(){
    	
    	maxWaitingTime = 0;

    	for(int i=0; i<process; i++){
    		
    		if(maxWaitingTime <=waiting[i]){
    			
    			maxWaitingTime = waiting[i];
    			process_id = i+1;
    			
    		}
    		
    		
    	}
       	
    	
    }
    
    /**
     * This method initiate the computing of completion time, turn around time, waiting time, average waiting time, maximum waiting time of process.
     */
    
       void compute(){
    	
    	computeCompletionTime();
    	computeTurnAroundTime();
    	computeWaitingTime();
    	computeAverageWaitingTime();
    	computeMaxWaitingTime();
    	
    	
    }
    
    /**
     * This method displays the completion time, turn around time, waiting time, average waiting time, maximum waiting time of process.
     */
    
    void display(){
    	
    	System.out.println("Process Id\tArrival Time\tBurst Time\tCompletion Time \tWaiting time\tTurn Around Time");
    		
    		for (int i=0; i<process; i++) {
    		
    			System.out.print((i+1) + "\t\t" + input[i][0] + "\t\t" + input[i][1] + "\t\t" + completion[i]);
    			System.out.println("\t\t\t" + waiting[i] + "\t\t" + turnaround[i]);
    		
    		}
    	
    	System.out.println("Average waiting Time = " + averageWaitingTime);
    	System.out.println("Maximun waiting Time  = " + maxWaitingTime + " for process Id " + process_id);	
    		
    	
    	
    }
    
    	
    	
    }
