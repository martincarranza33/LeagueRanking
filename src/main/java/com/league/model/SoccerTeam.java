package com.league.model;
/**
 * Class that implements @ITeam and provides
 * functionality to its contract
 */
public class SoccerTeam implements ITeam {

    /**
     * Team name
     */
    private String name;
    /**
     * Team number of loss matches
     */
    private Integer losses;

    /**
     * Team number of win matches
     */
    private Integer wins;

    /**
     * Team number of draw matches
     */
    private Integer draws;

    /**
     * Team number of points acquired
     */
    private Integer points;

    /**
     * Constructor initializes the instance for a new team
     * @param name Team name param
     */
    public SoccerTeam(String name){
        this.name = name;
        this.losses = 0;
        this.wins = 0;
        this.draws = 0;
        this.points = 0;
    }

    /**
     * Returns the Soccer Team name
     * @return name Soccer Te
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Returns the Soccer Team points
     * @return points Soccer Team points
     */
    @Override
    public int getPoints() {
        return points;
    }

    /**
     * Increases the Soccer team wins by one
     * and increases the Soccer team points by 3
     */
    @Override
    public void addWin() {
        this.points += 3;
        this.wins++;
    }

    /**
     * Increases the Soccer team draws by one
     * and increases the Soccer team points by one
     */
    @Override
    public void addDraw() {
        this.points++;
        this.draws++;
    }

    /**
     * Increases the Soccer team losses by one
     *
     */
    @Override
    public void addLoss() {
        this.losses++;
    }

    /**
     * Overrides implementation for toString from @Object
     * @return a String that holds the name and its points
     */
    @Override
    public String toString() {
        return new StringBuilder()
                .append(this.name)
                .append(", ")
                .append(this.points)
                .append(this.points == 1 ? " pt": " pts")
                .toString();
    }

    /**
     * Compares a team to another by its points
     * @param t the object to be compared.
     * @return a negative integer, zero, or a positive integer
     * as this object is less than, equal to,
     * or greater than the specified object.
     */
    @Override
    public int compareTo(ITeam t) {
        return t.getPoints() - this.points;
    }
}