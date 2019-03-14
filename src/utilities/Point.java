package utilities;

public class Point {
    private double x;
    private double y;
    private final static double MIN_X = 0;
    private final static double MAX_X = 10000000;
    private final static double MIN_Y = 0;
    private final static double MAX_Y = 800;

    /**
     * Point's constructor
     * @param x
     * @param y
     */
    public Point(double x, double y){ //x in range 0-1000000, y in range 0-800
        if (((x >= MIN_X) && (x <= MAX_X)) && ((y >= MIN_Y) && (y <= MAX_Y))) {
            this.x = x;
            this.y = y;
        }
    }


    /**
     * Point's default constructor
     */
    public Point() {
        this.setX(MIN_X);
        this.setY(MIN_Y);
    }


    /**
    * Point's copy constructor
     * @param other
     * */
    public Point(Point other) {
        this();  // Rest the current instance
        if (other != null) {
            this.setX(other.getX());
            this.setY(other.getY());
        }
    }



    // Set
    /**
     * Set Coordinate x
     * @param x
     */
    public boolean setX(double x) {
        if ( x >= MIN_X && x <= MAX_X ) {
            this.x = x;
            return true;
        }
        else {
            return false;
        }
    }


    /**
     * Set Coordinate y
     * @param y
     */
    public boolean setY(double y) {
        if ( y >= MIN_Y && y <= MAX_Y ) {
            this.y = y;
            return true;
        }
        else {
            return false;
        }
    }

    // Get
    /**
     * @return Coordinate x
     */
    public double getX() {
        return x;
    }


    /**
     * @return Coordinate y
     */
    public double getY() {
        return y;
    }


    /**
     * to string
     * @return
     */
    public String toString() {
        return "(" + getX() + "," + getY() + ")";
    }
}


