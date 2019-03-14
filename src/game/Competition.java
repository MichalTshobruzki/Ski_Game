package game;
import game.arenas.ArenaType;
public class Competition {
    private ArenaType arenaType;
    private Object currentArena; // holds arena object to call methods on it, i.e.
    private double minAge; // minimal age to join the competition
    private String gender;
    private String league;
    private String qualification;


    /**
     * Competition's constructor
     * @param minAge
     * @param league
     * @param gender
     * @param qualification
     */
    public Competition(double minAge, String league, String gender, String qualification){
        this.setMinAge(minAge);
        this.setLeague(league);
        this.setGender(gender);
        this.setQualification(qualification);
    }

    //set
    public void setMinAge(double minAge){this.minAge = minAge;}
    public void setLeague(String league){this.league = league;}
    public void setGender(String gender){this.gender = gender;}
    public void setQualification(String qualification){this.qualification = qualification;}
    public void setCurrentArena(Object currentArena){this.currentArena = currentArena;}


    //get
    public ArenaType getArenaType(){return arenaType;}
    public Object getCurrentArena(){return currentArena;}


    public void initRace(){
            if (getArenaType() instanceof ArenaType.EXTRIM_SKIING_ARENA ){

        }
    }

}
