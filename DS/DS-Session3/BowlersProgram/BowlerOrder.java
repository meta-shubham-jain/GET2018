import java.util.List;
import java.util.ArrayList;

/**
 * It will allocate the bowlers order to bowl
 * 
 * @author Shubham Jain
 *
 */
public class BowlerOrder {
    PriorityQueue queue;
    int totalNoOfBalls = 0;;

    BowlerOrder(int noOfBowlers) {
        queue = new PriorityQueue(noOfBowlers + 1);
    }

    /**
     * It will add bowlers in priority queue
     * 
     * @param noOfBalls
     * @param name
     */
    void addBowlers(int noOfBalls, String name) {
        queue.add(noOfBalls, name);
        totalNoOfBalls += noOfBalls;
    }

    /**
     * It will returns the list of order of bowlers to bowl
     * 
     * @param ballsToPlay
     * @return
     */
    List<String> allocateBowlers(int ballsToPlay) {
        List<String> bowlerOrder = new ArrayList<String>();
        if (ballsToPlay > totalNoOfBalls) {
            throw new AssertionError(
                    "Balls to be Played are more than Balls to be Delivered");
        }
        while (ballsToPlay != 0) {
            Bowler bowler = queue.peek();
            bowlerOrder.add(bowler.getName());
            bowler.setNoOfBalls(bowler.getNoOfBalls() - 1);
            queue.maxHeapify(1);
            ballsToPlay--;
        }
        return bowlerOrder;
    }
}