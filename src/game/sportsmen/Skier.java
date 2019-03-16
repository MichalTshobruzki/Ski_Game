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

    @Override
    public String toString() {
        return "Skier{" +
                "name='" + name + '\'' +
                ", currentLocation=" + currentLocation +
                ", maxSpeed=" + maxSpeed +
                ", acceleration=" + acceleration +
                ", currentSpeed=" + currentSpeed +
                ", qualification='" + qualification + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", league='" + league + '\'' +
                '}';
    }


    //get
    public double getMaxSpeed(){return maxSpeed;}
    public double getCurrentSpeed(){return currentSpeed;}
    public String getName(){return name;};
    public Point getCurrentLocation(){return currentLocation;}
    public double getAcceleration(){return acceleration;}
    public String getQualification(){return qualification;}
    public String getLeague(){return league;}
    public String getGender(){return gender;}
    public double getAge(){return age;}

    //set
    public void setCurrentSpeed(double currentSpeed){this.currentSpeed = currentSpeed;}
    public void setName(String name){ this.name = name; }
    public void setMaxSpeed(double maxSpeed){this.maxSpeed = maxSpeed; }
    public void setAge(double age){this.age = age;}
    public void setAcceleration(double acceleration){this.acceleration = acceleration;}
    public void setQualification(String qualification){this.qualification = qualification;}
    public void setGender(String gender){this.gender = gender;}
    public void setLeague(String league){this.league = league;}
    public void setCurrentLocation(Point currentLocation) {this.currentLocation = new Point(currentLocation.getX(),0); }

    /**
     * set the Current location  to start point.
     * @param start
     */
    public void initRace(Point start){
        if (start != null) {
            this.setCurrentLocation(start);
        }
    }

    /**
     * accelerate if not at top speed – currSpeed += acceleration*friction.
     * move forward: currLocation.x += currSpeed (y is always 0 for now)
     * returns false if crossed finish line
     * @param finish
     * @param friction
     * @return false if passed the finish line, else true.
     */
    public boolean move(Point finish, double friction) {
        //  check's if racer crossed finish line
        if (this.currentLocation.getX() < finish.getX()) {
            currentSpeed = currentSpeed + acceleration * friction;
            if (currentSpeed > maxSpeed)
                currentSpeed = maxSpeed;
        }

        // set new location
        this.currentLocation.setX(this.currentLocation.getX() + this.currentSpeed);

        // check's if racer crossed finish line
        if (this.currentLocation.getX() >= finish.getX())
            return false;

        System.out.println(name + " my location " + getCurrentLocation() + " my speed is " + getCurrentSpeed());
        return true;
    }
}
