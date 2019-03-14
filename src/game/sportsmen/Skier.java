package game.sportsmen;

import utilities.Point;

public class Skier {
    private String name;
    private Point currentLocation;
    private double maxSpeed;
    private double acceleration;
    private double currentSpeed;
    private String qualification;
    private String gender;
    private double age;
    private String league;


    /**
     * Skier's construcrot
     * @param name
     * @param maxSpeed
     * @param age
     * @param acceleration
     * @param qualification
     * @param gender
     * @param league
     */
    public Skier(String name, double maxSpeed, double age, double acceleration,
                 String qualification, String gender, String league){
        this.setName(name);
        this.setMaxSpeed(maxSpeed);
        this.setAge(age);
        this.setAcceleration(acceleration);
        this.setQualification(qualification);
        this.setGender(gender);
        this.setLeague(league);
    }


    //get
    public double getMaxSpeed(){return maxSpeed;}
    public double getCurrentSpeed(){return currentSpeed;}


    //set
    public void setCurrentSpeed(double currentSpeed){this.currentSpeed = currentSpeed;}
    public void setName(String name){ this.name = name; }
    public void setMaxSpeed(double maxSpeed){this.maxSpeed = maxSpeed; }
    public void setAge(double age){this.age = age;}
    public void setAcceleration(double acceleration){this.acceleration = acceleration;}
    public void setQualification(String qualification){this.qualification = qualification;}
    public void setGender(String gender){this.gender = gender;}
    public void setLeague(String league){this.league = league;}

    /**
     * set the Current location  to start point.
     * @param start
     */
    public void initRace(Point start){
        this.currentLocation.setX(start.getX());
        this.currentLocation.setY(0);
    }

    /**
     * accelerate if not at top speed – currSpeed += acceleration*friction.
     * move forward: currLocation.x += currSpeed (y is always 0 for now)
     * returns false if crossed finish line
     * @param finish
     * @param friction
     * @return false if passed the finish line, else true.
     */
    public boolean move(Point finish, double friction){
        // check's if can take a move
        if (this.getCurrentSpeed() < this.getMaxSpeed()){
            this.setCurrentSpeed(this.getCurrentSpeed() + this.acceleration * friction);
        }

        // set new location
        currentLocation.setX(currentLocation.getX() + currentSpeed);

        // check's if racer crossed finish line
        this.currentLocation.setX(this.currentLocation.getX() + this.currentSpeed);
        if (this.currentLocation.getX() >= finish.getX())
            return false;
        return true;
    }
}
