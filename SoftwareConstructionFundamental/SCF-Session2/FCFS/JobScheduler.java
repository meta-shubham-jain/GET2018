import java.util.Scanner;

/**
 * This class will evaluate completion time, turn around time, waiting time,
 * average waiting time, maximum waiting time process and displays all the above
 * mention details for FCFS scheduling.
 * 
 * @author Shubham Jain
 *
 */
public class JobScheduler {
	private int noOfProcess;
	private int processId;
	private float averageWaitingTime;
	private int maxWaitingTime;
	private int input[][];
	private int completion[];
	private int waiting[];
	private int turnaround[];

	/**
	 * It will initialize the variables of class.
	 * 
	 * @param value
	 *            assigns process id to process variable.
	 */
	JobScheduler(int value) {
		noOfProcess = value;
		averageWaitingTime = 0;
		maxWaitingTime = 0;
		input = new int[noOfProcess][2];
		completion = new int[noOfProcess];
		waiting = new int[noOfProcess];
		turnaround = new int[noOfProcess];
	}

	/**
	 * This method will take the Arrival time and Burst time for each process
	 * from the user.
	 */
	void get() {
		int value;
		Scanner sc = new Scanner(System.in);
		for (int i = 0, j = 0; i < noOfProcess; i++) {
			j = 0;
			System.out.println("Enter Arrival time for " + (i + 1) + " process");
			value = sc.nextInt();
			input[i][j++] = value;
			System.out.println("Enter Burst time for " + (i + 1) + " process");
			value = sc.nextInt();
			input[i][j] = value;
		}
		sortProcesses();
	}

	/**
	 * This method calculate the completion time for each process.
	 */
	void computeCompletionTime() {
		int time = 0;
		for (int i = 0; i < noOfProcess; i++) {
			if (input[i][0] > time) {
				time = time + (input[i][0] - time);
				i--;
				continue;
			} else {
				time = time + input[i][1];
				completion[i] = time;
			}
		}
	}

	/**
	 * This method calculate the waiting time for each process.
	 */
	void computeWaitingTime() {
		for (int i = 0; i < noOfProcess; i++) {
			waiting[i] = turnaround[i] - input[i][1];
		}
	}

	/**
	 * This method calculate the turn around time for each process.
	 */
	void computeTurnAroundTime() {
		for (int i = 0; i < noOfProcess; i++) {
			turnaround[i] = completion[i] - input[i][0];
		}
	}

	/**
	 * This method calculate average waiting time of processes.
	 */
	void computeAverageWaitingTime() {
		for (int i = 0; i < noOfProcess; i++) {
			averageWaitingTime = averageWaitingTime + waiting[i];
		}
		averageWaitingTime = averageWaitingTime / noOfProcess;
	}

	/**
	 * This method compute the maximum waiting time of the process with process
	 * id.
	 */
	void computeMaxWaitingTime() {
		maxWaitingTime = 0;
		for (int i = 0; i < noOfProcess; i++) {
			if (maxWaitingTime <= waiting[i]) {
				maxWaitingTime = waiting[i];
			}
		}
	}

	/**
	 * This method initiate the computing of completion time, turn around time,
	 * waiting time, average waiting time, maximum waiting time of process.
	 */
	void compute() {
		computeCompletionTime();
		computeTurnAroundTime();
		computeWaitingTime();
		computeAverageWaitingTime();
		computeMaxWaitingTime();
	}

	/**
	 * This method displays the completion time, turn around time, waiting time,
	 * average waiting time, maximum waiting time of process.
	 */
	void display() {
		System.out.println("Process Id\tArrival Time\tBurst Time\tCompletion Time \tWaiting time\tTurn Around Time");
		for (int i = 0; i < noOfProcess; i++) {
			System.out.print((i + 1) + "\t\t" + input[i][0] + "\t\t"+ input[i][1] + "\t\t" + completion[i]);
			System.out.println("\t\t\t" + waiting[i] + "\t\t" + turnaround[i]);
		}
		System.out.println("Average waiting Time = " + averageWaitingTime);
		System.out.println("Maximun waiting Time  = " + maxWaitingTime);
	}

	/**
	 * It will sort the number of processes according to arrival time.
	 */
	private void sortProcesses() {
		for (int i = 0; i < noOfProcess; i++) {
			for (int j = 0; j < noOfProcess - i - 1; j++) {
				if (input[j][0] > input[j + 1][0]) {
					swap(j, j + 1);
				}
			}
		}
	}

	/**
	 * It will swap arrival time and burst time for the given two processes
	 * 
	 * @param index1
	 * @param index2
	 */
	private void swap(int index1, int index2) {
		int temporary1 = input[index1][0];
		int temporary2 = input[index1][1];
		input[index1][0] = input[index2][0];
		input[index1][1] = input[index2][1];
		input[index2][0] = temporary1;
		input[index2][1] = temporary2;
	}
}