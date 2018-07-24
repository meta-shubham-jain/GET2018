import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * This class will evaluate completionTime time, turn around time, waitingTime
 * time, average waitingTime time, maximum waitingTime time process and displays
 * all the above mention details for FCFS scheduling.
 * 
 * @author Shubham Jain
 *
 */
public class JobScheduler {
	private int noOfProcess;
	private int processId;
	private double averageWaitingTime;
	private int maxWaitingTime;
	private int input[][];
	private int completionTime[];
	private int waitingTime[];
	private int turnAroundTime[];

	/**
	 * It will initialize the variables of class.
	 * 
	 * @param valueassigns process id to process variable.
	 */
	JobScheduler(int value, int input[][]) {
		noOfProcess = value;
		averageWaitingTime = 0;
		maxWaitingTime = 0;
		this.input = input;
		completionTime = new int[noOfProcess];
		waitingTime = new int[noOfProcess];
		turnAroundTime = new int[noOfProcess];
	}

	/**
	 * This method calculate the completionTime time for each process.
	 */
	int[] computeCompletionTime() {
		int time = 0;
		for (int i = 0; i < noOfProcess; i++) {
			if (input[i][0] > time) {
				time = time + (input[i][0] - time);
				i--;
				continue;
			} else {
				time = time + input[i][1];
				completionTime[i] = time;
			}
		}
		return completionTime;
	}

	/**
	 * This method calculate the waitingTime time for each process.
	 */
	int[] computeWaitingTime() {
		for (int i = 0; i < noOfProcess; i++) {
			waitingTime[i] = turnAroundTime[i] - input[i][1];
		}
		return waitingTime;
	}

	/**
	 * This method calculate the turn around time for each process.
	 */
	int[] computeTurnAroundTime() {
		for (int i = 0; i < noOfProcess; i++) {
			turnAroundTime[i] = completionTime[i] - input[i][0];
		}
		return turnAroundTime;
	}

	/**
	 * This method calculate average waitingTime time of processes.
	 */
	double computeAverageWaitingTime() {
		DecimalFormat decimalFormatSpecifier = new DecimalFormat(".##");
		for (int i = 0; i < noOfProcess; i++) {
			averageWaitingTime = averageWaitingTime + waitingTime[i];
		}
		averageWaitingTime = (double) averageWaitingTime / noOfProcess;
		return Double.parseDouble(decimalFormatSpecifier.format(averageWaitingTime));
	}

	/**
	 * This method compute the maximum waitingTime time of the process with process id
	 */
	int computeMaximumWaitingTime() {
		maxWaitingTime = 0;
		for (int i = 0; i < noOfProcess; i++) {
			if (maxWaitingTime <= waitingTime[i]) {
				maxWaitingTime = waitingTime[i];
			}
		}
		return maxWaitingTime;
	}

	/**
	 * It will sort the number of processes according to arrival time.
	 */
	void sortProcesses() {
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