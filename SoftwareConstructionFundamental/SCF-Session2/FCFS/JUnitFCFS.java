import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JUnitFCFS {

	@Test
	void testCompletionTime1() {
		JobScheduler fcfs = new JobScheduler(3, new int[][] { { 0, 5 }, { 3, 9 }, { 6, 6 } });
		fcfs.sortProcesses();
		assertArrayEquals(new int[] { 5, 14, 20 }, fcfs.computeCompletionTime());
		assertArrayEquals(new int[] { 5, 11, 14 }, fcfs.computeTurnAroundTime());
		assertArrayEquals(new int[] { 0, 2, 8 }, fcfs.computeWaitingTime());
		assertEquals(3.33, fcfs.computeAverageWaitingTime());
		assertEquals(8, fcfs.computeMaximumWaitingTime());
	}

	@Test
	void testCompletionTime2() {
		JobScheduler fcfs = new JobScheduler(3, new int[][] { { 7, 2 }, { 1, 5 }, { 8, 3 } });
		fcfs.sortProcesses();
		assertArrayEquals(new int[] { 6, 9, 12 }, fcfs.computeCompletionTime());
		assertArrayEquals(new int[] { 5, 2, 4 }, fcfs.computeTurnAroundTime());
		assertArrayEquals(new int[] { 0, 0, 1 }, fcfs.computeWaitingTime());
		assertEquals(0.33, fcfs.computeAverageWaitingTime());
		assertEquals(1, fcfs.computeMaximumWaitingTime());
	}

}