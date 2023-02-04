package com.league.view.processor;

import com.league.exceptions.MalformedStringMatch;
import com.league.view.processor.model.IInputModel;
import com.league.view.processor.model.InputModel;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InputProcessor implements IInputProcessor{
    /**
     * Method that processes the input string and returns an instance
     * with the match in form of an input Model
     * @param inputString input string with the data provided by the user
     * @return IInputModel instance with the match information
     */
    @Override
    public IInputModel processInput(String inputString) throws MalformedStringMatch {
        String[] teamsValue = inputString.trim().split(",");
        if(teamsValue.length != 2){
            throw new MalformedStringMatch("Expected two teams with one number as a score separated by one comma(,)");
        }
        String teamOne = teamsValue[0];
        String teamTwo = teamsValue[1];
        String [] teamScore = teamOne.trim().split(" ");
        String score = teamScore[teamScore.length - 1];
        String teamName = Arrays.stream(teamScore).skip(0).limit(teamScore.length-1).reduce("", (partialString, element) -> partialString + element);
        String [] teamScoreTwo = teamTwo.trim().split(" ");
        String scoreTwo = teamScoreTwo[teamScoreTwo.length - 1];
        String teamNameTwo = Arrays.stream(teamScoreTwo).skip(0).limit(teamScoreTwo.length-1).reduce("", (partialString, element) -> partialString + element);
        Integer intScoreOne;
        Integer intScoreTwo;
        try {
            intScoreOne = Integer.valueOf(score);
            intScoreTwo = Integer.valueOf(scoreTwo);
        }catch (NumberFormatException e) {
            throw new MalformedStringMatch("Its expected the number value for score to be an Integer placed after the Team name");
        }
        IInputModel result = new InputModel(teamName, teamNameTwo, intScoreOne, intScoreTwo);
        return result;
    }
}
