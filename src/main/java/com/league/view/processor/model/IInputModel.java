package com.league.view.processor.model;

/**
 * Defines the behaviour on the expected input
 */
public interface IInputModel {

    /**
     * Returns the First Team Name
     * @return String with the first team Name
     */
    public String getFirstTeamName();

    /**
     * Returns the Second Team Name
     * @return String with the first team Name
     */
    public String getSecondTeamName();
    /**
     * Returns the First Team Score
     * @return Integer with the first team score
     */
    public Integer getFirstTScore();

    /**
     * Returns the Second Team Score
     * @return Integer with the second team score
     */
    public Integer getSecondTScore();
}
