/**
 * This class represent the location of PointX and PointY on a screen size of
 * 1080*720
 * 
 * @author Shubham Jain
 *
 */
public class Point {
    final private double xMaxCoordinate = 1080;
    final private double yMaxCoordinate = 720;
    final private double xMinCoordinate = 0;
    final private double yMinCoordinate = 0;
    private double xCoordinate;
    private double yCoordinate;

    /**
     * It will check whether point lies on screen or not and then initialize the
     * point
     * 
     * @param xCoordinate
     * @param yCoordinate
     */
    Point(double xCoordinate, double yCoordinate) {
        System.out.println(xCoordinate+" " + yCoordinate);
        if (xCoordinate > xMaxCoordinate || xCoordinate < xMinCoordinate
                || yCoordinate > yMaxCoordinate || yCoordinate < yMinCoordinate) {
            throw new AssertionError(
                    "xCoordinate should be between 0 and 1080 and yCoordinate should be bewtween 0 and 720 ");
        }
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    /**
     * Checking whether shape lies in screen or not
     * 
     * @param point1
     * @param point2
     * @return
     */
    public boolean isPointOnScreen(double point1, double point2) {
        if ((point1 > xMaxCoordinate || point2 > yMaxCoordinate)) {
            return false;
        }
        return true;
    }

    /**
     * Checking whether shape lies in screen or not
     * 
     * @param point1
     * @param point2
     * @return
     */
    public boolean isPointLiesOnScreen(double point1, double point2) {
        if ((point1 < xMinCoordinate || point2 < yMinCoordinate)) {
            return false;
        }
        return true;
    }

    /**
     * It will return X-Coordinate of point
     * 
     * @return
     */
    public double getXCoordinate() {
        return xCoordinate;
    }

    /**
     * It will return Y-Coordinate of point
     * 
     * @return
     */
    public double getYCoordinate() {
        return yCoordinate;
    }
}