package com.league.view.processor.model;

/**
 * Abstraction that will model the expected input
 * implements @IInputModel
 */
public class InputModel implements IInputModel{

    /**
     * String that holds the first Team name
     */
    private String firstTeamName;

    /**
     * String that holds the second Team name
     */
    private String secondTeamName;

    /**
     * Integer that holds the first Team score
     */
    private Integer firstTScore;

    /**
     * Integer that holds the second Team score
     */
    private Integer secondTScore;

    /**
     * Constructor that initializes the object state
     * @param firstTeamName First Team Name
     * @param secondTeamName Second Team Name
     * @param firstTScore First Team Score
     * @param secondTScore Second Team Score
     */
    public InputModel(String firstTeamName, String secondTeamName, Integer firstTScore, Integer secondTScore){
        this.firstTeamName = firstTeamName;
        this.secondTeamName = secondTeamName;
        this.firstTScore = firstTScore;
        this.secondTScore = secondTScore;
    }

    /**
     * Returns the First Team Name
     * @return String with the first team Name
     */
    @Override
    public String getFirstTeamName() {
        return firstTeamName;
    }
    /**
     * Returns the Second Team Name
     * @return String with the first team Name
     */
    @Override
    public String getSecondTeamName() {
        return secondTeamName;
    }
    /**
     * Returns the First Team Score
     * @return Integer with the first team score
     */
    @Override
    public Integer getFirstTScore() {
        return firstTScore;
    }
    /**
     * Returns the Second Team Score
     * @return Integer with the second team score
     */
    @Override
    public Integer getSecondTScore() {
        return secondTScore;
    }

    @Override
    public String toString() {
        return "InputModel{" +
                "firstTeamName='" + firstTeamName + '\'' +
                ", secondTeamName='" + secondTeamName + '\'' +
                ", firstTScore=" + firstTScore +
                ", secondTScore=" + secondTScore +
                '}';
    }
}
