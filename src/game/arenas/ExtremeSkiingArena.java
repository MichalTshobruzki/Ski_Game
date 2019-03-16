package game.arenas;

import game.sportsmen.Skier;
import game.sportsmen.SunshineSkier;
import game.sportsmen.Snowboarder;
import java.util.ArrayList;

import utilities.Point;


public class ExtremeSkiingArena {
    private ArrayList<Skier> skiers = new ArrayList<Skier>();
    private ArrayList<SunshineSkier> sunshineSkiers = new ArrayList<SunshineSkier>();
    private ArrayList<Snowboarder> snowboarders = new ArrayList<Snowboarder>();
    private ArrayList<Object> finished = new ArrayList<>();
    private Point start;
    private Point finish;
    private final double FRICTION = 0.4;
    private final int MAX_RACERS = 6;
    private String surface;
    private String condition;
    private String discipline;


    /**
     * ExtremeSkiingArena constructor
     *
     * @param start
     * @param finish
     * @param surface
     * @param condition
     * @param discipline
     */
    public ExtremeSkiingArena(Point start, Point finish, String surface, String condition, String discipline) {
        this.start = new Point(start);
        this.finish = new Point(finish);
        this.surface = surface;
        this.condition = condition;
        this.discipline = discipline;
    }


    /**
     * default constructor
     */
    public ExtremeSkiingArena() {
        this.start = new Point();
        this.finish = new Point();
        this.surface = "null";
        this.condition = "null";
        this.discipline = "null";
    }


    //set
    public void setSkiers(ArrayList<Skier> skiers) {
        this.skiers = skiers;
    }
    public void setSunshineSkiers(ArrayList<SunshineSkier> sunshineSkiers) {
        this.sunshineSkiers = sunshineSkiers;
    }
    public void setSnowboarders(ArrayList<Snowboarder> snowboarders) {
        this.snowboarders = snowboarders;
    }
    public void setFinished(ArrayList<Object> finished) {
        this.finished = finished;
    }
    public void setStart(Point start) {
        this.start = start;
    }
    public void setFinish(Point finish) {
        this.finish = finish;
    }
    public void setSurface(String surface) {
        this.surface = surface;
    }
    public void setCondition(String condition) {
        this.condition = condition;
    }
    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }



    //get
    public Point getStart() {
        return start;
    }
    public Point getFinish() {
        return finish;
    }
    public double getFRICTION() {
        return FRICTION;
    }
    public ArrayList<Skier> getSkiers() {
        return skiers;
    }
    public ArrayList<SunshineSkier> getSunshineSkiers() {
        return sunshineSkiers;
    }
    public ArrayList<Snowboarder> getSnowboarders() {
        return snowboarders;
    }
    public ArrayList<Object> getFinished() {
        return finished;
    }
    public int getMAX_RACERS() {
        return MAX_RACERS;
    }
    public String getSurface() {
        return surface;
    }
    public String getCondition() {
        return condition;
    }
    public String getDiscipline() {
        return discipline;
    }



    @Override
    public String toString() {
        return "ExtremeSkiingArena{" +
                "skiers=" + skiers +
                ", sunshineSkiers=" + sunshineSkiers +
                ", snowboarders=" + snowboarders +
                ", finished=" + finished +
                ", start=" + start +
                ", finish=" + finish +
                ", FRICTION=" + FRICTION +
                ", MAX_RACERS=" + MAX_RACERS +
                ", surface='" + surface + '\'' +
                ", condition='" + condition + '\'' +
                ", discipline='" + discipline + '\'' +
                '}';
    }


    /**
     * Adds skier to the arena
     * @param newCompetitor
     * @return true if matching and added, else false.
     */
    public boolean add(Skier newCompetitor) {
        if (newCompetitor != null && (skiers.size() + sunshineSkiers.size() + snowboarders.size()) < MAX_RACERS) {
            skiers.add(newCompetitor);
            return true;
        }
        return false;
    }


    /**
     * Adds sunshineSkiers to the arena
     * @param newCompetitor
     * @return true if matching and added, else false.
     */
    public boolean add(SunshineSkier newCompetitor) {
        if (newCompetitor != null && (skiers.size() + sunshineSkiers.size() + snowboarders.size()) < MAX_RACERS) {
            sunshineSkiers.add(newCompetitor);
            return true;
        }
        return false;
    }


    /**
     * Adds snowboarders to the arena
     * @param newCompetitor
     * @return true if matching and added, else false.
     */
    public boolean add(Snowboarder newCompetitor) {
        if (newCompetitor != null && (skiers.size() + sunshineSkiers.size() + snowboarders.size()) < MAX_RACERS) {
            snowboarders.add(newCompetitor);
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
    public int crossFinishLine(Skier sportsmen) {
        if (sportsmen != null) {
            finished.add(sportsmen);
        }
        skiers.remove(sportsmen);
        return finished.size();
    }



    /**
     * Adds sportsmen who has finished the race to the finish lists.
     * The racer from type SunshineSkier.
     * @param sportsmen
     * @return sportsmen's position in the list
     */
    public int crossFinishLine(SunshineSkier sportsmen) {
        if (sportsmen != null) {
            finished.add(sportsmen);
        }
        sunshineSkiers.remove(sportsmen);
        return finished.size();
    }


    /**
     * Adds sportsmen who has finished the race to the finish lists.
     * The racer from type Snowboarder.
     * @param sportsmen
     * @return sportsmen's position in the list
     */
    public int crossFinishLine(Snowboarder sportsmen) {
        if (sportsmen != null) {
            finished.add(sportsmen);
        }
        snowboarders.remove(sportsmen);
        return finished.size();
    }


    /**
     * Initialized each racer to the start point in the arena
     */
    public void initRace() {
        for (Skier races : skiers)
            races.initRace(this.getStart());
        for (SunshineSkier races : sunshineSkiers)
            races.initRace(this.getStart());
        for (Snowboarder races : snowboarders)
            races.initRace(this.getStart());
    }


    /**
     * moves all the sportsmen and remove those who have finished
     */
    public boolean playTurn() {
        if (skiers.isEmpty())
            return false;
        else {
            for (int i = 0; i < skiers.size(); i++) {
                skiers.get(i).move(getFinish(), getFRICTION());
                if ((skiers.get(i).getCurrentLocation().getX() >= finish.getX()) && (skiers.get(i).getCurrentLocation().getY() >= finish.getY())) {
                    System.out.println(skiers.get(i).getName() + " has crossed finish line");
                    crossFinishLine(skiers.get(i));
                }

            }
        }

        if (sunshineSkiers.isEmpty())
            return false;
        else {
            for (int i = 0; i < sunshineSkiers.size(); i++) {
                sunshineSkiers.get(i).move(getFinish(), getFRICTION());
                if ((sunshineSkiers.get(i).getCurrentLocation().getX() >= finish.getX()) && (sunshineSkiers.get(i).getCurrentLocation().getY() >= finish.getY())) {
                    System.out.println(sunshineSkiers.get(i).getName() + " has crossed finish line");
                    crossFinishLine(sunshineSkiers.get(i));
                }

            }
        }

        if (snowboarders.isEmpty())
            return false;
        else {
            for (int i = 0; i < snowboarders.size(); i++) {
                snowboarders.get(i).move(getFinish(), getFRICTION());
                if ((snowboarders.get(i).getCurrentLocation().getX() >= finish.getX()) && (snowboarders.get(i).getCurrentLocation().getY() >= finish.getY())) {
                    System.out.println(snowboarders.get(i).getName() + " has crossed finish line");
                    crossFinishLine(snowboarders.get(i));
                }
            }
        }
        return true;
    }
}




