package game.arenas;

import game.sportsmen.Skier;

import java.util.ArrayList;

import utilities.Point;

/**
 * Extreme Skiing Arena
 * Coefficient of friction - const 0.4
 * Suitable for - Skier, SunshineSkier, Snowboarder
 * Up to 6 competitors
 */

public class ExtremeSkiingArena {
    private ArrayList <Skier> Skiers = new ArrayList<Skier>();
    //ArrayList <SunshineSkier> SunshineSkiers = new ArrayList<SunshineSkier>();
    //ArrayList <Snowboarder> Snowboarders = new ArrayList<Snowboarder>();
    public Point start;
    private Point finish;
    private ArrayList <Object> finished = new ArrayList<>();
    private static double friction = 0.4;
    private int maxRaces = 6;
    private String surface;
    private String condition;
    private String discipline;

    private boolean add(Skier newCompetitor){
        if (Skiers.size()<6){
            if(newCompetitor instanceof Skier){
                Skiers.add(newCompetitor);
            }
            //else if(newCompetitor instanceof SunshineSkiers)
        }
    }
}
