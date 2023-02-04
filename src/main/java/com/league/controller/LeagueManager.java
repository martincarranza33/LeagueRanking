package com.league.controller;

import com.league.model.ITeam;
import com.league.model.SoccerTeam;
import com.league.view.processor.model.IInputModel;

import java.util.*;

/**
 * Class that implements @IManager and provides
 * functionality to its contract
 */
public class LeagueManager implements IManager {
    /**
     * List that contains the teams involved in the league
     */
    private Map<String, ITeam> teams;

    /**
     * Constructor that initializes the teams list
     */
    public LeagueManager() {
        teams = new HashMap<>();
    }

    /**
     * Operation that adds a result from a match into the league
     * based on the goals scored from both teams
     *
     * @param inputModel with the data from the user
     */
    @Override
    public void addResult(IInputModel inputModel) {
        ITeam teamO = getOrCreateTeam(inputModel.getFirstTeamName());
        ITeam teamT = getOrCreateTeam(inputModel.getSecondTeamName());
        if (inputModel.getFirstTScore() > inputModel.getSecondTScore()) {
            teamO.addWin();
            teamT.addLoss();
        } else if(inputModel.getFirstTScore() == inputModel.getSecondTScore()){
            teamO.addDraw();
            teamT.addDraw();
        } else {
            teamO.addLoss();
            teamT.addWin();
        }
    }

    /**
     * Operation that will print the table based on the teams curren place
     * in the league, does operations to calculate current rank number
     */
    @Override
    public void printTable() {
        List<Map.Entry<String, ITeam>> list = new ArrayList<>(teams.entrySet());
        list.sort(Map.Entry.comparingByValue());
        int position = 1;
        int previousTeamPoints = 0;
        int stepForNewPosition = 0;
        for (Map.Entry<String, ITeam> team: list) {
            if(previousTeamPoints > team.getValue().getPoints()) {
                position += stepForNewPosition;
                stepForNewPosition = 1;
            } else {
                stepForNewPosition++;
            }
            System.out.format("%d. %s\n", position, team.getValue());
            previousTeamPoints = team.getValue().getPoints();
        }
    }

    /**
     * Private method that will create/retrieve a team from the teams list
     * based on its name
     * @param teamName - team name to create/retrieve
     * @return the team Instance found or created
     */
    private ITeam getOrCreateTeam(String teamName) {
        Optional<ITeam> selectedTeam = Optional.ofNullable(teams.get(teamName));
        if(selectedTeam.isPresent()) {
            return selectedTeam.get();
        } else {
            ITeam newTeam  = new SoccerTeam(teamName);
            teams.put(teamName, newTeam);
            return newTeam;
        }
    }

    /**
     * Method that provides access to the teams member
     * @return Map with key as string team name and value
     */
    public Map<String, ITeam> getTeams(){
        return teams;
    }

}