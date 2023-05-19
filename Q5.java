import java.lang.Math;

public class Q5 {
    
    public static void main(String[] args) {
        double x1 = 1.0; // first x coordinate
        double y1 = 2.0; // first y coordinate
        double x2 = 4.0; // second x coordinate
        double y2 = 6.0; // second y coordinate

        double distance = calculateDistance(x1, y1, x2, y2);
        System.out.println("The distance between (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ") is " + distance + ".");
    }

    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        double xDiff = x2 - x1;
        double yDiff = y2 - y1;
        double distance = Math.sqrt(xDiff * xDiff + yDiff * yDiff);
        return distance;
    }
}
