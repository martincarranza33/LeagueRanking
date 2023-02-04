package com.league.model;

/**
 * Interface that defines the behaviour for a Team
 */
public interface ITeam extends Comparable<ITeam>{
    /**
     * Returns the Team name
     * @return team Name
     */
    public String getName();

    /**
     * Returns the Team points
     * @return team points
     */
    public int getPoints();

    /**
     * Increases the wins by one
     * and the points by sport value
     */
    public void addWin();

    /**
     * Increases the draws by one
     * and the points by sport value
     */
    public void addDraw();

    /**
     * Increases the losses by one
     * and the points by sport value
     */
    public void addLoss();

}
