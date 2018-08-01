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

    Point(double xCoordinate, double yCoordinate) {
        if (xCoordinate > xMaxCoordinate || xCoordinate < xMinCoordinate
                || yCoordinate > yMaxCoordinate || yCoordinate < yMinCoordinate) {
            throw new AssertionError(
                    "xCoordinate should be between 0 and 1080 and yCoordinate should be bewtween 0 and 720 ");
        }

        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public double getXCoordinate() {
        return xCoordinate;
    }

    public double getYCoordinate() {
        return yCoordinate;
    }

}
