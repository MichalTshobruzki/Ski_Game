package game.sportsmen;

import utilities.Point;

/**
 * Maximum speed- 80
 * acceleration- 7
 */

public class Skier {
    private String name;
    private Point currentLocation;
    private double maxSpeed = 80;
    private double acceleration = 7;
    private double currentSpeed;
    private String qualification;
    private String gender;
    private double age;
    private String league;

    /**
     *
     * @param start
     */
    public void initRace(Point start){
      //  this.currentLocation = new Point()
        this.currentLocation.setX(start.getX());
        this.currentLocation.setY(0);
    }

    public boolean move(Point finish, double friction){
        if (this.currentSpeed < this.maxSpeed){
            this.currentSpeed += this.acceleration * getFriction();
        }
        this.currentLocation.setX(this.currentLocation.getX() + this.currentSpeed);
        if (this.currentLocation.getX() >= getFinish())
            return false;
        return true;
    }
}
