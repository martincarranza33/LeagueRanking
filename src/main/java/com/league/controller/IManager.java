package com.league.controller;

import com.league.model.ITeam;
import com.league.view.processor.model.IInputModel;

import java.util.Map;

/**
 * Interface that defines the behaviour for a Manager
 */
public interface IManager {
    /**
     * Operation that adds a result from a match into the league
     * based on the goals scored from both teams
     *
     * @param inputModel Object that holds the input from the user
     */
    public void addResult(IInputModel inputModel);

    /**
     * Operation that will print the table based on the teams curren place
     * in the league, does operations to calculate current rank number
     */
    public void printTable();

    /**
     * Provides access to the map that holds the map with the teams
     * @return Map with an String as Key (team name) and
     * an implementation of ITeam as a value
     */
    public Map<String, ? extends ITeam> getTeams();

}
