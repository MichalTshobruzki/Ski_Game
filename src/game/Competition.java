package game;
import game.arenas.AlpineSkiingArena;
import game.arenas.ArenaType;
import game.arenas.ExtremeSkiingArena;
import game.arenas.FreeSkiingArena;

import game.sportsmen.Skier;
import game.sportsmen.Snowboarder;
import game.sportsmen.SunshineSkier;
import game.sportsmen.OldTimer;
import game.sportsmen.Snowbiker;
import game.sportsmen.SnowBunny;



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


    /**
     * Competition copy constructor
     * @param comp
     */
    public Competition(Competition comp){
        if (comp != null) {
            this.setMinAge(comp.minAge);
            this.setLeague(comp.league);
            this.setGender(comp.gender);
            this.setQualification(comp.qualification);
        }
    }


    //set
    public void setMinAge(double minAge){this.minAge = minAge;}
    public void setLeague(String league){this.league = league;}
    public void setGender(String gender){this.gender = gender;}
    public void setQualification(String qualification){this.qualification = qualification;}
    public void setCurrentArena(Object currentArena){this.currentArena = currentArena;}
    public void setArenaType(ArenaType arenaType){this.arenaType = arenaType;}


    //get
    public ArenaType getArenaType(){return arenaType;}
    public Object getCurrentArena(){return currentArena;}
    public double getMinAge(){return minAge;}
    public String getGender() {return gender; }
    public String getLeague() { return league;}
    public String getQualification() { return qualification; }


    @Override
    public String toString() {
        return "Competition{" +
                "arenaType=" + arenaType +
                ", currentArena=" + currentArena +
                ", minAge=" + minAge +
                ", gender='" + gender + '\'' +
                ", league='" + league + '\'' +
                ", qualification='" + qualification + '\'' +
                '}';
    }


    /**
     *call initRace on current arena
     */
    public void initRace(){
        if (this.getArenaType() == ArenaType.EXTRIM_SKIING_ARENA )
            ((ExtremeSkiingArena)currentArena).initRace();
        if (this.getArenaType() == ArenaType.ALPINE_SKIING_ARENA )
            ((AlpineSkiingArena)currentArena).initRace();
        if (this.getArenaType() == ArenaType.FREE_SKIING_ARENA )
            ((FreeSkiingArena)currentArena).initRace();
    }


    /**
     * sets arenaType and activeArena by instance type in competition
     * @param arena
     * @return true for set, else fslse
     */
    public boolean setArena(Object arena){
        if (this.getArenaType() == ArenaType.ALPINE_SKIING_ARENA ) {
            setArenaType(ArenaType.ALPINE_SKIING_ARENA);
            setCurrentArena((AlpineSkiingArena)arena);
            return true;
        }
        if (this.getArenaType() == ArenaType.FREE_SKIING_ARENA ) {
            setArenaType(ArenaType.FREE_SKIING_ARENA);
            setCurrentArena((FreeSkiingArena)arena);
            return true;
        }
        if(this.getArenaType() == ArenaType.EXTRIM_SKIING_ARENA){
            setArenaType(ArenaType.EXTRIM_SKIING_ARENA);
            setCurrentArena((ExtremeSkiingArena)arena);
            return true;
        }
        return false;
    }



    /**
     * checks if the sportsman is a valid competitor.
     * This method should be written for each kind of sportsman.
     * @param sportsman
     * @return false for not proper arena, else- true
     */
    public boolean validCompetitor(OldTimer sportsman){
        if (this.arenaType != ArenaType.FREE_SKIING_ARENA){
            System.out.println("not proper arena");
            return false;
        }
        else{
            if(minAge <= sportsman.getAge() && gender == sportsman.getGender() && league == sportsman.getLeague()
                    && qualification == sportsman.getQualificatio())
                return true;
            else{
                System.out.println("not valid competitor");
                return false;
            }
        }
    }


    /**
     * checks if the sportsman is a valid competitor.
     * This method should be written for each kind of sportsman.
     * @param sportsman
     * @return false for not proper arena, else- true
     */
    public boolean validCompetitor(Skier sportsman){
        if (this.arenaType != ArenaType.EXTRIM_SKIING_ARENA){
            System.out.println("not proper arena");
            return false;
        }
        else{
            if(minAge <= sportsman.getAge() && gender == sportsman.getGender() && league == sportsman.getLeague()
                    && qualification == sportsman.getQualification())
                return true;
            else{
                System.out.println("not valid competitor");
                return false;
            }
        }
    }



    /**
     * checks if the sportsman is a valid competitor.
     * This method should be written for each kind of sportsman.
     * @param sportsman
     * @return false for not proper arena, else- true
     */
    public boolean validCompetitor(Snowbiker sportsman){
        if (this.arenaType != ArenaType.ALPINE_SKIING_ARENA){
            System.out.println("not proper arena");
            return false;
        }
        else{
            if(minAge <= sportsman.getAge() && gender == sportsman.getGender() && league == sportsman.getLeague()
                    && qualification == sportsman.getQualification())
                return true;
            else{
                System.out.println("not valid competitor");
                return false;
            }
        }
    }



    /**
     * checks if the sportsman is a valid competitor.
     * This method should be written for each kind of sportsman.
     * @param sportsman
     * @return false for not proper arena, else- true
     */
    public boolean validCompetitor(Snowboarder sportsman){
        if (this.arenaType != ArenaType.EXTRIM_SKIING_ARENA){
            System.out.println("not proper arena");
            return false;
        }
        else{
            if(minAge <= sportsman.getAge() && gender == sportsman.getGender() && league == sportsman.getLeague()
                    && qualification == sportsman.getQualification())
                return true;
            else{
                System.out.println("not valid competitor");
                return false;
            }
        }
    }


    /**
     * checks if the sportsman is a valid competitor.
     * This method should be written for each kind of sportsman.
     * @param sportsman
     * @return false for not proper arena, else- true
     */
    public boolean validCompetitor(SnowBunny sportsman){
        if (this.arenaType != ArenaType.ALPINE_SKIING_ARENA){
            System.out.println("not proper arena");
            return false;
        }
        else{
            if(minAge <= sportsman.getAge() && gender == sportsman.getGender() && league == sportsman.getLeague()
                    && qualification == sportsman.getQualification())
                return true;
            else{
                System.out.println("not valid competitor");
                return false;
            }
        }
    }



    /**
     * checks if the sportsman is a valid competitor.
     * This method should be written for each kind of sportsman.
     * @param sportsman
     * @return false for not proper arena, else- true
     */
    public boolean validCompetitor(SunshineSkier sportsman){
        if (this.arenaType != ArenaType.EXTRIM_SKIING_ARENA && this.arenaType != ArenaType.ALPINE_SKIING_ARENA){
            System.out.println("not proper arena");
            return false;
        }
        else{
            if(minAge <= sportsman.getAge() && gender == sportsman.getGender() && league == sportsman.getLeague()
                    && qualification == sportsman.getQualification())
                return true;
            else{
                System.out.println("not valid competitor");
                return false;
            }
        }
    }


    /**
     * call add method in the currentArena Object if the sportsman is valid competitor.
     * @param sportsman
     * @return true for success , else false
     */
    public boolean add(OldTimer sportsman){
        if (validCompetitor(sportsman))
            return ((FreeSkiingArena)currentArena).add(sportsman);
        return false;
    }


    /**
     * call add method in the currentArena Object if the sportsman is valid competitor.
     * @param sportsman
     * @return true for success , else false
     */
    public boolean add(Skier sportsman){
        if (validCompetitor(sportsman))
            return ((ExtremeSkiingArena)currentArena).add(sportsman);
        return false;
    }


    /**
     * call add method in the currentArena Object if the sportsman is valid competitor.
     * @param sportsman
     * @return true for success , else false
     */
    public boolean add(Snowbiker sportsman){
        if (validCompetitor(sportsman))
            return ((AlpineSkiingArena)currentArena).add(sportsman);
        return false;
    }


    /**
     * call add method in the currentArena Object if the sportsman is valid competitor.
     * @param sportsman
     * @return true for success , else false
     */
    public boolean add(Snowboarder sportsman){
        if (validCompetitor(sportsman))
            return ((ExtremeSkiingArena)currentArena).add(sportsman);
        return false;
    }



    /**
     * call add method in the currentArena Object if the sportsman is valid competitor.
     * @param sportsman
     * @return true for success , else false
     */
    public boolean add(SunshineSkier sportsman){
        if (validCompetitor(sportsman)) {
            if (this.arenaType == ArenaType.EXTRIM_SKIING_ARENA){
                return ((ExtremeSkiingArena)currentArena).add(sportsman);
            }
            else if(this.arenaType == ArenaType.ALPINE_SKIING_ARENA)
                return ((AlpineSkiingArena)currentArena).add(sportsman);
            else
                return false;
        }
        return false;
    }


    /**
     * call the currentArena object playTurn method, returns currentArena.playTurn.
     * @return
     */
    public boolean playTurn(){
        if (this.getArenaType() == ArenaType.EXTRIM_SKIING_ARENA ) {
            ((ExtremeSkiingArena) currentArena).playTurn();
            return true;
        }
        if (this.getArenaType() == ArenaType.ALPINE_SKIING_ARENA ) {
            ((AlpineSkiingArena) currentArena).playTurn();
            return true;
        }
        if (this.getArenaType() == ArenaType.FREE_SKIING_ARENA ) {
            ((FreeSkiingArena) currentArena).playTurn();
            return true;
        }
        else
            return false;
    }
}
