package game.arenas;

import game.sportsmen.Skier;
import game.sportsmen.SunshineSkier;
import game.sportsmen.Snowboarder;
import java.util.ArrayList;

import utilities.Point;


/*
 * Extreme Skiing Arena
 * Coefficient of friction - const 0.4
 * Suitable for - Skier, SunshineSkier, Snowboarder
 * Up to 6 competitors
 */

public class ExtremeSkiingArena {
    private ArrayList <Skier> skiers = new ArrayList<Skier>();
    private ArrayList <SunshineSkier> sunshineSkiers = new ArrayList<SunshineSkier>();
    private ArrayList <Snowboarder> snowboarders = new ArrayList<Snowboarder>();
    private ArrayList <Object> finished = new ArrayList<>();
    private Point start;
    private Point finish;
    private final double FRICTION = 0.4;
    private final int MAX_RACERS = 6;
    private String surface;
    private String condition;
    private String discipline;

    /**
     * ExtremeSkiingArena constructor
     * @param start
     * @param finish
     * @param surface
     * @param condition
     * @param discipline
     */
    public ExtremeSkiingArena(Point start, Point finish, String surface, String condition, String discipline){
        this.start = new Point(start);
        this.finish = new Point(finish);
        this.surface = surface;
        this.condition = condition;
        this.discipline = discipline;
    }


    /**
     * default constructor
     */
    public ExtremeSkiingArena(){
        this.start = new Point();
        this.finish = new Point();
        this.surface = "null";
        this.condition = "null";
        this.discipline = "null";
    }


    //get
    public Point getStart(){return start;}
    public Point getFinish(){return finish;}
    public double getFRICTION(){
        return FRICTION;
    }



    /**
     * Adds skier to the arena
     * @param newCompetitor
     * @return true if matching and added, else false.
     */
    private boolean add(Skier newCompetitor){
        if (newCompetitor != null && (skiers.size() + sunshineSkiers.size() + snowboarders.size())< MAX_RACERS){
            skiers.add(newCompetitor);
            return true;
        }
        return false;
    }


    /**
     * Adds sunshineSkier to the arena
     * @param newsunshineSkier
     * @return true if matching and added, else false.
     */
    private boolean add(SunshineSkier newsunshineSkier){
        if (newsunshineSkier != null && (skiers.size() + sunshineSkiers.size() + snowboarders.size())< MAX_RACERS){
            sunshineSkiers.add(newsunshineSkier);
            return true;
        }
        return false;
    }


    /**
     * Adds snowboarder to the arena
     * @param newsnowboarder
     * @return true if matching and added, else false.
     */
    private boolean add(Snowboarder newsnowboarder){
        if (newsnowboarder != null && (skiers.size() + sunshineSkiers.size() + snowboarders.size())< MAX_RACERS){
            snowboarders.add(newsnowboarder);
            return true;
        }
        return false;
    }


    /**
     * Adds sportsmen who has finished the race to the finish lists.
     * The racer from type Skier.
     * @param sportsmen
     * @return sportsmen's position in the list
     */
    private int crossFinishLine(Skier sportsmen){
        if (sportsmen != null) {
            finished.add(sportsmen);
        }
        return finished.size();
    }


    /**
     * Adds sportsmen who has finished the race to the finish lists.
     * The racer from type Skier.
     * @param sportsmen
     * @return sportsmen's position in the list
     */
    private int crossFinishLine(SunshineSkier sportsmen){
        if (sportsmen != null) {
            finished.add(sportsmen);
        }
        return finished.size();
    }


    /**
     * Adds sportsmen who has finished the race to the finish lists.
     * The racer from type Skier.
     * @param sportsmen
     * @return sportsmen's position in the list
     */
    private int crossFinishLine(Snowboarder sportsmen){
        if (sportsmen != null) {
            finished.add(sportsmen);
        }
        return finished.size();
    }


    /**
     * Initialized each racer to the start point in the arena
     */
    public void initRace(){
        for(Skier races: skiers)
            races.initRace(this.getStart());
        for(SunshineSkier races: sunshineSkiers)
            races.initRace(this.getStart());
        for(Snowboarder races: snowboarders)
            races.initRace(this.getStart());
    }

    /**
     * moves all the sportsmen and remove those who have finished
     */
    public void playTurn() {
        for(Skier racer: skiers)
            racer.move(getFinish(), FRICTION);

        for(SunshineSkier racer: sunshineSkiers)
            racer.move(getFinish(), FRICTION);

        for(Snowboarder racer: snowboarders)
            racer.move(getFinish(), FRICTION);

        // check's who is finish the race
        for(Object racer: finished) {
            if (racer instanceof Skier)
                skiers.remove((Skier) racer);
            else if (racer instanceof SunshineSkier)
                sunshineSkiers.remove((SunshineSkier) racer);
            else
                snowboarders.remove((Snowboarder) racer);
        }
    }
}
