import java.util.Scanner;

/**
 * This class will take the process number from user and call the JobScheduler class.
 * @author Shubham Jain
 *
 */

public class Fcfs {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 System.out.println("Enter number of Processes:");
	     Scanner sc = new Scanner(System.in);
	     int input = sc.nextInt();
		 
	     JobScheduler job = new JobScheduler(input);
	     job.get();
	     job.compute();
		 job.display(); 
	
	}

}
