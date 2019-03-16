package game;
import game.Competition;
import game.sportsmen.*;

public class GameEngine {
    private Competition comp;
    private GameEngine instance;
    private static GameEngine ourInstance = new GameEngine();
    public static GameEngine getInstance() {
        return ourInstance;
    }
    protected GameEngine() {
    }


    //get
    public Competition getComp() {
        return comp;
    }


    //set
    public void setComp(Competition comp) {
        this.comp = comp;
    }


    /**
     * call setArena on competition
     * @param arena
     * @return
     */
    public boolean setArena(Object arena){
        return getComp().setArena(arena);
    }


    /**
     *  call initRace on competition
     */
    public void initRace(){
        getComp().initRace();
    }


    /**
     * invoke add function in Competition
     * @param newRacer
     * @return
     */
    public boolean addRacer(Object newRacer){
//        if (newRacer instanceof OldTimer)
//            return getComp().add((OldTimer) newRacer);
        if (newRacer instanceof Skier)
            return getComp().add((Skier)newRacer);
//        if (newRacer instanceof Snowbiker)
//            return getComp().add((Snowbiker) newRacer);
//        if (newRacer instanceof Snowboarder)
//            return getComp().add((Snowboarder) newRacer);
//        if (newRacer instanceof SnowBunny)
//            return getComp().add((SnowBunny) newRacer);
//        if (newRacer instanceof SunshineSkier)
//            return getComp().add((SunshineSkier) newRacer);
        return false;
    }


    /**
     * loops on comptition.playTurn until race is finished
     */
    public void startRace(){
        int i = 0;
        while(getComp().playTurn()){
            System.out.println("step" + i);
            i++;
        }
        System.out.println("Race is over");
    }

}
