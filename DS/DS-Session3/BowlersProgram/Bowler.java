/**
 * It will represent bowlers information
 * 
 * @author Shubham Jain
 *
 */
public class Bowler {
    private String name;
    private int noOfBalls;

    public Bowler(int noOfBalls, String name) {
        if (noOfBalls < 0) {
            throw new AssertionError("No of Balls can't be negative");
        }
        if (name == null) {
            throw new NullPointerException("Bowler Name can't be Null");
        }
        this.name = name;
        this.noOfBalls = noOfBalls;
    }

    /**
     * It will returns bowlers name
     * 
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * It will returns number of balls remaning to be bowled by bowler
     * 
     * @return
     */
    public int getNoOfBalls() {
        return noOfBalls;
    }

    /**
     * It will set the number of balls of bowler
     * 
     * @param noOfBalls
     */
    public void setNoOfBalls(int noOfBalls) {
        this.noOfBalls = noOfBalls;
    }

    /**
     * It will set the name of bowler
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}